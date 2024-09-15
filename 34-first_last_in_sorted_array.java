//Using the BS to search for the first index and then for the second index
//Overall Time Complexity: O(2log(N)) -> O(log(N))
//Overall Space Complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};

        int low = 0;

        int first = bstFirst(nums, target);
        if(first == -1) return new int[]{-1, -1};
        int last = bstLast(nums, first, target);
        return new int[]{first, last};
    }

    //Time Complexity: O(log(N))
    private int bstFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                //Handling the edge cases
                if(mid == 0 || nums[mid - 1] < nums[mid]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(target < nums[mid]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    //Time Complexity: O(log(N))
    private int bstLast(int[] nums, int low, int target){
        int high = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                //Handling the edge cases
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(target < nums[mid]) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}