class SolutionFirstLast {

    private int searchLastIdx(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low +(high-low)/2;

            if(nums[mid] == target){
                if(mid==high || (nums[mid] < nums[mid+1])){
                    return mid;
                } else {
                    low = mid+1;
                }
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    private int searchFirstIdx(int[] nums, int target){
        int low = 0;
        int high =  nums.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(nums[mid] == target){
                if(mid==0 || (nums[mid] > nums[mid-1])){
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }

        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        if(nums.length==0) return new int[]{-1,-1};
        if(target>nums[high] || target<nums[low]) return new int[]{-1,-1};

        int first = searchFirstIdx(nums,target);
        if(first == -1) return new int[]{-1,-1};

        int last = searchLastIdx(nums, first, high, target);

        return new int[]{first,last};

    }
}