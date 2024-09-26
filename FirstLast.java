// Time Complexity : 0(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class FirstLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] {-1,-1};
        if(nums[0] > target || target > nums[nums.length - 1])
            return new int[] {-1,-1};

        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        return new int[] {first, last};
    }

    //search for first occurence of target
    public int binarySearchFirst(int[] nums, int target){
        int low = 0, high = nums.length - 1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return -1;
    }

    //search for last occurence of target
    public int binarySearchLast(int[] nums, int target){
        int low = 0, high = nums.length - 1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                if(mid == nums.length -1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return -1;
    }


}