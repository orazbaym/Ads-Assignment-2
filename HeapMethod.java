package com.company;

class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
            if (Heap[leftChild(pos)]
                    > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;

        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int size() {
        return size;
    }

    public void empty() {
        if (0 == this.size){
            System.out.print("empty");
        }
    }


    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println(Heap[i] + " " + Heap[2 * i] + " " + Heap[2 * i + 1]);

        }
    }

    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void HeapMethod(String[] arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(3);
        maxHeap.insert(6);
        maxHeap.insert(12);
        maxHeap.insert(6);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.print();
    }
}
