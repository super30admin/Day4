public class MinimumElement {
    //TC is O(logn) as array is divided into half in each iteration
    public static int findMin(int[] a) {
        int low = 0, mid = 0;
        int high = a.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[low] <= a[high])
                return a[low];
            else if ((mid == 0 || a[mid - 1] > a[mid]) && (mid == a.length - 1 || a[mid + 1] > a[mid])) //if mid is less than its neighbours
                return a[mid];
            else if (a[low] > a[mid]) { //min element will be present in unsorted array
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return a[mid];
    }

    public static void main(String args[]) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.printf("Expected 0, got %d", findMin(arr));
    }
}