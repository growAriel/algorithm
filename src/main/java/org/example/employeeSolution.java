package org.example;
    import java.util.*;

    public class employeeSolution {
        public static int[] orgReputation(int[] effList, int[] idList, int[][] empQuit) {
            int n = effList.length; // 员工数量
            int q = empQuit.length; // 天数

            // 员工ID到效率的映射（员工ID从1开始）
            int[] efficiency = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int empId = i + 1;
                efficiency[empId] = effList[i];
            }

            // 计算初始总效率
            int totalReputation = 0;
            for (int eff : effList) {
                totalReputation += eff;
            }

            // 按团队存储员工ID，使用优先队列按效率排序（效率低的在前）
            Map<Integer, PriorityQueue<Integer>> teamEmployees = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int empId = i + 1;
                int teamId = idList[i];

                teamEmployees.computeIfAbsent(teamId, k -> new PriorityQueue<>(
                        (a, b) -> {
                            // 按效率升序排序
                            if (efficiency[a] != efficiency[b]) {
                                return efficiency[a] - efficiency[b];
                            }
                            // 效率相同按ID升序排序
                            return a - b;
                        }
                )).add(empId);
            }

            // 标记员工是否已被解雇
            boolean[] isFired = new boolean[n + 1];
            int[] result = new int[q];

            // 处理每一天的解雇
            for (int day = 0; day < q; day++) {
                int firedId = empQuit[day][0];
                int k = empQuit[day][1];

                // 如果员工已被解雇，直接记录当前声誉
                if (isFired[firedId]) {
                    result[day] = totalReputation;
                    continue;
                }

                // 1. 解雇指定员工
                totalReputation -= efficiency[firedId];
                isFired[firedId] = true;

                // 2. 处理该员工所在团队的辞职
                int teamId = idList[firedId - 1];
                PriorityQueue<Integer> teamPQ = teamEmployees.get(teamId);

                if (teamPQ != null && k > 0) {
                    // 存储当前团队中未解雇的员工
                    List<Integer> activeEmployees = new ArrayList<>();

                    // 从优先队列中取出所有员工
                    while (!teamPQ.isEmpty()) {
                        int empId = teamPQ.poll();
                        if (!isFired[empId]) {
                            activeEmployees.add(empId);
                        }
                    }

                    // 按效率排序（效率低的在前）
                    activeEmployees.sort((a, b) -> {
                        if (efficiency[a] != efficiency[b]) {
                            return efficiency[a] - efficiency[b];
                        }
                        return a - b;
                    });

                    // 解雇效率最低的k个员工
                    int resignCount = 0;
                    for (int i = 0; i < activeEmployees.size() && resignCount < k; i++) {
                        int empId = activeEmployees.get(i);
                        // 跳过当天已经解雇的员工
                        if (empId != firedId && !isFired[empId]) {
                            totalReputation -= efficiency[empId];
                            isFired[empId] = true;
                            resignCount++;
                        }
                    }

                    // 将剩余未解雇的员工放回优先队列
                    for (int empId : activeEmployees) {
                        if (!isFired[empId]) {
                            teamPQ.add(empId);
                        }
                    }
                }

                // 记录当天的声誉
                result[day] = totalReputation;
            }

            return result;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try {
                // 读取员工数量
                if (!scanner.hasNextInt()) {
                    return;
                }
                int n = scanner.nextInt();

                // 读取效率列表
                int[] effList = new int[n];
                for (int i = 0; i < n; i++) {
                    if (!scanner.hasNextInt()) {
                        return;
                    }
                    effList[i] = scanner.nextInt();
                }

                // 读取团队ID列表
                int[] idList = new int[n];
                for (int i = 0; i < n; i++) {
                    if (!scanner.hasNextInt()) {
                        return;
                    }
                    idList[i] = scanner.nextInt();
                }

                // 读取天数
                if (!scanner.hasNextInt()) {
                    return;
                }
                int q = scanner.nextInt();

                // 读取解雇信息
                int[][] empQuit = new int[q][2];
                for (int i = 0; i < q; i++) {
                    if (!scanner.hasNextInt()) {
                        return;
                    }
                    empQuit[i][0] = scanner.nextInt();

                    if (!scanner.hasNextInt()) {
                        return;
                    }
                    empQuit[i][1] = scanner.nextInt();
                }

                // 计算并输出结果
                int[] result = orgReputation(effList, idList, empQuit);
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);
                    if (i < result.length - 1) {
                        System.out.print(" ");
                    }
                }

            } catch (Exception e) {
                // 发生异常时输出默认结果或错误信息
                System.err.println("输入格式错误: " + e.getMessage());
            }
        }
    }

