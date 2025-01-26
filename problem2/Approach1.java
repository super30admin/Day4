
package problem2;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Approach1 {
    public static void main(String[] args) {

        Approach1 obj = new Approach1();

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

        int n = nums.length;
        int low  = 0;
        int high  = nums.length - 1;

        while (low <= high) {

//            complete range is sorted
            if (nums[low] < nums[high]) {

                System.out.println("in if 1");

                return nums[low];
            }

            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {

                System.out.println("in if 2");

                    return nums[mid];
            }
//            left side is sorted move to the right side
            else if(nums[low] <= nums[mid]) {

                System.out.println("in else if");

                low = mid + 1;
            }
            else {

                System.out.println("in else");

                high = mid - 1;
            }
        }

        return 0;
    }
}