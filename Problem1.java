//Time Complexity: O(log n)
//Space Complexity O(1)
//Yes the code ran successfully in leetcode
//No problem faced
//34. Find First and Last Position of Element in Sorted Array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if( nums==null || nums.length==0){
            return new int[] {-1,-1};
        }
        if(target<nums[0] || target>nums[nums.length-1]){ // checking out of bounds case
            return new int[] {-1,-1};
        }

        int first=binarySearchFirst(nums,target);
        int last=binarySearchLast(nums,target);

        if(first==-1){ // target not found in array
            return new int[] {-1,-1};
        }
        return new int[]{first,last};
    }

    private int binarySearchFirst(int nums[], int target){ // check the leftmost target
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid] == target){
                if(mid==0 || nums[mid-1]!=target){ // checks adjacent and edge case
                return mid;
                }
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int nums[], int target){ // checks the rightmost targer
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid] == target){
                if(mid==nums.length-1 || nums[mid+1]!=target){ // // checks adjacent and edge case
                return mid;
                }
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1; // moves left
            }
            else{
                low=mid+1; // moves right
            }
        }
        return -1;
    }  
}
