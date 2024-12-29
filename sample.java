class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0, high=nums.length-1, mid=0, firstPosition=0, lastPosition=0;
        if (nums.length == 0) {
            return new int[] {-1,-1};
        }
        if(nums.length ==1) {
            if (nums[0] == target) {
                return new int [] {0,0};
            } else {
                return new int[] {-1,-1};
            }
        }
        if (nums[0] == target && nums[nums.length-1] == target) {
            return new int [] {0,nums.length-1};
        }
        if (target > nums[nums.length-1] && target < nums[0]){
            return new int[]{-1,-1};
        }
        firstPosition = searchForFirst(nums, target, low, high);
        if (firstPosition == -1) {
            return new int[] {-1,-1};
        }
        lastPosition = searchForLast(nums, target, low, high);
        return new int[] {firstPosition, lastPosition};
    }


    public int searchForFirst(int[] nums, int target, int low, int high) {
        int mid=0;
        while (low <= high) {
            mid = low +(high-low)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                }
                high = mid-1;
            } else if (target > nums[mid]) {
                    low = mid+1;
            } else if (target < nums[mid]) {
                high = mid-1;
            }
        }
        return -1;
    }

    public int searchForLast(int[] nums, int target, int low, int high) {
        int mid=0;
        while (low <= high) {
            mid = low +(high-low)/2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }
                low = mid+1;
            } else if (nums[mid] < target ) {
                low = mid+1;
            } else if(nums[mid] > target){
                high = mid-1;
            }

        }
        return -1;
    }
}



class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length-1;


        if (nums.length == 1) {
            return nums[0];
        }

        while (low <=high){
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if (low == high) {
                return nums[mid];
            }
            if (mid != 0 && mid != nums.length-1) {
                if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
                    System.out.println("here");
                    return nums[mid];
                }
            }
            if (nums[low] <= nums[mid]) { 
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
