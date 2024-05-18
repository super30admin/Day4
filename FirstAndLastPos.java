class FirstAndLastPos {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int firstIndex = firstBinarySearch(nums, target);
        if(firstIndex == -1)
            return new int[]{-1,-1};

        int secondIndex = secondBinarySearch(nums, target);

        return new int[]{firstIndex, secondIndex};
    }

    //Binary search to find 1st index of target
    public int firstBinarySearch(int nums[], int target) {

        int low = 0;
        int high = nums.length -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                if(mid == low || nums[mid-1] != target)
                    return mid;

                high = mid-1;
            }

            else if(nums[mid] > target) {
                high = mid -1;
            }

            else {
                low = mid+1;
            }
        }

        return -1;
    }

    //Binary search to find 2nd index of target
    public int secondBinarySearch(int nums[], int target) {

        int low = 0;
        int high = nums.length -1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                if(mid == high || nums[mid+1] != target)
                    return mid;

                low = mid+1;
            }

            else if(nums[mid] > target) {
                high = mid -1;
            }

            else {
                low = mid+1;
            }
        }

        return -1;
    }

}