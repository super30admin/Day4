// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//In this we first check if the array is rotated at all. If l < r then then it is not rotated and the first element has to be the min.
//If it is rotated , we try to figure out which part of the array we can disregard.
//if it is just before and after the mid or at the mid , we return it
//else we keep trying to change l and r and keep disregarding the arrays

class Solution {
    public int findMin(int[] nums) {
        
        
        int l = 0;
        int r = nums.length-1;
        //if is it already a sorted array
        if(nums[l]<nums[r])
        {
            return nums[l];
        }
        //if array has only one element
        if(nums.length==1)
        {
            return nums[l];
        }
        while(l <= r)
        {
            int mid = l +(r-l)/2;
            //if it is the element next to the mid
            if(nums[mid]>nums[mid+1])
            {
                return nums[mid+1];
            }
          //if it is the element at the mid
            if(nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            
            //keep disregarding the elements where we won't find the element
            if(nums[mid]>nums[l])
            {
                l = mid + 1;
            }
            else
            {
                r = mid -1;
            }
            
        }
        return -1;
    }
}

//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//This is from the apporoach discussed in class , basically we check if element at mid is greater than element at r that means we have to search
//in right side of mid
//and we return mid when the element before mid is smaller than mid and element after mid is greater than mid

class Solution {
 public int findMin(int[] nums) {
     
     
     int l = 0;
     int r = nums.length-1;
     //if is it already a sorted array
     if(nums[l]<nums[r])
     {
         return nums[l];
     }
     //if array has only one element
     if(nums.length==1)
     {
         return nums[l];
     }
     while(l <= r)
     {
         int mid = l +(r-l)/2;
         
         //checking mid if it is smaller than both previous and next , also accomodating boundary conditions
         if((mid==0 || nums[mid]<nums[mid-1]) && (mid == nums.length-1 || nums[mid]<nums[mid+1]))
         {
        	 return nums[mid];
         }
         //this case represents that min is at right side of mid we can disregard the left side
         if(nums[mid]>nums[r])
         {
        	 l = mid + 1;
         }
         else
         {
        	 r = mid -1;
         }
         
     }
     return -1;
 }
}