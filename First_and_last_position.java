------------------------------------------------------------------------ Approach 1 ------------------------------------------------------------------------------------------
// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : This is easy, couldn't get in O(logn) though, Will see in class

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //create the o/p array
        int [] arr = new int[]{-1,-1};
        int x=0;
        
        if(nums.length<1){
            return arr;
        }
        
        for(int i=0;i<nums.length;i++){
            // if num is found for the first time, store at 0 index of o/p array;
            if(nums[i]==target && x==0){
                arr[x++]=i;
            }
            // if num is found twice, store at 1 index of o/p array
            if(nums[i]==target){
                arr[x]=i;
            }
        }
        return arr;
    }
}

-- ---------------------------------------------------------------- Approach 2 --------------------------------------------------------------------------------------------
 // Time Complexity : O(logn) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, Took me a while to understand but got the gist of it.
 
 class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0 || target<nums[0] || target>nums[nums.length-1]){
            return new int[]{-1,-1};
        }
        
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target,false);
            
        return new int[]{left,right};
    }
    
    private int binarySearch(int[] nums,int target, boolean left){
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid= low+(high-low)/2;
            
            if(nums[mid]==target){
                if(left){
                    if(mid==0 || nums[mid]>nums[mid-1]){
                        return mid;
                    }
                    else{
                        high=mid-1;
                    }
                }
                else{
                    if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                        return mid;
                    }
                    else{
                        low=mid+1;
                    }
                }
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        
        return -1;
    }
}
