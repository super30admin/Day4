//Time Complexity: O(log n)
//Space Complexity: O(1)
// Find Peak Element

class Solution {
    public int findPeakElement(int[] a) {
        int low = 0, high = a.length - 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(low == high)
                return low;
            if((mid== low || a[mid] > a[mid -1]) && (mid == high || a[mid] > a[mid+1])){
                return mid;
            }
            else if(mid ==high || a[mid] < a[mid+1])
                low = mid + 1;
            else
                high = mid-1;
        }
        return -1;
    }
}