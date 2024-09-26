import java.util.Arrays;

/**
 * Time Complexity is O(logn);
 * Space Complexity is O(1);
 * Ran Binary search on two directions to see left-most and right-most
 *
 */
public class FindFirstAndLast {

  private int firstIdx(int[] nums, int target) {
    int leftIdx = 0, rightIdx = nums.length - 1;
    while (leftIdx <= rightIdx) {
      int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
      if (nums[midIdx] > target) {
        rightIdx = midIdx - 1;
      } else if (nums[midIdx] < target) {
        leftIdx = midIdx + 1;
      } else {
        if (midIdx == 0) {
          return midIdx;
        } else if (nums[midIdx - 1] != target) {
          return midIdx;
        } else
          rightIdx = midIdx - 1;
      }
    }
    return -1;
  }

  private int lastIdx(int[] nums, int target) {
    int leftIdx = 0, rightIdx = nums.length - 1;
    while (leftIdx <= rightIdx) {
      int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
      if (nums[midIdx] > target) {
        rightIdx = midIdx - 1;
      } else if (nums[midIdx] < target) {
        leftIdx = midIdx + 1;
      } else {
        if (midIdx == nums.length - 1) {
          return midIdx;
        } else if (nums[midIdx + 1] != target) {
          return midIdx;
        } else
          leftIdx = midIdx + 1;
      }
    }
    return -1;
  }

  public int[] searchRange(int[] nums, int target) {
    return new int[] { this.firstIdx(nums, target), this.lastIdx(nums, target) };
  }

  public static void main(String args[]) {
    FindFirstAndLast fFL = new FindFirstAndLast();
    int[] nums = { 5, 7, 7, 8, 8, 10 };
    int[] result = fFL.searchRange(nums, 8);
    System.out.println(Arrays.toString(result));
  }
}
