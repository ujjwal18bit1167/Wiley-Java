package DSA_WITH_JAVA.src.data_structures.linear.stack_adt;

class StackUnderFlowException extends Exception {
    StackUnderFlowException(String message) {
        System.out.println(message);
    }
}

class StackOverflowException extends Exception {

}

class Stack {
    int arr[];
    int top = -1;
    int capacity;

    Stack(int n) {
        arr = new int[n];
        capacity = n;
    }

    void push(int data) throws StackOverflowException {
        if (top == capacity - 1)
            throw new StackOverflowException();
        top++;
        arr[top] = data;
    }

    int pop() throws StackUnderFlowException {
        if (top == -1)
            throw new StackUnderFlowException("Stack UnderFlows");
        int elem = arr[top];
        arr[top] = 0;
        top--;
        return elem;
    }

    int peek() {
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    int size() {
        return top + 1;
    }

}

public class StackUsingArrayDemo {
    public static void main(String[] args) throws StackUnderFlowException, StackOverflowException {
        Stack stack = new Stack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        // stack.push(110);

        System.out.println("The poped item is " + stack.pop());
        System.out.println("Size of stack is " + stack.size());

    }
}
