/*
Time Complexity:
The time complexity is O(logn), where n is the number of elements in the nums array.
This complexity comes from the binary search approach used to find the minimum element. Each iteration divides the search space by half,
so the number of comparisons required is logarithmic with respect to the size of the array.

Space Complexity:
The space complexity is O(1).
The algorithm only uses a fixed amount of extra space (for the variables len, low, high, and mid), regardless of the input size.
There are no data structures like arrays or lists being used to store intermediate results, so the space complexity remains constant.

Property of a rotated sorted array is the minimum element would always lie in the unsorted part of the array

In a rotated sorted array, there is a portion that seems "unsorted" because of the rotation. The minimum
element will always lie in this "unsorted" part, where the rotation caused a break in the usual order.
This is what makes it possible to identify the minimum element as the point where the rotation occurred.
 */
class FindMinRotatedSortedArray {
    public int findMin(int[] nums) {

        int len = nums.length;
        int low = 0, high = len - 1;

        while(low<=high)
        {
            //We can check if the array is already sorted, which means low will point to minimum element
            // if(nums[low]<=nums[high])
            //     return nums[low];

            int mid = low+(high-low)/2;

            //Checking edge case, if mid is the min element, eg: 7,0,1 so elements on both sides will be greater than mid
            if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == len-1 || nums[mid+1] > nums[mid]))
                return nums[mid];

            /*
            If we don't want to check initially if the array is already sorted or not, which means start of the array has the min element, then in such case
            we need to start with checking if the array is right sorted and then eliminate the right part and then move to check if it is a left sorted array or not.
            Or if we still want to start eliminating the left sorted array first, and check the right part of array for min element. Then we need to, check the initial
            steps if the array is already sorted or not
            */

            else if(nums[mid] <= nums[high]) //right sorted array
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }

        }

        return -1;
    }
}