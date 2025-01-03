// Time Complexity :O (log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || nums==null){              //Base condition
            return new int[] {-1,-1};
        }
        if(target < nums[0] || target > nums[nums.length-1]){     //If target is less than or greater than low and high respectively
            return new int[] {-1,-1};
        }
        
        int start=-1;
        int end=-1;
        start = findStartIndex(nums,target);         //We will find the first occurence 
        if(start!=-1){                                  
            end=findLastIndex(nums,target);        // If first occurence is present then only search for last instance 
        }

        return new int[]{start,end};                //Return first and last

    }
    private int findStartIndex(int[] nums, int target){   //Function to find start index
        int low=0;  
        int high=nums.length-1;
        while(low<=high){                                   //We will find mid and then the  instance if it is found then go to left to find the first instance and if not then return the found instance else if not found then return -1
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                if(mid > low && nums[mid-1]==target){
                    high=mid-1;
                }else{
                    return mid;
                }
            }
            else if(target> nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }


    private int findLastIndex(int[] nums, int target){     //This is function to find last instance
        int low=0;
        int high=nums.length-1;
        while(low<=high){                                   ////We will find mid and then the  instance if it is found then go to righr to find the last instance and if not then return the found instance else if not found then return -1
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                if(mid < high && nums[mid+1]==target){
                    low=mid+1;
                }else{
                    return mid;
                }
            }
            else if(target> nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}



// Time Complexity :O (log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes


class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){         //Base condition
            return -1;
        }
        int low=0;
        int high=nums.length-1;
        while(low<=high){                      // To find mid there are 3 condition 1. if the array is sorted return the first element. 
                                                //2. If both the adjacent elements are greater than the element return it ELSE move to unsorted side
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            if((mid>low && nums[mid] < nums[mid-1]) && (mid<high && nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else{
                if(nums[low]<=nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}



