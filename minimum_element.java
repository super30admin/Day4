//TC: O(logn)
// SC ; O(1)
// Leetcode : Successful
// Description: Checking whether the array is rotated or not and consodering the smaller range and performing the BS

class Solution {
    public int findMin(int[] nums) {
    int low =0;
    int high = nums.length-1;
    while(low<high)
    {
    int mid = low +(high-low)/2;
    if(nums[mid]>nums[high])
    {
    low = mid+1;
    }
    else
    high = mid;
    }
    return nums[low];
    
    }
    }