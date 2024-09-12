// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class Problem1FirstLastPositionOfElementInArr {
    public int[] searchRange(int[] nums, int target) {
        //base case 
        if(nums==null ||nums.length==0){
            return new int[] {-1,-1};
        }
        if (target<nums[0] || target>nums[nums.length-1]){
            return new int[]{-1,-1};
        }
        int first= binarySearchFirst(nums,target);
        if (first==-1){
            return new int []{-1,-1};
        }
        int last=binarySearchLast(nums,target);
        return new int[] {first,last};
    }
    private int binarySearchFirst(int[] nums, int target){
        int low=0; int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                if(mid==0 || nums[mid-1]<nums[mid]){ //won't return index out of range as if mid==0 it returns true without evaluating nums[mid-1]
                    return mid;
                }
                else if(nums[mid-1]==nums[mid]){ //move lower if target is present on the left 
                    high=mid-1;
                }
            }else if (target>nums[mid]){ //move higher towards target 
                low=mid+1;
            }else high=mid-1; //move lower
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int target){
        int low=0; int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                if(mid==nums.length-1 || nums[mid+1]> nums[mid]){
                    return mid;
                }
                else if(nums[mid+1]==nums[mid]){
                    low=mid+1;
                }
            }else if (target>nums[mid]){
                low=mid+1;
            }else high=mid-1;
        }
        return -1;  
    }
}
