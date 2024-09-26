//TC : O(logn) as binary search is used
//SC : O(1)

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//
public class Problem3 {
        public int findPeakElement(int[] nums) {


            int mid = 0;
            int low = 0;
            int high = nums.length - 1;

            while (low < high)
            {
                mid = low + (high-low)/2;

                //Note [mid] means element at index equal to mid.
                //Tere are two cases that can happen :
                //case 1 : The element to the right of mid is lesser than [mid] . In this case, the peak is on the left half
                //of the array including mid. so, we set high = mid and continue search

                //case 2: The element to the right is greater than the [mid], in this case, the peak definitely lies in the right
                //half and does not include [mid] as it cant be a peak

                //if this is true it means that the peak lies in the left part including [mid], hence we set high=mid
                if (nums[mid] > nums[mid + 1])
                    high = mid;

                    //if this condition is true that means peak lies in the right part excluding [mid], hence we set low = mid-1
                else if (nums[mid] < nums[mid + 1])
                    low = mid + 1;
            }

            //while loop is exited when low == high, hence we can return either low or high
            return high;

        }

}
