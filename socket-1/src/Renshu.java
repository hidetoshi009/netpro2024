public class Renshu {
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q) {
        int sum = 0;
        for (int i = p; i <= q; i++) {
            sum += i;
        }
        if (p > q)
            sum = -1;
        return sum;
    }

    public int sumFromArrayIndex(int[] a, int index) {
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += a[i];
        }
        if (a.length <= index)
            sum = -1;
        return sum;
    }

    public int selectMaxValue(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }

    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i])
                min = a[i];
        }
        return min;
    }

    public int selectMaxIndex(int[] a) {
        int max = 0;
        int maxindex = 0;
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                maxindex = i;
            }
        }
        return maxindex;
    }

    public int selectMinIndex(int[] a) {
        int min = a[0];
        int minindex = 0;
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                minindex = i;
            }
        }
        return minindex;
    }

    public void swapArrayElements(int[] p, int i, int j) {
        int tmp = 0;
        tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }

    public boolean swapTwoArrays(int[] a, int[] b) {
        int tmp = 0;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                tmp = a[i];
                a[i] = b[i];
                b[i] = tmp;
            }
            return true;
        }
        return false;
    }

    public void bubbleSort(int a[]) {
        int tmp = 0;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            // ピボットのインデックスを取得
            int pi = partition(arr, low, high);

            // ピボットを基準に再帰的に配列を分割してソート
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // ピボットを選択
        int i = low - 1; // ピボットより小さい要素の境界を設定

        // 配列を走査し、ピボットより小さい要素をピボットより左側に移動
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // ピボットを正しい位置に移動
        swap(arr, i + 1, high);

        // ピボットのインデックスを返す
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

