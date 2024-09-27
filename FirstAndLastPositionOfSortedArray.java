//Time Complexity O(log n) space complexity O(1)
class FirstAndLastPositionOfSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null && nums.length == 0)
            return new int[] {-1,-1};
        int first = getFirstIndex(nums, target);
        if(first == -1){
            return new int[] {-1,-1};
        }
        int second = getSecondIndex(nums, target, first);

        return new int[] {first,second};

    }
    private int getFirstIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid]==target){
                if(mid == low || nums[mid-1]!=target)
                    return mid;
                else
                    high = mid - 1;
            }
            else if(target > nums[mid])
                low = mid + 1;
            else
                high = mid -1;

        }
        return  -1;
    }

    private int getSecondIndex(int[] nums, int target, int low){
        int high = nums.length-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1]!=target)
                    return mid;
                else
                    low = mid + 1;
            }else if(target<nums[mid])
                high = mid - 1;
            else
                low = mid - 1;
        }
        return -1;
    }

}