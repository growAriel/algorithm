package org.example.shl.footSteps;

import java.util.*;

public class footSteps {

    public static int[] solve(int fatherPos, int martinPos, int velFather, int steps) {
        int X1 = fatherPos;
        int X2 = martinPos;
        int V1 = velFather;
        int N = steps;

        int maxF = 0;
        int bestV2 = 0;

        // 父亲脚印是 N+1 个
        for (int k = 0; k <= N; k++) {
            int fatherStepPos = X1 + k * V1;
            int V2 = fatherStepPos - X2;

            if (V2 <= 0) continue;

            int F = 0;

            int martinStep = 1;
            int martinPosNow = X2 + V2;

            int fatherIndex = k;

            while (fatherIndex <= N) {
                int fatherPosNow = X1 + fatherIndex * V1;

                if (martinPosNow == fatherPosNow) {
                    F++;
                    martinStep++;
                    martinPosNow = X2 + martinStep * V2;
                    fatherIndex++;
                } else if (martinPosNow > fatherPosNow) {
                    fatherIndex++;
                } else {
                    martinStep++;
                    martinPosNow = X2 + martinStep * V2;
                }
            }

            if (F > maxF || (F == maxF && V2 > bestV2)) {
                maxF = F;
                bestV2 = V2;
            }
        }

        return new int[]{maxF, bestV2};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fatherPos = sc.nextInt();
        int martinPos = sc.nextInt();
        int velFather = sc.nextInt();
        int steps = sc.nextInt();

        int[] res = solve(fatherPos, martinPos, velFather, steps);

        System.out.println(res[0] + " " + res[1]);

        //case 1: input: 1 0 1 2, output: 3 1
        //case 2: input 13 5 9 4, output: 1 44

    }
}