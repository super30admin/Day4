public class FindPeak {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid == 0 || nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low + 1;
    }

    public static void main(String[] args) {
        FindPeak fp = new FindPeak();
        int arrayToFindPeak1[] = { 1, 2, 3, 1 };
        int arrayToFindPeak2[] = { 1, 2, 1, 3, 5, 6, 4 };
        int peakIndex1 = fp.findPeakElement(arrayToFindPeak1);
        int peakIndex2 = fp.findPeakElement(arrayToFindPeak2);
        System.out.println(peakIndex1);
        System.out.println(peakIndex2);
    }
}
