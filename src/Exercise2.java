import java.util.ArrayList;
import java.util.Comparator;

public class Exercise2<K, V> {
    private ArrayList<Entry<K, V>> heap;
    private Comparator<K> comparator;

    public Exercise2(Comparator<K> comp) {
        heap = new ArrayList<>();
        comparator = comp;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    public void upheap(int j) {
        if (j > 0) {
            int parent = parent(j);
            if (compare(heap.get(j).key, heap.get(parent).key) < 0) {
                swap(j, parent);
                upheap(parent);
            }
        }
    }

    private int parent(int j) {
        return (j - 1) / 2;
    }

    private int compare(K a, K b) {
        return comparator.compare(a, b);
    }

    private void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
