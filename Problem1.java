//Time complexity - O(log n)
//Space complexity - O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int last = -1;
        result[0] = -1;
        result[1] = -1;

        //Run Binary Search to find first position i.e. nums[mid]>nums[mid-1]
        //If we found the first position run binary search to find last position nums[mid]<nums[mid+1]

        if(nums==null || nums.length==0)
            return result;

        int first = binarySearchFirst(nums,target);
        if(first>=0)
            last = binarySearchlast(nums,target,first);

        result[0]=first;
        result[1]=last;

        return result;
    }

    public int binarySearchFirst(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left<=right)
        {
            mid=left+(right-left)/2;
            if((nums[mid]==target)&&(mid==0||nums[mid]>nums[mid-1]))
                return mid;
            else if(nums[mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }

        return -1;
    }

    public int binarySearchlast(int[] nums, int target, int first)
    {
        int left = first;
        int right = nums.length-1;
        int mid = 0;

        while(left<=right)
        {
            mid=left+(right-left)/2;
            if((nums[mid]==target)&&(mid==nums.length-1||nums[mid]<nums[mid+1]))
                return mid;
            else if(nums[mid]>target)
                right = mid-1;
            else
                left = mid+1;
        }

        return -1;
    }

}