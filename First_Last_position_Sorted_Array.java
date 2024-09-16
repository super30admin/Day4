//time_complexity- O(logn) 
//Space complexity- O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        ans[0]= findStart(nums, target, true);
        ans[1]= findStart(nums, target, false);
        
        return ans;
        
    }
    public int findStart(int[] nums, int target, boolean value){
        int index=-1;
        int start=0;
        int end = nums.length -1;
        
        while (start <= end){
        int mid = start + (end-start)/2;
            
        if (target > nums[mid]){
            start = mid+1;
        } 
        else if (target < nums[mid]){
            end = mid-1;
        } else {
            index=mid;
            
            if (value){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        }
return index;
            
    }
}
