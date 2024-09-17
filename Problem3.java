//Time complexity - O(log n)
//Space complexity - O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        //Do it using binary search
        //After finding the mid move to the side greater than mid
        //Check if mid is the peak element

        if(nums.length==0||nums==null)
            return -1;

        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left<=right)
        {
            mid=left+(right-left)/2;
            if((mid==0||nums[mid]>nums[mid-1])&&
                    (mid==nums.length-1||nums[mid]>nums[mid+1]))
                return mid;
            else if(mid<nums.length-1&&nums[mid+1]>nums[mid])
                left = mid+1;
            else
                right = mid-1;
        }

        return -1;
    }
}