// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class FindPeakElement {
        public int findPeakElement(int[] nums) {
           if(nums == null || nums.length == 0) return -1;
            int l = 0;
            int h = nums.length - 1;

            while (l < h) {
                int mid = l + (h - l) / 2;
                int a = nums[mid];
                int b = mid - 1 >= 0 ? mid - 1 : mid;
                int c = mid + 1 < nums.length ? mid + 1 : mid;
                if (a >= nums[b] && a >= nums[c]) {
                    return mid;
                } else {
                    if (a < nums[b]) {
                        h = b;
                    } else if (a < nums[c]) {
                        l = c;
                    }
                }
            }
            if (nums[l] < nums[h])
                return h;
            return l;
        }
}
