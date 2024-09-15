// Leetcode problem 153
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : Not able to get the time complexity


// Your code here along with comments explaining your approach
/**Implementation is based on Binary Search. The middle element is calculated and thus the neighbouring 2 elements are checked. If the right neighbour of mid is less than that of mid element. Then, right neighbour would be the the minimum value. In case the left neighbour of midis greater than mid, then the mid is the minimum value. In case both the conditions doesnt fulfill, then we check for the sub array which might be unsorted. We start by comparing the middle value with the last element in array, if the mid value is greater than the last element, we know that the minimum value would be in the right subarray, hence we change the low pointer to mid+1. If left array is unsorted, we change the high pointer to mid -1. Then we keep on applying Binary Search untill we find the minimum element.
*/


class Solution {
    public int findMin(int[] nums) {
        
        //if array has just one value
        if(nums.length == 1)
            return nums[0];
        
        //if array has just 2 values
        if(nums.length == 2)
            return (nums[0]<nums[1])?nums[0]:nums[1];
        
       int low = 0;
       int high = nums.length - 1;
        
        //if array is sorted but not rotated
        if(nums[low] < nums[high])
            return nums[low];
        
        
       
        
        while(low<=high){
            
            
            int mid = (high-low)/2+low;
            
            if(nums[mid] > nums[mid+1])
               return nums[mid+1];
               
            if(nums[mid]<nums[mid-1])
               return nums[mid];
               
            if(nums[mid]>nums[high])//right array contains pivot point 
               low = mid + 1;
            else
               high = mid - 1;
        
       }
        return -1;
    }
}