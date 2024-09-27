public class RotatedMin {

    int min = 5001;

    public int findMin(int[] nums) {
        min = 5001;
        int l = 0;
        int h = nums.length - 1;
        int m = l + (h - l) / 2;
        if (h + 1 <= 0) {
            min = 5001;
        } else if (nums[l] <= nums[h]) {
            min = nums[l];
        } else {
            if (nums[l] < nums[m]) {
                while (nums[l] < nums[m] && m < h) {
                    m++;
                }
                min = nums[m];
            } else {
                min = nums[m];
                while (nums[l] > nums[m] && m > l) {
                    m--;
                }
                min = nums[++m];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int[] nums1 = { 4 };
        int[] nums2 = { 7, 0, 1, 2, 4, 6 };
        int[] nums3 = { 2, 3, 4, 5, 6, 7, 1 };
        int[] nums4 = {};
        RotatedMin rm = new RotatedMin();
        System.out.println(rm.findMin(nums));
        System.out.println(rm.findMin(nums1));
        System.out.println(rm.findMin(nums2));
        System.out.println(rm.findMin(nums3));
        System.out.println(rm.findMin(nums4));
    }
}
