public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length - 1;
        while (low < high) {
            if (nums[low] < nums[high])
                return nums[low];
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int arrayToSearch1[] = { 3, 4, 5, 1, 2 };
        int arrayToSearch2[] = { 4, 5, 6, 7, 0, 1, 2 };
        int arrayToSearch3[] = { 11, 13, 15, 17 };
        MinInRotatedSortedArray mrs = new MinInRotatedSortedArray();
        int low1 = mrs.findMin(arrayToSearch1);
        int low2 = mrs.findMin(arrayToSearch2);
        int low3 = mrs.findMin(arrayToSearch3);
        System.out.println(low1);
        System.out.println(low2);
        System.out.println(low3);

    }
}
