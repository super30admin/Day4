
//finding first occurrance and second occurance using binary search logic. and checking their immediate neighbour occurance. 
//space - O(1)
//time : O(log n)

/************************ solution 1 ************************/
class FirstAndLastOccuranceinSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0 || nums == null || nums[0] > target || nums[nums.length - 1] < target)
            return new int[] { -1, -1 };

        int firstOccurance = binarySearch(nums, target);
        if (firstOccurance == -1)
            return new int[] { -1, -1 };

        int secondOccurance = binarySearch(nums, target, firstOccurance);

        return new int[] { firstOccurance, secondOccurance };

    }

    private int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid])
                    return mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    private int binarySearch(int[] nums, int target, int firstOccurance) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == high || nums[mid] < nums[mid + 1])
                    return mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

}

/************************ solution 2 ************************/

class FirstAndLastOccuranceinSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int first = -1, last = -1;
        boolean f = true, l = false;

        if (nums.length == 0)
            return new int[] { first, last };

        first = findIndex(nums, target, f);
        last = findIndex(nums, target, l);
        return new int[] { first, last };

    }

    public int findIndex(int[] nums, int target, boolean flag) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            // mid == target
            if (flag && nums[mid] == target) {
                // if mid-1 == target
                if (mid != 0 && nums[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    flag = false;
                    return mid;
                }
            }
            if (!flag && nums[mid] == target) {
                // if mid-1 == target
                if (mid != nums.length - 1 && nums[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    flag = true;
                    return mid;
                }
            }

            // mid > target

            else if (nums[mid] > target) {
                high = mid - 1;
            }
            // mid < target
            else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
}