import java.util.Arrays;

public class findMinRotatedSortedArray {
    public static int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if start is less than end means array is sorted
            if (arr[start] < arr[end])
                return arr[start];

            // if mid == 0 means first element
            // if mid == arr.length - 1 means it's last element
            // if mid's left and right then it's lowest element 
            if ((mid == 0 || arr[mid] < arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] < arr[mid + 1])) {
                return arr[mid];
            // if start is less than or equal to mid then increase the start
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(findMin(arr));
    }
}
