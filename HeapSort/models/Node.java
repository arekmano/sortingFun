package models;

public class Node<T> {
    private final T value;

    public Node(final T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "Node [" + value + "]";
    }
}