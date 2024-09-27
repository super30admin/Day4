
class MissingItem {

    public int findMissing(int[] arr, int l, int h) {
        int mid = l + (h - l) / 2;
        int commonDif = arr[0] - 0;

        if (l == h) {
            return l - 1;
        } else if ((l < h) && (arr[mid] - mid == commonDif)) {
            return findMissing(arr, mid + 1, h);
        } else if ((l >= 0) && (arr[mid] - mid != commonDif)) {
            return findMissing(arr, l, mid - 1);
        } else
            return -1;
    }

    public static void main(String[] args) {
        MissingItem ms = new MissingItem();
        int[] arr = { 1, 2, 4, 5, 6, 7, 8 };
        System.out.println(ms.findMissing(arr, 0, arr.length));
        ;
    }
}