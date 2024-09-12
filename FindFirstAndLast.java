public class FindFirstAndLast {

    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};

        if(target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1,-1};

        // FInd the first occurrence
        int first = findFirstOccurrence(nums,target);

        // first occurrence not found so, return -1,-1
        if(first == -1)
            return new int[]{-1,-1};

        // Find the second occurrence
        int second = findLastOccurrence(nums, target);
        return new int[]{first,second};
    }


    private int findFirstOccurrence(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] < nums[mid])
                    return mid;
                else
                    high = mid - 1;
            }else if(target < nums[mid]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }


    private int findLastOccurrence(int[] nums, int target){
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }else if(target < nums[mid]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
