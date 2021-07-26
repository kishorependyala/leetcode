package com.kp.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayList {

    public static void main(String[] args) {
        PlayList playList = new PlayList();
        int[] songs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        print(songs);  
        int[] shuffledSongs = playList.shuffle(songs);
        print(shuffledSongs);  

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < shuffledSongs.length; i++) {
            Integer put = map.put(shuffledSongs[i], i);
            if(put != null) {
                System.out.println("Duplicate: " + put + " " + i);
            }
        }
    }

    private static void print(int[] songs) {
        System.out.println(Arrays.toString(songs));
    }

    private int[] shuffle(int[] songs) {
        if(songs == null || songs.length == 0){
            return songs;
        }
        Random rand = new Random();
        for(int i = 1; i < songs.length; i++) {
            int randomInt = rand.nextInt(i);
            swap(songs, i, randomInt);  
        }
        return songs;
    }

    private void swap(int[] songsCopy, int index1, int index2) {
        if(index1 != index2) {
            int temp = songsCopy[index1];
            songsCopy[index1] = songsCopy[index2];
            songsCopy[index2] = temp;
        }
    }


    


}
