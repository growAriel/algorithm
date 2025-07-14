package org.example.bst.twoSum;

import java.util.HashSet;
import java.util.Set;

public class findTargetSolution  {
    Set<Integer> set = new HashSet<>();

    public findTargetSolution(TreeNode root, int k) {
    }

    public boolean findTargetHelper(TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return findTargetHelper(node.left, k) || findTargetHelper(node.right, k);
    }
}
