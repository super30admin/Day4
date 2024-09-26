//time complexity: log N
// program ran on Leetcode
// space complexity : N
class peakElement {
    public int findPeakElement(int[] nums) {
        int low =0 ;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid-1]<nums[mid]) && ( (mid == nums.length-1)|| (nums[mid+1]<nums[mid]))){
                return mid;
            }
            else if (mid<nums.length-1 && nums[mid]<nums[mid+1]){
                low = mid+1;
            }
            else if(mid>0 && nums[mid]<nums[mid-1]){
                high = mid -1;
            }
            
        }
        return -1;
    }
}