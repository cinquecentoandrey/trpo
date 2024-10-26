package ru.cinquecento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void testIsEmptyOnNewStack() {
        assertTrue(stack.isEmpty(), "New stack should be empty");
    }

    @Test
    void testPush() {
        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(10, stack.getTop().getData(), "Top element should be 10");

        stack.push(20);
        assertEquals(20, stack.getTop().getData(), "Top element should be 20 after second push");
    }

    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);
        stack.pop();

        assertEquals(10, stack.getTop().getData(), "Top element should be 10 after pop");

        stack.pop();
        assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements");
    }

    @Test
    void testSearchByValue() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Node result = stack.searchByValue(20);
        assertNotNull(result, "Element with value 20 should be found");
        assertEquals(20, result.getData(), "Found element should have value 20");

        assertNull(stack.searchByValue(40), "Searching for non-existent element should return null");
    }

    @Test
    void testSearchByIndex() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Node result = stack.searchByIndex(1);
        assertNotNull(result, "Element at index 1 should be found");
        assertEquals(20, result.getData(), "Element at index 1 should have value 20");

        assertNull(stack.searchByIndex(3), "Searching for index out of bounds should return null");
    }

    @Test
    void testDestroyStack() {
        stack.push(10);
        stack.push(20);
        stack.destroyStack();

        assertTrue(stack.isEmpty(), "Stack should be empty after destroy");
        assertNull(stack.getTop(), "Top element should be null after destroy");
    }

    @Test
    void testTraverseStack() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        String expectedOutput = "30 20 10 ";
        assertEquals(expectedOutput, captureOutput(stack::traverseStack), "Stack elements should be traversed in correct order");
    }

    private String captureOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        action.run();

        System.setOut(originalOut);
        return outputStream.toString();
    }
}
