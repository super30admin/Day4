//time complexity: O(log n)
//space complexity:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMin(int[] arr) {
        int l =0, r = arr.length-1;
        
        while(l<=r) {
            
            //arr is sorted
            //min is at index 0
            if(arr[0] <= arr[r]) {
                return arr[0];
            }
            
            
            int mid = l + (r-l)/2;
            
            
            //item at mid is the mid
            //prev item is less than current
            // mid is the minuimum
            if(mid!=0 && arr[mid-1] > arr[mid]) {
                return arr[mid];
            }
            
            //arr is right sorted; least item is in the left part
            if(arr[mid] < arr[r]) {
                //reduce search space to l, mid-1
                r = mid-1;
            } else {
                //reduce search space to mid+1, r
                l = mid+1;
            }
        }
        return 0;
    }
}