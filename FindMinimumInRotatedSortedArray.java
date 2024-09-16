// Time Complexity : O(logN).
// Space Complexity : O(1) since iteration.
// Did this code successfully run on Leetcode : Yes and 100% Time 100% Space
// Any problem you faced while coding this : No.

public class FindMinimumInRotatedSortedArray {
        public int findMin(int[] nums) {
            //Known minimum so far in every iteration.
            int min=0;
            int low=0, high=nums.length-1;
            //If array is two element array, Return whatever is minimum between those two numbers.
            if(high-low==1){
                return (nums[low]<nums[high])?nums[low]:nums[high];
            }

            if(low==high){
                return nums[low];
            }
            //Preventing infinite loop. If high==low, it go on runs inifnitely
            while(high-low>1){
                //middle element and prevent Integer overflow error.
                int mid = low + (high-low)/2;
                //Case 1: right side sorted already but left side is the issue.
                if(nums[mid]<nums[high] && nums[mid]<nums[low]){
                    min=nums[mid]; //known minimum is now changed to middleth element
                    high=mid;
                }
                //Case 2: left side sorted already but right side is the issue.
                else if(nums[mid]>nums[high] && nums[mid]>nums[low]){
                    min=nums[high]; //known minimum is now changed to last element
                    low=mid;
                }
                //Case 3: already sorted array
                else{
                    return nums[low];
                }
            }
            return min;

        }

    public static void main(String... args){
    System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{2,3,4,5,1}));
    }
}
