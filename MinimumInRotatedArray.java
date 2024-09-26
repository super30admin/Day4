// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// First, I observed the minimum element will have larger elements on its either side. I will calculate mid index
// and check if it has larger element on its either sides. If yes, return the mid element value. Else, I would check if
// if we are in sorted array, either on left side or right. If the mid is in sorted location, it cannot contain the minimum element
// I will search for minimum element in unsorted side of the rotated array. I will repeat steps, in the unsorted side of the array;


public class MinimumInRotatedArray {
    public int findMin(int[] arr) {
        int index = -1;
        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        index = findMinRecursive(arr, 0, arr.length - 1);
        System.out.println(index);
        index = findMinIterative(arr, 0, arr.length - 1);
        return index;
    }

    private int findMinRecursive(int[] arr, int low, int high) {
        int lastIndex = arr.length - 1;

        if (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || (arr[mid - 1] > arr[mid]))
                    && (mid == lastIndex || arr[mid] < arr[mid + 1])) {
                return arr[mid];
            }

            if (arr[mid] < arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            return findMinRecursive(arr, low, high);
        }
        return -1;
    }

    private int findMinIterative(int[] arr, int low, int high) {
        int lastIndex = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || (arr[mid - 1] > arr[mid]))
                    && (mid == lastIndex || arr[mid] < arr[mid + 1])) {
                return arr[mid];
            }

            if (arr[mid] < arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }
}
