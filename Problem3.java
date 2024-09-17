//Time Complexity: Log(N)
//Space Complexity: O(1)
// We use binary search for this problem. We find out the mid and then move towards the 
//greater element. We can go towards either side of the mid and we will be able to find a peak element.
// This solution works because we have to find any peak element and not all of them

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length ==0) return -1;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid != 0 && nums[mid] < nums[mid-1]){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return 3610;
    }
}