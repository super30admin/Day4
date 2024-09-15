// Time Complexity : Twice O(Log n) ~ (Log n); We are running two binary searches to find the first and last position.
// Space Complexity : O(1); except variables not using any extra space.
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/636657749/)
// Any problem you faced while coding this : No
// My Notes : Find the target, then move towards both the direction till you reach end or encouter a different element
public class FindFirstLastPosInSortedArr {

    public int[] searchRange(int[] nums, int target) {
        int firstPos = -1, lastPos = -1;
        int arrPos[] = { firstPos, lastPos };
        if (nums.length == 0) {
            // If empty arr then no element to search
            return arrPos;
        }
        // Get First position; Using normal iterative binary search
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // System.out.println(" First Position Vars : start,mid,end : " + start + " , "
            // + mid + ", " + end);
            if (nums[mid] == target) {
                if (mid != 0 && nums[mid - 1] == target) {
                    // continue search till left
                    end = mid - 1;
                } else {
                    // Found the first position when the left element is not equal to the target
                    firstPos = mid;
                    break;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Get Last position; Using normal iterative binary search
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //System.out.println(" Last Position Vars : start,mid,end : " + start + " , " + mid + ", " + end);
            if (nums[mid] == target) {
                if ((mid != nums.length - 1) && nums[mid + 1] == target) {
                    // continue search till end rigth direction
                    start = mid + 1;
                } else {
                    // Found the last position when the right element is not equal to the target
                    lastPos = mid;
                    break;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        arrPos[0] = firstPos;
        arrPos[1] = lastPos;
        return arrPos;
    }

    public static void main(String[] args) {
        FindFirstLastPosInSortedArr obj = new FindFirstLastPosInSortedArr();
        int[] nums = { 1, 3, 3, 3, 3, 3, 4, 4, 5, 9 };
        int target = 5;
        int[] pos = obj.searchRange(nums, target);
        System.out.println(" POS : " + pos[0] + ", " + pos[1]);
    }
}
