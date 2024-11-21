//TC: O(logn)
//SC: O(1)
//Leetcode : successful

// Description: performing Binary search and comapring the middle element with its previous and next element and conditions for mid =0 and mid = last element in the array 

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        int l=0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(mid>0 && mid<nums.length-1){
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid-1] > nums[mid])
                h = mid-1;
            else 
                l = mid+1;
        }
            if (mid == 0)
            { 
            if(nums[0]>nums[1])
                return 0;
            else
                return 1;
            }
            if(mid==nums.length-1)
            {
            if(nums[nums.length-1]>nums[nums.length-2])
                return nums.length-1;
            else 
                return nums.length-2;
        }    
    }
  return 0;      
}
}