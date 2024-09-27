//TimeComplexity: O(log 2N) ; 2 Log(n) operations to find first and last index = 0(log N);
//Space Complexity: O(1); no extra space
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 ){
            return new int[]{-1,-1};
        }
        int i = findFirstIndex(nums,target);
        int j = findLastIndex(nums,target);
        return new int[]{i,j};

    }
    public int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0){
                    return 0;
                }else if(nums[mid -1] == target){
                    high = mid-1;
                } else if( nums[mid -1] < target) {
                    return mid;
                }
            }else if(nums[mid] < target) {
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
    public int findLastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                if(mid == nums.length-1){
                    return mid;
                } else if(nums[mid +1] == target){
                    low = mid+1;
                } else if( nums[mid +1] > target) {
                    return mid;
                }
            }else if(nums[mid] < target) {
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}