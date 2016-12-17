import models.MinHeap;

public class HeapSort {

    public static void main(final String[] args) {
        int[] values = new int[10];
        for (int i = 0; i < values.length; i++) {
            values[i] = (int) (Math.random() * 100);
        }
        values = heapSort(values);
    }

    public static int[] heapSort(final int[] array){
        final MinHeap minHeap = new MinHeap(array[0]);
        for (int i = 1; i < array.length; i++) {
            minHeap.insertNode(array[i]);
        }
        final int[] returnArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            returnArray[i] = minHeap.pluckMin();
        }
        return returnArray;
    }
}
