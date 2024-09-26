// Time Complexity : O(logn) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// / Any problem you faced while coding this :
class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1; 
        if(nums.length == 1) return nums[0];
        
        int left=0,right=nums.length-1;
        
        
        
        /*while(left<right){
            int mid = left + (right- left)/2;    
            if(nums[mid+1] < nums[mid]) return nums[mid+1];
            if(nums[mid-1] > nums[mid]) return nums[mid];
            if(nums[0] < nums[mid])
                left = mid+1;
            else
                right=mid-1;
        }*/
        
        while(left<=right){
            if(nums[right] > nums[left]) return nums[left];
            int mid = left + (right-left)/2;
            if((mid ==left ||nums[mid-1] > nums[mid]) && (mid == right || nums[mid]<nums[mid+1])) return nums[mid];
            else if(nums[left] <= nums[mid]){
                left =mid+1;
            }else{
                right = mid -1;
            }
        }
        
        return -1;
    }
}