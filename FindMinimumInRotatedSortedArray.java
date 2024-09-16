/*Trick: One side of the array around mid will always be sorted
We need to find which side is sorted. And then we can continue applying a binary search 
Time complexity: O(LogN)
Space complexity: O(1) 
*/
class Solution {
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length-1; int mid; int min = nums[0];
        //find the sorted side
        while(low<=high)
        {
            mid=low+(high-low)/2;
            min = Math.min(nums[mid], min);
            if(nums[mid]>=nums[low]) //left side is sorted
            {
                min = Math.min(nums[low], min);
                low=mid+1;
            }
            else //right side is sorted
            {
                if(mid+1<=nums.length-1)
                    min = Math.min(nums[mid+1], min);
                high=mid-1;
            }
        }
        return min;
    }
}