// Time Complexity : O(log n) - Binary Search
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing SPecific

//Checking if the mid or its adjacent elements are minimum and return if so
//we check for the sorted array initially and return 1st element
//Later check which side of the mid to go, if mid is greater than low, then we know left side is sorted and move to right side
//Else we check the left side

class SortedArrayMin {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if(nums.length==1) return nums[0];
        if(nums[high]>nums[low]) return nums[0];
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if( nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if ( nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]>nums[low]){
                low=mid+1;
            }
            else{ high=mid-1;}
        }
        return -1;
    }
}