package edu.kis.vh.nursery.list;

public class IntLinkedList {

    private static final int EMPTY = -1;
    private Node lastNode;
    private int index;

    public void push(int i) {
        if (lastNode == null)
            lastNode = new Node(i);
        else {
            lastNode.setNext(new Node(i));
            lastNode.getNext().setPrev(lastNode);
            lastNode = lastNode.getNext();
        }
    }

    public boolean isEmpty() {
        return lastNode == null;
    }

    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty())
            return EMPTY;
        return lastNode.getValue();
    }

    public int pop() {
        if (isEmpty())
            return EMPTY;
        int ret = lastNode.getValue();
        lastNode = lastNode.getPrev();
        return ret;
    }

}

class Node {

    private final int value;
    private Node prev, next;

    public Node(int number) {
        this.value = number;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

}

