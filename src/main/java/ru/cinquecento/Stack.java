package ru.cinquecento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stack {

    private Node top = null;

    public void destroyStack() {
        Node current = top;
        while (current != null) {
            Node temp = current;
            current = current.getNext();
            temp.setNext(null);
        }
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            return;
        }
        Node temp = top;
        top = top.getNext();
        temp.setNext(null);
    }

    public Node searchByValue(int value) {
        Node current = top;
        while (current != null) {
            if (current.getData() == value) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Node searchByIndex(int index) {
        Node current = top;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.getNext();
        }
        return null;
    }

    public void traverseStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}
