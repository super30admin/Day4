/* we find mid and check if its peak 
 * if not we move the search towards the side which increases from mid (increasing slope)
 * using binary seach we get log(n) time complexity.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null) return -1;
        if(nums.length == 1) return 0;
        int low =0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high -low)/2;
            if( (mid==0 || nums[mid]>nums[mid-1]) && ( mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }else if(mid>0 && nums[mid-1] > nums[mid]){
                    high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }
}