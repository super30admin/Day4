//Time complexity - O(log n)
//Space complexity - O(1)

class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;

        if(nums[0]<nums[nums.length-1]||nums.length==1)
            return nums[0];

        //Applying the concept that one part of rotated array will always be sorted

        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right)
        {
            mid=left+(right-left)/2;
            if((mid==0||nums[mid]<nums[mid-1])&&(mid==nums.length-1||nums[mid]<nums[mid+1]))
                return nums[mid];
            else if(nums[mid]>=nums[left]&&nums[mid]<nums[right])
            {
                right=mid-1;
            }
            else
            {
                if(nums[mid]<nums[left])
                    right=mid-1;
                else
                    left = mid+1;
            }
        }

        return -1;
    }
}