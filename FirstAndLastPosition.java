class FirstAndLastPosition{
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] =  findFirst(nums, target);
        ans[1] =  findLast(nums, target);
        return ans;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) idx = mid;
            if(nums[mid] >= target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) idx = mid;
            if(nums[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return idx;
    }
}