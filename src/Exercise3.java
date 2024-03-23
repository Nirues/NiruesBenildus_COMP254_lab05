import java.util.Arrays;

public class Exercise3 {

    private Comparable[] heap;
    private int size;

    public Exercise3(int capacity) {
        heap = new Comparable[capacity];
        size = 0;
    }

    public void insert(Comparable value) {
        if (size == heap.length)
            throw new IllegalStateException("the priority queue is full");

        heap[size] = value;
        upheap(size);
        size++;
    }

    private void upheap(int index) {
        if (index == 0)
            return;

        int parentIndex = (index - 1) / 2;
        if (heap[index].compareTo(heap[parentIndex]) < 0) {
            swap(index, parentIndex);
            upheap(parentIndex);
        }
    }

    private void swap(int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        Exercise3 priorityQueue = new Exercise3(10);

        priorityQueue.insert(2);
        System.out.println("the heap after inserting 2 " + Arrays.toString(Arrays.copyOf(priorityQueue.heap, priorityQueue.size)));

        priorityQueue.insert(10);
        System.out.println("the heap after inserting 10 " + Arrays.toString(Arrays.copyOf(priorityQueue.heap, priorityQueue.size)));

        priorityQueue.insert(8);
        System.out.println("the heap after inserting 8 " + Arrays.toString(Arrays.copyOf(priorityQueue.heap, priorityQueue.size)));

        priorityQueue.insert(5);
        System.out.println("the heap after inserting 5 " + Arrays.toString(Arrays.copyOf(priorityQueue.heap, priorityQueue.size)));
    }

}


