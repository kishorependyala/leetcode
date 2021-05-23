package com.kp.rbc;

public class DoubleLinkedList<V> {

    class Node<V>{
        V value;
        Node<V> next;
        Node<V> prev;
    }

    Node head, tail = null;

    public void removeFirst(){
        Node next = head.next;
        next.prev = null;
        head = next;
    }
    public Node addNode(V item){
        Node<V> node = new Node<>();
        node.value = item;
        return addNode(node);
    }

    private Node<V> addNode(Node<V> node) {
        if(head==null) {
            head = tail = node;
            node.prev = null;
            node.next = null;
        }else{
            node.prev = tail;
            tail.next = node;
            node.next = null;
            tail = node;
        }
        return node;
    }

    public boolean isHead(Node<V> node){
        return node.prev==null;
    }
    public boolean isTail(Node<V> node){
        return node.next==null;
    }

    public void removeNode(Node<V> node){
        if(isTail(node)){
            Node prev = node.prev;
            prev.next = null;
            tail = prev;
        }
        else if(isHead(node)){
            Node next = node.next;
            next.prev = null;
            head = next;
        }else {
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
        }
    }

    public void moveNodeToLast(Node<V> node){
        removeNode(node);
        addNode(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(head != null){
           Node node = head;
           while(node != null){
               sb.append(node.value).append(" ");
               node = node.next;
           }
        }
       return sb.toString();
    }

    public void print(){
        System.out.println(toString());
    }
}
