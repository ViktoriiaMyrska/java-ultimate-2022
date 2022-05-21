package homework;

import java.util.Objects;
import java.util.Stack;

public class DemoApp {
    public static void main(String[] args) {
        var head = createLinkedList(4, 3, 9, 1);
        printReversedRecursively(head);
//        printReversedUsingStack(head);
    }

    /**
     * Creates a list of linked {@link Node} objects based on the given array of elements and returns a head of the list.
     *
     * @param elements an array of elements that should be added to the list
     * @param <T>      elements type
     * @return head of the list
     */
    public static <T> Node<T> createLinkedList(T... elements) {
        Objects.requireNonNull(elements);
        Objects.checkIndex(0, elements.length);
        var head = new Node<>(elements[0]);
        var current = head;
        for(int i = 0; i < elements.length; i++){
            current.next = new Node<>(elements[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Prints a list in a reserved order using a recursion technique. Please note that it should not change the list,
     * just print its elements.
     * <p>
     * Imagine you have a list of elements 4,3,9,1 and the current head is 4. Then the outcome should be the following:
     * 1 -> 9 -> 3 -> 4
     *
     * @param head the first node of the list
     * @param <T>  elements type
     */
    public static <T> void printReversedRecursively(Node<T> head) {
        Objects.requireNonNull(head);
        System.out.println(head.element);
        printRecursively(head.next);
    }

    private static void printRecursively(Node<?> node){
        if (node != null){
            printReversedRecursively(node.next);
            System.out.print(node.element + " -> ");
        }
    }

    /**
     * Prints a list in a reserved order using a {@link java.util.Stack} instance. Please note that it should not change
     * the list, just print its elements.
     * <p>
     * Imagine you have a list of elements 4,3,9,1 and the current head is 4. Then the outcome should be the following:
     * 1 -> 9 -> 3 -> 4
     *
     * @param head the first node of the list
     * @param <T>  elements type
     */
    public static <T> void printReversedUsingStack(Node<T> head) {
        System.out.println(head);
        Stack<T> stack = new Stack<>();
        while (head !=null){
            stack.add(head.element);
            head = head.next;
        }

        if(stack.isEmpty()) return;

        System.out.print(stack.pop());
        while (!stack.isEmpty()){
            System.out.print(" -> " + stack.pop());
        }
    }
}