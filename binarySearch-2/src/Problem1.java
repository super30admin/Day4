
//TC : O(logn) as binary search is used
//SC : O(1)

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class Problem1 {

    public int[] searchRange(int[] nums, int target) {
            int[] soln = new int[2];
        soln[0] = findFirstOccurence(nums, target);
        soln[1] = findLastOccurence(nums, target);
            return soln;
        }


    //method to find first occurence, the only change is if [mid] == target then we dont stop there.
    //We set end=mid-1 and discard the right half as we want to find the first occurence
        private int findFirstOccurence(int[] nums, int target){
            int index = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end)
            {
                int mid = start + (end-start)/2;

                if(nums[mid] >= target)
                    end = mid - 1;
                else
                    start = mid + 1;

                if(nums[mid] == target)
                    index = mid;
            }
            return index;
        }

        //method to find last occurence, the only change is if [mid] == target then we dont stop there.
    //We set start = mid+1 and discard the left half as we want to find the last occurence
        private int findLastOccurence(int[] nums, int target){
            int index = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end)
            {
                int mid = start + (end-start)/2;

                if(nums[mid] <= target)
                    start = mid + 1;
                else
                    end = mid - 1;

                if(nums[mid] == target)
                    index = mid;
            }
            return index;
        }
}
