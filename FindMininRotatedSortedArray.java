//Time Complexity O(logn)
//Space Complexity O(1)


class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            if(nums[low]<nums[high]) return nums[low];
            int mid  = low +(high-low)/2;
            if((mid ==0 || nums[mid] < nums[mid-1] ) && 
               (mid == nums.length-1 || nums[mid]< nums[mid+1])){
                return nums[mid];
                
            }else if(nums[mid]<=nums[high]){ //if right side is sorted
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
        
    }
}