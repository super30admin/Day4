/*
    Ran all test cases
    TC - O(logn)
    SC - O(1)
    Method - binary search - find mid element. Check if the element is greater than the previous element and less than the next element. if so, return the element. Else, check the two parts - see which part is unsorted. proceed to binary search the unsorted part.
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0 || nums==null) return -1;
        int low = 0;
        int high = nums.length-1;
        if(nums[low]<=nums[high]) return nums[low];
        while(low<=high)
        {
            if(nums[low]<=nums[high])
                return nums[low];
            int mid = low + (high-low)/2;
            if((low==mid || (nums[mid-1] > nums[mid])) && (high==mid || (nums[mid] < nums[mid+1])))
                return nums[mid];
            if(nums[mid] < nums[low])
            {
                high = mid -1;
            }
            else if(nums[mid] > nums[high])
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}