//Find Minimum in Rotated Sorted Array
//Time Complexity: O(log n)
//Space Complexity: O(1)

class Solution {
    public int findMin(int[] a) {
        int low = 0, high = a.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(a[low] < a[high])
                return a[low];

            if((mid == low || a[mid] < a[mid - 1]) && (mid == high || a[mid] < a[mid + 1]))
                return a[mid];
            else if(a[low] <= a[mid]) //left array is sorted
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}