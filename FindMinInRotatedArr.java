// TIME: O(logn)
// SPACE: O(1)
// SUCCESS on LeetCode

public class FindMinInRotatedArr {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } 
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
            if (nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{6,7,8,1,2,3,4,5};
        FindMinInRotatedArr findMinInRotatedArr = new FindMinInRotatedArr();
        System.out.println(findMinInRotatedArr.findMin(arr));
    }
}
