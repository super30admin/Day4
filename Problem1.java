// Time Complexity: O(log(n))
// Space Complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[] {-1, -1};
        }

        int startPos = leftSearch(nums, target);
        if(startPos == -1){
            return new int[] {-1, -1};
        }
        int endPos = rightSearch(nums, target);
        return new int[] {startPos, endPos};

    }

    private int leftSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(nums.length != 1){
                    if(mid != low && nums[mid-1] != target){
                        return mid;
                    } else if(mid == low){
                        return mid;
                    }else {
                        high = mid - 1;
                    }
                } else {
                    return mid;
                }
            } else {
                if(nums[mid] < target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int rightSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(nums.length != 1){
                    if(mid != high && nums[mid+1] != target){
                        return mid;
                    } else if(mid == high){
                        return mid;
                    }else {
                        low = mid + 1;
                    }
                } else {
                    return mid;
                }
            } else {
                if(nums[mid] < target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
