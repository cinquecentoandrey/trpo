package ru.cinquecento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }
}
