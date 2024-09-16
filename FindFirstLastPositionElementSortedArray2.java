
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class FindFirstLastPositionElementSortedArray2_34 {
    public int[] searchRange(int[] nums, int target) {
        
        int l=0;
        int h=nums.length-1;

        while(h >= l){
           
            int mid = l + (h-l)/2;
            
            if(nums[mid]==target){
                return findStartEnd(nums,mid,target);
            } else if(nums[mid]>target){
                h = mid -1;
            } else {
                l = mid +1;
            }
           
        }
        
        return new int[]{-1,-1};
        
    }
    
    //after finding target getting start and end index of that target
    public int[] findStartEnd(int[] nums,int mid,int target){
        
        int start = mid;
        int end = mid;
        
        while(start > 0 ) {
            if(nums[start-1]!=target){
                break;
            }else{
                start = start -1;
            }
        }
        
        while(end < nums.length-1 ) {
            if(nums[end+1]!=target){
                break;
            }else{
                end = end+1;
            }
        }
        
        return new int[]{start,end};
        
    }
    
   
}