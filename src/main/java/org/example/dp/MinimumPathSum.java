package org.example.dp;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum sol = new MinimumPathSum();
        int sum = sol.minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        });
        System.out.println("Minimum Path Sum: "+ sum);
    }

    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        for(int j=1; j<N; j++) grid[0][j] += grid[0][j-1];
        for(int i=1; i<M; i++) grid[i][0] += grid[i-1][0];

        for(int i = 1; i<M; i++ ){
            for(int j=1; j<N; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[M-1][N-1];
    }
}
