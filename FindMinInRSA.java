/*TC - O(logn)
SC -  O(1)
if array is sorted, return the first element.
if array is unsorted, find the mid, check if element next to mid is smaller than the mid element.
if smaller, return the element. Else, move to the unsorted half. */

public class FindMinInRSA {
        public int findMin(int[] nums) {
            int n = nums.length;
            if(n==0)
            {
                return -1;
            }
            //check if array is sorted
            if(nums[0]<nums[n-1])
            {
                return nums[0];
            }

            int low = 0;
            int high = n-1;
            while(low<=high)
            {
                int mid = high + (low - high)/2;

                if(nums[mid+1]<nums[mid])
                {
                    return nums[mid+1];
                }
                if(nums[mid-1]<nums[mid])
                {
                    return nums[mid-1];
                }
                //check if left side is sorted
                if(nums[mid]>nums[low])
                {
                    //move to right
                    high = mid+1;
                }
                else
                {
                    low = mid-1;
                }

            }
            return low;
        }
    }


