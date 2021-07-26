package com.kp.leetcode;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        boolean visited[] = new boolean[isConnected.length];
        int provinces = 0;

        for(int city=0; city<isConnected.length; city++){
            if (visited[city]) continue;

            visitConnectedCities(isConnected, visited,city);
            provinces++;
        }
        return provinces;
    }

    public void visitConnectedCities(int[][] isConnected, boolean[] visited, int city){

        for(int i=0; i< visited.length; i++){
            if(visited[i]) continue;
            if(i==city) continue;
            if(isConnected[city][i]==1){
                visited[i]=true;
                visitConnectedCities(isConnected, visited,i);
            }

        }
    }
}
