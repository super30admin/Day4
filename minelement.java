// T.C = O(logn)
// S.C = O(1)

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];    //if only one element present, return it
        if(nums[0]<=nums[nums.length-1]) return nums[0];    //if array is sorted in ascending order, return the first element
        
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            if(nums[low]<=nums[high]) return nums[low];
            
            int mid = low + (high-low)/2;   //prevent integer overflow
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low =mid+1;
            }
            else{
                high=mid-1;
            }
                
        }
        return -1;
    }
}