// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// First, I observed the peak element will have smaller elements on its either side. I will calculate mid index
// and check if it has smaller element on its either sides. If yes, return the mid element value. Else, I would check if
// if one value is smaller and one value is larger than the mid, I will move the search towards the larger value.
// My intuition is that there is guarantee of finding peak value on the side having the larger value. So my search space moves
// to the element having larger value and I will repeat the steps for that half of the array.

public class FindPeak {

    private int findPeakIterative(int[] arr, int low, int high) {
        int lastIndex = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || (arr[mid - 1] < arr[mid]))
                    && (mid == lastIndex || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }

    private int findPeakRecursive(int[] arr, int low, int high) {
        int lastIndex = arr.length - 1;
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if ((mid == 0 || (arr[mid - 1] < arr[mid]))
                && (mid == lastIndex || arr[mid] > arr[mid + 1])) {
            return mid;
        }

        if (arr[mid] < arr[mid + 1]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }


        return findPeakRecursive(arr, low, high);
    }
}
