package models;

import java.util.ArrayList;

public abstract class Heap<T> {
    private final ArrayList<Node<T>> nodes;

    public Heap(final Node<T> rootNode) {
        nodes = new ArrayList<>();
        nodes.add(rootNode);
    }

    Node<T> parentNode(final Node<T> childNode) {
        return nodes.get((nodes.indexOf(childNode) - 1) / 2);
    }

    Node<T> leftNode(final Node<T> node) {
        try {
            return nodes.get(nodes.indexOf(node) * 2 + 1);
        } catch (final Exception e) {
            return null;
        }
    }

    Node<T> rightNode(final Node<T> node) {
        try {
            return nodes.get(nodes.indexOf(node) * 2 + 2);
        } catch (final Exception e) {
            return null;
        }
    }


    void swap(final Node<T> currentNode, final Node<T> otherNode) {
        final int currentIndex = getNodes().indexOf(currentNode);
        final int otherIndex = getNodes().indexOf(otherNode);
        nodes.set(otherIndex, currentNode);
        nodes.set(currentIndex, otherNode);
    }

    public ArrayList<Node<T>> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Heap [nodes=" + nodes + "]";
    }
}
