class SearchFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        // null check
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int length = nums.length;
        // checking for element not present in the array
        if(nums[0]>target || nums[length-1]<target)
            return new int[]{-1, -1};

        int first = binarySearchFirst(nums, target);
        if(first == -1) return new int[]{-1, -1};

        int last = searchLast(nums, target, first, length-1);
        return new int[]{first, last};

    }
    public int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid==0 || nums[mid]>nums[mid-1]) return mid;
                else if(nums[mid]<nums[mid+1]){
                    high = mid-1;
                }
                else low = mid+1;
            }
        }
        return -1;
    }
    public int searchLast(int[] nums, int target, int startIndex, int lengthIndex){
        int low = startIndex; int high = lengthIndex;
        if(nums[low]< nums[low+1]) return low;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == high || nums[mid]<nums[mid+1]) return mid;
                else if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return low;
    }
}