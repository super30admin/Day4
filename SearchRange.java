// Time Complexity : O(logn) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// / Any problem you faced while coding this :
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target< nums[0] || target > nums[nums.length-1]){
            return new int[]{-1,-1};
        }
        
        //find the start
        int lo = 0, hi = nums.length-1, left = -1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(target == nums[mid]){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    left =mid;
                    break;
                }else{
                    hi=mid-1;
                }
            }
            else if(target < nums[mid]){
                hi=mid-1;
            }else{
                lo =mid+1;
            }
        }
        if(left == -1) return new int[]{-1,-1};
        
        //find the last element
        lo=left;
        hi = nums.length-1;
        int mid = lo;
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(target == nums[mid]){
                if(mid == nums.length -1 || nums[mid+1]>nums[mid]){
                    break;            
                }else{
                    lo = mid +1;
                }
            }
            else if(target > nums[mid]){
                lo = mid +1;
            }else{
                hi = mid -1;
            }
        }
        
        return new int[]{left,mid};
        
    }
}