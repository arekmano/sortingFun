package models;

public class MinHeap extends Heap<Integer> {

    public MinHeap(final int rootValue) {
        super(new Node<Integer>(rootValue));
    }

    public void insertNode(final int insertValue) {
        final Node<Integer> toInsert = new Node<>(insertValue);
        getNodes().add(toInsert);
        while (getNodes().indexOf(toInsert) != 0) {
            if (toInsert.getValue() < parentNode(toInsert).getValue()) {
                swap(toInsert, parentNode(toInsert));
            } else {
                break;
            }
        }
    }

    public int pluckMin() {
        final Node<Integer> returnNode = getNodes().get(0);
        rebalanceHeap();
        return returnNode.getValue();
    }

    public int peekMin() {
        return getNodes().get(0).getValue();
    }

    private void rebalanceHeap() {
        final Node<Integer> currentNode = getNodes().get(getNodes().size() - 1);
        getNodes().set(0, currentNode);
        getNodes().remove(getNodes().size() - 1);
        while (true) {
            final Node<Integer> child = getSmallerChild(currentNode);
            if (child != null && currentNode.getValue() > child.getValue()){
                swap(currentNode, child);
            } else {
                break;
            }
        }
    }

    private Node<Integer> getSmallerChild(final Node<Integer> node) {
        final Node<Integer> left = leftNode(node);
        final Node<Integer> right = rightNode(node);
        if (left == null){
            return right;
        }
        if (right == null) {
            return left;
        }
        if (right.getValue() > left.getValue()){
            return left;
        }
        return right;
    }

    public static void main(final String[] args) {
        final MinHeap heap = new MinHeap(10);
        heap.insertNode(4);
        heap.insertNode(4);
        heap.insertNode(4);
        heap.insertNode(4);
        heap.insertNode(2);
        heap.insertNode(3);
        heap.pluckMin();
    }
}
