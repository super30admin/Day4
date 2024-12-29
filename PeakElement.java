// Approach: First, handle the edge cases, which include arrays of size one and cases where the first or last element is the peak element.
// Then, apply binary search using the peak condition to return index of the peak element. A key observation while narrowing search space
// is that if an element is smaller than its next element, it is guaranteed that at least one peak element exists on the right side of this element.
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PeakElement {

    int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n-1] > arr[n-2]) {
            return n - 1;
        }
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
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

    public static void main(String[] args) {
        PeakElement pe = new PeakElement();
        int[] arr = { 1, 2, 3, 4, 3, 4, 5, 2 };
        int idx = pe.findPeakElement(arr);
        System.out.println("Peak element " + arr[idx] + " is found at index " + idx);
    }
}