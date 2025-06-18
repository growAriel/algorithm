package org.example;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // 返回 true
        System.out.println(randomizedSet.remove(2)); // 返回 false (2 不存在)
        System.out.println(randomizedSet.insert(2)); // 返回 true
        System.out.println(randomizedSet.getRandom()); // 返回 1 或 2
        System.out.println(randomizedSet.remove(1)); // 返回 true
        System.out.println(randomizedSet.insert(2)); // 返回 false (2 已经存在)
        System.out.println(randomizedSet.getRandom()); // 返回 2
    }
}

class RandomizedSet {
    List<Integer> nums;
    Map<Integer,Integer> indexMap;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return  false; // 如果值已经存在，返回false
        }
        nums.add(val); // 将值添加到列表中
        indexMap.put(val, nums.size()-1); // 将值和其索引存入映射
        return true; // 返回true表示插入成
    }

    public boolean remove(int val){
        if(!indexMap.containsKey(val)){
            return false; // 如果值不存在，返回false
        }
        int index = indexMap.get(val); // 获取值的索引
        int lastElement = nums.getLast(); // 获取列表中的最后一个元素
        nums.set(index,lastElement);
        indexMap.put(lastElement, index); // 更新最后一个元素的索引
        nums.removeLast(); // 移除列表中的最后一个元素
        indexMap.remove(val);
        return true;
    }

    public int getRandom(){
        int randomIndex = random.nextInt(nums.size()); // 生成一个随机索引
        return nums.get(randomIndex);
    }
}
