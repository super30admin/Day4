/*
Run time complexity : Since i am using the binary search approach, the run time will be O(logN)
Space complexity : O(1) As i did not use auxillary space to find the target.
*/

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left=0;
        int right=nums.length-1;
        if(nums[left]<nums[right])
            return nums[left];
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]>=nums[0])
                left=mid+1; // left is sorted, so go right to find the min element (as the array is sorted)
            else
                right=mid-1; // right is sorted, so go left
        }
            return nums[left];
    }
}
