package com.kp.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Sudoku {

    Map<Integer, Set<Integer>> iSubgridMap = new HashMap<>();
    Map<Integer, Set<Integer>> jSubgridMap = new HashMap<>();

    public void solveSudoku(char[][] board) {
        int rowCount = board.length;
        int columnCount = board[0].length;

        int[][] rowGrid = new int[rowCount][columnCount];
        int[][] columnGrid = new int[rowCount][columnCount];
        int[][] subGrid = new int[rowCount][columnCount];

        populateGrids(board,rowGrid,columnGrid,subGrid);
        print(board,rowGrid,columnGrid,subGrid);
        printSubGrids();
        int iteration=0;
        while(!solutionReached(subGrid)){
            System.out.println("Running iteration "+iteration++);
            fillSudoku(board,rowGrid,columnGrid,subGrid);

        }
        print(board,rowGrid,columnGrid,subGrid);
    }

    /**
     *
     *
     * . . 9 7 4 8 . . 2
     * 7 . . 6 . 2 . . 9
     * . 2 . 1 . 9 . . .
     * . . 7 9 8 6 2 4 1
     * 2 6 4 3 1 7 5 9 8
     * 1 9 8 5 2 4 3 6 7
     * 9 . . 8 6 3 . 2 .
     * . . 2 4 9 1 . . 6
     * . . . 2 7 5 9 . .
     *
     *
     * @param board
     * @param rowGrid
     * @param columnGrid
     * @param subGrid
     */

    private void fillSudoku(char[][] board, int[][] rowGrid, int[][] columnGrid, int[][] subGrid) {
        for(int i=0; i<subGrid.length; i++) {
            for (int j = 0; j < subGrid[0].length; j++) {

                if(subGrid[i][j] == 0){

                    int number = i;
                    int subGridId = j;
                    //System.out.println("Running for subGridId "+(subGridId+1)+"  number="+(number+1));

                    Set<Integer> iIndexes = new HashSet<>(iSubgridMap.get(subGridId));
                    Set<Integer> jIndexes = new HashSet<>(jSubgridMap.get(subGridId));

                    Set<Integer> iIndexesToFill = new HashSet<>();
                    iIndexes.forEach(x-> {
                        if(rowGrid[number][x] != 1){
                            iIndexesToFill.add(x);
                        }
                    });

                    Set<Integer> jIndexesToFill = new HashSet<>();
                    jIndexes.forEach(x-> {
                        if(columnGrid[number][x] != 1){
                            jIndexesToFill.add(x);
                        }
                    });


                    final AtomicInteger counter = new AtomicInteger();
                    final AtomicInteger iAnswer = new AtomicInteger();
                    final AtomicInteger jAnswer = new AtomicInteger();

                    iIndexesToFill.forEach( xIndex ->{
                        jIndexesToFill.forEach( yIndex -> {
                            if(board[xIndex][yIndex] == '.'){
                                counter.getAndIncrement();
                                iAnswer.set(xIndex);
                                jAnswer.set(yIndex);
                            }
                        });
                    });
                    if(counter.get() == 1){
                        // found the solution
                        board[iAnswer.get()][jAnswer.get()] =  Character.forDigit(number+1,10);
                        rowGrid[number][iAnswer.get()] = 1;
                        columnGrid[number][jAnswer.get()] = 1;
                        subGrid[i][j] = 1;

                        //print(board,rowGrid,columnGrid,subGrid);
                        //print(board);
                        print(board);
                        System.out.println("Filled for subGridId "+(subGridId+1)+"  number="+(number+1));
                    }
                }
            }
        }
    }

    private boolean solutionReached(int[][] subGrid) {
        for(int i=0; i<subGrid.length; i++) {
            for (int j = 0; j < subGrid[0].length; j++) {
                if(subGrid[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private void print(char[][] board, int[][] rowGrid, int[][] columnGrid, int[][] subGrid) {
        print(board);
        print("rowGrid",rowGrid);
        print("columnGrid",columnGrid);
        print("subGrid",subGrid);
    }

    private void populateGrids(char[][] board, int[][] rowGrid, int[][] columnGrid, int[][] subGrid) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length;j++){
                char value = board[i][j];
                int subGridId = getSubGridId(i,j);
                if(value=='.')
                    continue;
                int intValue = Integer.parseInt(value+"");
                rowGrid[intValue-1][i] = 1;
                columnGrid[intValue-1][j] = 1;


                subGrid[intValue-1][subGridId]=1;
            }
        }
    }

    public void printSubGrids(){
        for(int i=0;i<9;i++){
            System.out.print("Indexes for subgrid "+ (i+1)+ "=");
            System.out.print(this.iSubgridMap.get(i)+" "+this.jSubgridMap.get(i));
            System.out.println();
        }
    }

    public int getSubGridId(int i, int j){
        int igridId = (i)/3;
        int jgridId = (j)/3;
        int subGridId = igridId*3+jgridId;

        iSubgridMap.putIfAbsent(subGridId,new HashSet<>());
        Set<Integer> integers = iSubgridMap.get(subGridId);
        integers.add(i);

        jSubgridMap.putIfAbsent(subGridId,new HashSet<>());
        Set<Integer> jValues = jSubgridMap.get(subGridId);
        jValues.add(j);
        return subGridId;
    }

    public void print(char[][] board){
        System.out.println("input board ");
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public void print(String text, int[][] board){
        System.out.println(text);
        System.out.print("    ");
        for(int i=0;i<board.length;i++){
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.print("    ");
        for(int i=0;i<board.length;i++){
            System.out.print("- ");
        }
        System.out.println();
        for(int i=0; i<board.length; i++) {
            System.out.print((i+1)+ " - ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
