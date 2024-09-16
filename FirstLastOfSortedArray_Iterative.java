// Time Complexity : O(logN) is best cases and O(N) in worst cases.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes and 100% Time 97% Space
// Any problem you faced while coding this : LeetCode test cases are not much reliable.

public class FirstLastOfSortedArray {
        public int[] searchRange(int[] nums, int target) {
            //Base cases
            if(nums==null || nums.length==0) {
                return new int[]{-1, -1};
            }

            //Modification to Binary Search as per our requirement.
            int low=0;
            int mid;
            int high=nums.length-1;
            while(low<=high) { //We use Iteration here instead of Recursion to save space. Recursion code also is below.
                mid = (low+high)/2;
                if (nums[mid] == target) {
                    //Left and Right handles for the target values start and end index.
                    // LeftHandle to hold the start index and RightHandle to hold the end index.
                    int leftHandle=mid;
                    int rightHandle=mid;
                    while(leftHandle>=0 && nums[leftHandle]==target){ //As long the LeftHandle is the target value and it is a valid index, we will move further left.
                        leftHandle--;
                    }
                    while(rightHandle<=nums.length-1 && nums[rightHandle]==target){ //As long the RightHandle is the target value and it is a valid index, we will move further left.
                        rightHandle++;
                    }
                    return new int[]{leftHandle+1, rightHandle-1}; //When both the start and end positions are known, since we decremented and incremented in loop, here we are fixing it.
                } else if (nums[mid] > target) { //Default Binary Search Tree mechanism for Left sub array
                    high=mid-1;
                } else { //Default Binary Search Tree mechanism for Right sub array
                    low=mid+1;
                }
            }
            return new int[]{-1, -1};
        }

    /*
    public static void main(String... args){
        int[] nums={5,7,7,8,10};
        int[] result = new FirstLastOfSortedArray().searchRange(nums, 7);
        System.out.println(result[0] + " " + result[1]);
    }
    */
}
