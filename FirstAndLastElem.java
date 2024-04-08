class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){ //Returns -1,-1 if the array is empty
            return new int[]{-1, -1};
        }
        if (target < nums[0] || target > nums[nums.length - 1]){ //If the target doesn't lie within the range of the array then return -1,-1
            return new int[]{-1, -1};
        }
        int first = (binarySearchFirst(nums, target)); //Performs binary search to find last elem
        if (first == -1) return new int[]{-1, -1}; //If not found, return -1,-1
        int second = (binarySearchSecond(nums, target)); //Performs binary search to find last elem
        return new int[]{first, second}; //Returns the first and last element
    }

    private int binarySearchFirst(int[] nums, int target){
        int low = 0; int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2; //Calculates the middle element
            if(nums[mid] == target){
                if (mid == low || nums[mid - 1] != target){ //If middle elem is equal to target, the it checks if mid - 1 is not equal to target then return mid
                    return mid;
                } else{
                    high = mid - 1; //If mid - 1 is equal to the target, move to the left
                }
            } else if(nums[mid] > target){
                high = mid - 1; //If mid is greater than target, move to the left
            } else{
                low = mid + 1; //Otherwise move to the right
            }
        }
        return -1;
    }

    private int binarySearchSecond(int[] nums, int target){
        int low = 0; int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2; //Calculates the middle element
            if(nums[mid] == target){
                if (mid == high || nums[mid + 1] != target){ //If middle elem is equal to target, the it checks if mid + 1 is not equal to target then return mid
                    return mid;
                } else{
                    low = mid + 1; //If mid + 1 is equal to the target, move to the right
                }
            } else if(nums[mid] > target){
                high = mid - 1; //If mid is greater than target, move to the left
            } else{
                low = mid + 1; //Otherwise move to the right
            }
        }
        return -1;
    }
}