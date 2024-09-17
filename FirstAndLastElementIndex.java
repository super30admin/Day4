//Complexity : O(Log N)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length == 0 )
            return new int[]{-1,-1};
        if(nums[0]>target || target>nums[nums.length-1])
            return new int[]{-1,-1};

        int firstIndex = binarySearch1(nums,target);
        if(firstIndex==-1)
            return new int[]{-1,-1};

        int secondIndex = binarySearch2(nums,target);
        System.out.println(firstIndex);
        return new int[]{firstIndex,secondIndex};
    }

    public int binarySearch1(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(high>=low)
        {
            int mid=low + (high-low)/2;

            if(nums[mid] == target)
            {
                if(mid==0 || nums[mid-1] != nums[mid])
                    return mid;
                else
                {
                    high = mid-1;
                }
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return -1;
    }

    public int binarySearch2(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(high>=low)
        {
            int mid=low + (high-low)/2;

            if(nums[mid] == target)
            {
                if(mid==nums.length-1 || nums[mid+1] != nums[mid])
                    return mid;
                else
                {
                    low = mid+1;
                }
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return -1;
    }
}