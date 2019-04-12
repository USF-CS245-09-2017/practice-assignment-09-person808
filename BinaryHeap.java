public class BinaryHeap {

    private int[] data = new int[10];
    private int size = 0;

    public void add(int item) {
        if (size + 1 == data.length) {
            growArray();
        }

        data[size++] = item;
        int current = size - 1;
        int parent = (current - 1) / 2;
        // min heap
        while (current != 0 && data[current] < data[parent]) {
            swap(data, current, parent);
            current = parent;
            parent = (parent - 1) / 2;
        }
    }

    public int remove() {
        swap(data, 0, size - 1);
        size--;
        shiftDown(0);
        return data[size];
    }

    private void shiftDown(int pos) {
        if (pos >= size - 1) {
            return;
        }

        int left = pos * 2 + 1;
        int right = pos * 2 + 2;

        // only child is on the left
        if (left <= size - 1 && right >= size - 1) {
            if (data[left] < data[pos]) {
                swap(data, pos, left);
                shiftDown(left);
            }
        }

        if (left >= size - 1 || right >= size - 1) {
            return;
        }

        if (data[left] <= data[right]) {
            if (data[left] < data[pos]) {
                swap(data, pos, left);
                shiftDown(left);
            }
        } else {
            if (data[right] < data[pos]) {
                swap(data, pos, right);
                shiftDown(right);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void growArray() {
        int[] temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        heap.add(5);
        heap.add(30);
        heap.add(22);
        heap.add(17);
        heap.add(38);
        heap.add(57);
        heap.add(73);
        heap.add(2);
        heap.remove();
        for (int i = 0; i < heap.size; i++) {
            System.out.print(heap.data[i] + " ");
        }
    }
}
