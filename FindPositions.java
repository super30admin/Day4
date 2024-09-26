// TIME: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode

public class FindPositions {
    private int findBound(int[] nums, int target, boolean first) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                if (first) {
                if (mid == start || nums[mid - 1] != target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
                } else {
                if (mid == end || nums[mid + 1] != target) {
                    return mid;
                } else {
                    start = mid + 1;
                }
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return new int[] {-1,-1};
        }
        int last = findBound(nums, target, false);
        return new int[] {first, last};
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,7,7,7,7,7,8,9,10};
        FindPositions findPositions = new FindPositions();
        System.out.println(findPositions.searchRange(nums, 7).toString());
    }
}
