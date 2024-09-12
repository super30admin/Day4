// Time Complexity : Since the search space is halved therefore it is O(log n) where n is the length of the array
// Space Complexity : O(1) There is no need for extra space
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class findPeak {

    public int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // return only if its greater than its neighbours and is not the boundary
            if (mid != 0 && arr[mid - 1] < arr[mid] && mid != arr.length - 1 && arr[mid] > arr[mid + 1])
                return mid;
            // else go to the subarray accordingly
            else if (arr[mid + 1] > arr[mid])
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;

    }

}