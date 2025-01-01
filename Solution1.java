class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = find_first_occurence(nums, target);
        result[1] = find_last_occurence(nums, target);
        return result;
    }

    public int find_first_occurence(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                index = mid;
                if(mid > 0){
                    high = mid - 1;
                }
                else{
                    return index;
                }
            }
        }
        return index;
    }

    public int find_last_occurence(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                index = mid;
                if(mid < nums.length - 1){
                    low = mid  + 1;
                }
                else{
                    return index;
                }
            }
        }
        return index;
    }
}