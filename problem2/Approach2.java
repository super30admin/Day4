
package problem2;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Approach2 {
    public static void main(String[] args) {

        Approach2 obj = new Approach2();

//        case 1
//        int[] arr = new int[] {1, 2, 3, 4, 5, 6};

//        case 2
//         in this case it throws array index out of bounds exception so added a check in the if condition
//        added this mid == n - 1 ||
//        int[] arr = new int[] {2, 3, 4, 5, 6, 1};

//        case 3
//         this also throws array index out of bounds exception
        int[] arr = new int[] {2, 1};

        System.out.println(obj.findMin(arr));
    }

    public int findMin(int[] nums) {

        int left  = 0;
        int right = nums.length - 1;

        while (left < right) {

            //compelte range is sorted
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}