/*
Author: Akhilesh Borgaonkar
Problem: Find Minimum in Rotated Sorted Array
Approach: Using binary search we find if the mid element is less than its neighboring elements. If not then check if low element is less than mid
	which states that left sub array is sorted and perform binary search on it. Else, we perform binary search in right sub array.
Time Complexity: O(logn) where n is number of elements in the array.
Space complexity: O(1) constant
LC Verified.
*/

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
           	if(nums[low]<nums[high])				//if the sub array is already sorted then return the lowest element as min
                return nums[low];
            if((mid==low || nums[mid]<nums[mid-1]) && (mid==high || nums[mid]<nums[mid+1]))	//check if the neighbors of mid element are greater than mid
                return nums[mid];
            else if(nums[low]<=nums[mid])			//check if the left sub array contains smaller elements than mid element and search in left sub array
                low=mid+1;
            else 									//assume smaller elements are in right sub array and perform binary search on right sub array now
                high=mid-1;
                
        }
        return -1;
    }
}