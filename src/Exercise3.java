

import java.util.ArrayList;

public class HeapPriorityQueue<E extends Comparable<E>> {
    private ArrayList<E> elements = new ArrayList<>();

    // Constructor
    public HeapPriorityQueue() {
    }

    // Other constructors and methods...

    // Upheap using recursion
    private void upheap(int index) {
        if (index == 0) {
            return; // Base case: reached the root
        }

        int parentIndex = (index - 1) / 2;

        if (elements.get(index).compareTo(elements.get(parentIndex)) < 0) {
            // If the current element is smaller than its parent, swap them
            swap(index, parentIndex);
            upheap(parentIndex); // Recur on the parent
        }
    }

    // Downheap using recursion
    private void downheap(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < elements.size() && elements.get(leftChildIndex).compareTo(elements.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < elements.size() && elements.get(rightChildIndex).compareTo(elements.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            downheap(smallest);
        }
    }

    // Insert an element into the priority queue
    public void insert(E element) {
        elements.add(element);
        upheap(elements.size() - 1);
    }

    // Remove and return the minimum element from the priority queue
    public E removeMin() {
        if (isEmpty()) {
            return null;
        }

        E min = elements.get(0);
        if (elements.size() == 1) {
            elements.remove(0);
        } else {
            elements.set(0, elements.remove(elements.size() - 1));
            downheap(0);
        }
        return min;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Helper method to swap elements at two indices
    private void swap(int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    // Main method to test the HeapPriorityQueue class
    public static void main(String[] args) {
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();
        pq.insert(5);
        pq.insert(3);
        pq.insert(7);
        pq.insert(2);
        pq.insert(9);

        System.out.println("Removed elements in sorted order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.removeMin());
        }
    }
}

