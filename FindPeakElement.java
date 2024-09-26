public class FindPeakElement {

  /**
   * Time complexity :O(logn).
   * Space complexity :O(1).
   * Used binary search approach by handling first and last element edge cases. Kept the search space on greater mid ( left || right side)
   *
   */

  public int findPeakElement(int[] nums) {
    int leftIdx = 0, rightIdx = nums.length - 1, midIdx;
    while (leftIdx <= rightIdx) {
      midIdx = leftIdx + (rightIdx - leftIdx) / 2;
      if ((midIdx == nums.length - 1 || nums[midIdx] > nums[midIdx + 1])
          && (midIdx == 0 || nums[midIdx] > nums[midIdx - 1])) {
        return midIdx;
      }

      else if (midIdx != 0 && nums[midIdx] < nums[midIdx - 1]) {
        rightIdx = midIdx - 1;
      } else {
        leftIdx = midIdx + 1;
      }

    }
    return -1;
  }

  public static void main(String args[]) {
    FindPeakElement fPE = new FindPeakElement();
    int[] nums = { 1, 2, 3, 1 };
    int result = fPE.findPeakElement(nums);
    System.out.println(result);
  }
}