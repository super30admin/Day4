import com.ibm.jvm.dtfjview.commands.FindCommand;

public class Problem3 {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] <= nums[end] || nums.length == 1) {
            return nums[0];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean leftSorted = nums[start] <= nums[mid];
            boolean rightSorted = nums[mid] < nums[end];
            if (leftSorted & rightSorted) {
                return nums[start];
            }
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (leftSorted) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 4, 5, 1 };
        int minEle = findMin(nums);
        System.out.println(minEle);
    }
}
