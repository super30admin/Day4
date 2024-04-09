// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

public class FindFistAndLastPosLC34 {
    public static int[] searchRange(int[] nums, int target) {
        int high = nums.length - 1;
        if (high == 0) {
            return nums[0] == target ? new int[] { 0, 0 } : new int[] { -1, -1 };
        }

        int firstIndex = binarySearchFirst(nums, target);
        if (firstIndex == -1)
            return new int[] { -1, -1 };
        int secondIndex = binarySearchSecond(nums, target, firstIndex);
        return new int[] { firstIndex, secondIndex };
    }

    // always check if mid = target, mid> target, mid<target.
    private static int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            /*
             * Step1: if(check if nums[mid] == target){ }
             * Step2: else{ in else part check 2 conditions.
             * 1. if element >target
             * 2. else case. that is element <target.
             * }
             */
            if (nums[mid] == target) { // step1:
                if (mid != 0 && nums[mid - 1] == target) {// one additional step: check if mid-1 = target if yes,set
                                                          // high as mid-1
                    high = mid - 1;
                } else
                    return mid;// else mid will be the first position.

            } else {// step2:
                if (nums[mid] > target) {// step2.1
                    high = mid - 1;
                } else {// step 2.2
                    low = mid + 1;
                }
            }

        }
        return -1;
    }

    // always check if mid = target, mid> target, mid<target.
    private static int binarySearchSecond(int[] nums, int target, int low) {// find last index of target.
        // here I am passing begining index of target as low.
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {// checking if mid == target
                if (mid != high && nums[mid + 1] == target) {// nums[mid+1] = target=> more target elements on right
                                                             // side. set low as mid+1;
                    low = mid + 1;
                } else
                    return mid;// else=> all elements after nums[mid] is > target so return mid as last index.

            } else {// step 2
                if (nums[mid + 1] > target) {// step 2.1
                    high = mid - 1;
                } else {// step 2.2
                    return mid;
                }

            }

        }
        return -1;
    }

}
// YT link:https://youtu.be/TQuyNmM5-pg