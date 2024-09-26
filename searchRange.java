// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class searchRange {
    public int[] search(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        
        int first= findFirst(nums, target);
        if(first ==-1) return new int[]{-1,-1};
        int last= findLast(nums, target);
        
        return new int[]{first, last};
    }
    
    int findFirst(int[] nums, int target){
        int l=0, h= nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            //if nums of mid is equal to target then check its left and right side elements
            if(nums[mid]==target){
                //if the left element is less than target means that this mid element 
                //is the first occurance
                if(mid==l || nums[mid-1]<target){
                    return mid;
                }else{
                //else search in the left half of the array for the first occ
                    h=mid-1;
                }
            }else if(nums[mid]<target){
                //if mid is less than target search in the second half of the array
                l= mid+1;
            }else{
                //if mid is greater than target srch in first half of the array
                h=mid-1;
            }
        }
        return -1;
    } 
    
    int findLast(int[] nums, int target){
        int l=0, h= nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                //if mid is equal to target and mid+1 is greater than target means 
                //this is the last occurance
                if(mid==h || nums[mid+1]>target){
                    return mid;
                }else{
                //else look in the first half for last occ
                    l=mid+1;
                }
            }
            //if mid is less than target look for the occ on left side
            else if(nums[mid]<target){
                
                    l=mid+1;
            }else{
                    h=mid-1;
            }
        }
        return -1;
    }
    
}
