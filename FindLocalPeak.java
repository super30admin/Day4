// TIME: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode

public class FindLocalPeak {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) return binarySearch(nums, left, mid);
        return binarySearch(nums, mid + 1, right);
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4,5,0,7,8,6};
        FindLocalPeak findLocalPeak = new FindLocalPeak();
        System.out.println(findLocalPeak.findPeakElement(arr));
    }
}
