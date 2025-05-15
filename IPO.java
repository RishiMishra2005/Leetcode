class Solution {
    public void swap(int arr[], int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public void maxHeapInsert(int maxHeap[], int profits[], int i) {
        if (i == 0) {
            return;
        }
        int parent = (i-1)/2;
        if (profits[maxHeap[parent]] < profits[maxHeap[i]]) {
            swap(maxHeap, parent, i);
            maxHeapInsert(maxHeap, profits, parent);
        }
    }

    public void maxHeapify(int maxHeap[], int profits[], int n, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if (left < n && profits[maxHeap[left]] > profits[maxHeap[largest]]) {
            largest = left;
        }
        if (right < n && profits[maxHeap[right]] > profits[maxHeap[largest]]) {
            largest = right;
        }
        if (largest != i) {
            swap(maxHeap, i, largest);
            maxHeapify(maxHeap, profits, n, largest);
        }
    }

    public void minHeapInsert(int minHeap[], int capital[], int i) {
        if (i == 0) {
            return;
        }
        int parent = (i-1)/2;
        if (capital[minHeap[parent]] > capital[minHeap[i]]) {
            swap(minHeap, parent, i);
            minHeapInsert(minHeap, capital, parent);
        }
    }

    public void minHeapify(int minHeap[], int capital[], int n, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int smallest = i;
        if (left < n && capital[minHeap[left]] < capital[minHeap[smallest]]) {
            smallest = left;
        }
        if (right < n && capital[minHeap[right]] < capital[minHeap[smallest]]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(minHeap, i, smallest);
            minHeapify(minHeap, capital, n, smallest);
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int minHeap[] = new int[profits.length];
        int maxHeap[] = new int[profits.length];
        int minHeapN = 0;
        int maxHeapN = 0;
        for (int i = 0; i < profits.length; i++) {
            if (capital[i] <= w) {

                maxHeap[maxHeapN++] = i;
                maxHeapInsert(maxHeap, profits, maxHeapN-1);

            } else {
                minHeap[minHeapN++] = i;
                minHeapInsert(minHeap, capital, minHeapN-1);
            }
        }
        if (k > profits.length) {
            k = profits.length;
        }
        while (k-- > 0) {
            if (maxHeapN == 0) {
                break;
            }

            w += profits[maxHeap[0]];

            swap(maxHeap, 0, maxHeapN-1);
            maxHeapN--;
            maxHeapify(maxHeap, profits, maxHeapN, 0);
            
            while(minHeapN > 0 && capital[minHeap[0]] <= w) {
                maxHeap[maxHeapN++] = minHeap[0];
                maxHeapInsert(maxHeap, profits, maxHeapN-1);
                swap(minHeap, 0, minHeapN-1);
                minHeapN--;
                minHeapify(minHeap, capital, minHeapN, 0);
            }
        }
        return w;
    }
}