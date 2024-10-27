#include <gtest/gtest.h>
#include "stack.h"

class StackTest : public ::testing::Test {
protected:
    Stack stack;

    void SetUp() override {
        initStack(&stack);
    }

    void TearDown() override {
        destroyStack(&stack);
    }
};

TEST_F(StackTest, StackInitialization) {
    EXPECT_TRUE(isEmpty(&stack));
}

TEST_F(StackTest, PopRemovesElement) {
    push(&stack, 5);
    push(&stack, 10);
    pop(&stack);
    EXPECT_EQ(getTop(&stack)->data, 5);
}

TEST_F(StackTest, SearchByValue) {
    push(&stack, 5);
    push(&stack, 10);
    Node* node = searchByValue(&stack, 5);
    ASSERT_NE(node, nullptr);
    EXPECT_EQ(node->data, 5);
}

TEST_F(StackTest, SearchByIndex) {
    push(&stack, 5);
    push(&stack, 10);
    Node* node = searchByIndex(&stack, 1);
    ASSERT_NE(node, nullptr);
    EXPECT_EQ(node->data, 5);
}

TEST_F(StackTest, IsEmptyReturnsTrueForEmptyStack) {
    EXPECT_TRUE(isEmpty(&stack));
}

TEST_F(StackTest, IsEmptyReturnsFalseForNonEmptyStack) {
    push(&stack, 5);
    EXPECT_FALSE(isEmpty(&stack));
}

TEST_F(StackTest, TraverseStackPrintsElements) {
    push(&stack, 5);
    push(&stack, 10);
    testing::internal::CaptureStdout();
    traverseStack(&stack);
    std::string output = testing::internal::GetCapturedStdout();
    EXPECT_EQ(output, "Stack elements: 10 5 \n");
}

TEST_F(StackTest, PushAddsElement) {
    push(&stack, 5);
    EXPECT_EQ(getTop(&stack)->data, 5);
    EXPECT_FALSE(isEmpty(&stack));
}