class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
                System.out.println(left);
        System.out.println(right);
        while (left < right) {
            int mid = left + (right - left) / 2;
                    System.out.println(mid);
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
