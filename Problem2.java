//Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
//Space complexity : O(1)
//Time complexity : O(logn)
class Problem2 {
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
    }
}