class FirstAndLastPositionOfElement {

    int findMinMid(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(high >= low){
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                if(mid==low || nums[mid]!=nums[mid-1]){
                    return mid;
                }
                high = mid - 1;
            }
            if(target < nums[mid]){
                high = mid - 1;
            }else if (target > nums[mid]){
                low = mid + 1;
            }
        }
        return -1;
    }

    int findMaxMid(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(high >= low){
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                if(mid==high || nums[mid]!=nums[mid+1]){
                    return mid;
                }
                low = mid + 1;
            }
            if(target < nums[mid]){
                high = mid - 1;
            }else if (target > nums[mid]){
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int minMid = findMinMid(nums, target);
        int maxMid = findMaxMid(nums, target);

        return new int[]{minMid, maxMid};
    }
}
