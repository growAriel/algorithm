package org.example;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,0};
        int m = 2;
        int[] nums2 = {2};
        int n = 1;
        merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // if there are remaining elements in nums2, then move them into nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}