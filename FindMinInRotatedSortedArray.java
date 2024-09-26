public class FindMinInRotatedSortedArray {
  //Used vanilla binary search with pivot idx storage concept with focus on mid and last only.
  // Time complexity O(logn) & space complexity is O(1).

  public static int findMin(int[] nums) {
    int leftIdx = 0, rightIdx = nums.length - 1;
    int pivotIdx = -1;

    while (leftIdx <= rightIdx) {
      int midIdx = (leftIdx + rightIdx) / 2;
      if (nums[midIdx] <= nums[nums.length - 1]) {
        pivotIdx = midIdx;
        rightIdx = midIdx - 1;
      } else {
        leftIdx = midIdx + 1;
      }
    }
    return nums[pivotIdx];
  }

  public static void main(String args[]) {
    int[] nums = { 3, 4, 5, 1, 2 };
    int result = FindMinInRotatedSortedArray.findMin(nums);
    System.out.println(result);
  }
}
