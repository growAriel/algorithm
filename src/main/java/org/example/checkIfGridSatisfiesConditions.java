package org.example;

public class checkIfGridSatisfiesConditions {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 2},
            {1, 0, 2}
        };
        Boolean result = satisfiesConditions(grid);
        System.out.println(result); // Output: true

        int[][] grid2 = {
            {1, 1, 1},
            {0, 0, 0}
        };
        Boolean result2 = satisfiesConditions(grid2);
        System.out.println(result2); // Output: false

        int[][] grid3 = {
            {1},
            {2},
            {3}
        };
        Boolean result3 = satisfiesConditions(grid3);
        System.out.println(result3); // Output: false
    }

    public static Boolean satisfiesConditions(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i>0 &&grid[i][j] != grid[i - 1][j] || j>0&&grid[i][j] == grid[i][j - 1]){
                    return false;
                }
            }
        }
        return true;
    }

}
