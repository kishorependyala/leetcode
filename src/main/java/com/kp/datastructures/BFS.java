package com.kp.datastructures;

import javax.swing.text.html.Option;
import java.awt.desktop.OpenFilesEvent;
import java.util.*;

public class BFS {

    public static <T> Optional<Tree<T>> search(T value, Tree<T> root){

        Queue<Tree<T>> queue = new ArrayDeque<>();

        queue.add(root);

        Tree<T> currentNode;

        while(!queue.isEmpty()){
            currentNode = queue.remove();

            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            }else{
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }


    public static<T> Optional<Node<T>> search(T value, Node<T> start){

        Queue<Node<T>> queue = new ArrayDeque<>();

        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> alreadyVisted = new HashSet<>();

        while(!queue.isEmpty()){
            currentNode = queue.remove();

            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            }else{
                alreadyVisted.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                alreadyVisted.removeAll(alreadyVisted);
            }
        }

        return Optional.empty();
    }

}
