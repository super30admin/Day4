//TC: O(logn)
//SC: O(1)


class Solution {
    public int findPeakElement(int[] arr) {
        int low = 0;
        int high = arr.length -1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if(arr[mid]<arr[mid+1]){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
