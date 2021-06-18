package com.kp.leetcode;

public class NumOfIslands {

    int i=0;
    int j=0;

    public int numIslands(char[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        System.out.println("m = "+m +  " n="+n);

        int currentIsland = 0;
        int nextIsland = 0;
        while (nextIsland != -1){
            nextIsland = findNextIsland(grid,m,n,currentIsland);
            if(nextIsland != -1) {
                currentIsland = nextIsland;
                markIsland(grid, i, j, currentIsland);
            }
        }

        return currentIsland;
    }

    private void markIsland(char[][] grid, int i, int j, int currentIsland) {
        grid[i][j] = 'x';
        if(i+1 < grid.length) {
            if (grid[i + 1][j] == '1')
                markIsland(grid, i + 1, j, currentIsland);
            else
                grid[i + 1][j] = 'x';
        }

        if(i-1 >= 0 ) {
            if (grid[i - 1][j] == '1')
                markIsland(grid, i - 1, j, currentIsland);
            else
                grid[i - 1][j] = 'x';
        }

        if(j+1 < grid[0].length) {
            if (grid[i][j + 1] == '1')
                markIsland(grid, i, j + 1, currentIsland);
            else
                grid[i][j + 1] = 'x';
        }
        if(j-1 >= 0) {
            if (grid[i][j - 1] == '1')
                markIsland(grid, i, j - 1, currentIsland);
            else
                grid[i][j - 1] = 'x';
        }
    }

    private int findNextIsland(char[][] grid, int m, int n, int currentIsland) {

            while( grid[i][j] != '1') {
                j++;
                if(j>=n){
                    j=0;
                    i++;
                    if(i>=m){
                        //no more islands
                        return -1;
                    }
                }
            }
        return  (currentIsland+1);
    }



    public int numIslands2(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }
        return count;
    }

    private void clearRestOfLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        clearRestOfLand(grid, i+1, j);
        clearRestOfLand(grid, i-1, j);
        clearRestOfLand(grid, i, j+1);
        clearRestOfLand(grid, i, j-1);
        return;
    }
}
