
public class Peak {

    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int peak = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if ((mid == 0 || (nums[mid] > nums[mid - 1])&&  ( mid == nums.length -1 ||nums[mid] > nums[mid + 1])) {
                peak = mid;
                break;
            } else if (nums[mid - 1] > nums[mid] && mid >= 0) {
                h = mid - 1;
            } else if (nums[mid + 1] > nums[mid] && mid <= h) {
                l = mid + 1;
            }
        }
        return peak;

    }

    public static void main(String[] args) {
        Peak p = new Peak();
        int[] arr = { 1, 2, 1, 3, 4, 5, 6, 7 };
        int[] arr1 = { 1, 2, 1, 3, 1, 5, 7, 9 };
        int[] arr2 = { 1, 2, 7, 3, 1, 5, 7, 9 };

        System.out.println(p.findPeakElement(arr));
        System.out.println(p.findPeakElement(arr1));
        System.out.println(p.findPeakElement(arr2));
    }
}
