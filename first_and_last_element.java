class Solution{
    public int[] searchRange(int[] nums, int target){
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        if(nums[0] == target && nums[nums.length-1] == target){
            return new int[] {0, nums.length -1}
        }
        int left = binarySearchLeft(nums, target);
        if(left == -1){
            return new int[] {-1.-1};
        }
        int right = binarySearchRight(nums, target);
        return new int[] {left, right};
    }
    private int  binarySearchLeft(int[] nums, int target){
        int low = 0; high = nums.length -1;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid -1] < nums[mid]) {
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }
            else if(target<nums[mid]){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
    private int binarySearchRight(int[] nums, int target){
        int low = 0, high = nums.length -1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(nums[mid] == target){
                if(mid == nums.length -1 || nums[mid+1] > nums[mid]){
                    return mid;
                }
                else{
                    low = mid +1;
                }
            }
            else if(target < nums[mid]){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}