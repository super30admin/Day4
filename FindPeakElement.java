//time complexity = o(logn)
//ran successfully on leetcode : Yes

class Solution {
public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length-1;
    int mid;
    
    if (nums.length ==1) {
        return 0;
    }

    // perform binary search
    while (low < high) {
        mid = low + (high-low)/2;
        
        //in order to find the peak, find ascending or descending slope for the local element by comparing with neighbor
        //and if nums[mid] is less than the neighbour, then it means the peak lies to right of the mid element
        if (nums[mid]<nums[mid+1]){
            low = mid+1;   
        }
        else {
            high = mid;
        }
    }
    return low;
}

}