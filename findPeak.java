
/** Time Complexity: O(logN)
 ** Space Complexity: O(1)
 **/ 

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0; int high = nums.length - 1; int mid;
        
        if(low != high && nums[low] > nums[low + 1]) return low;
        if(low != high && nums[high - 1] < nums[high]) return high;
        
        while(low <= high){
            mid = low + (high - low)/2;
            // condition to check if peak is greater than previous and next
            if( (mid ==0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1])){
                return mid;
            } else if(mid != 0 && nums[mid - 1] > nums [mid]) {    // We will always move towards higher side
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 1490;
    }
}