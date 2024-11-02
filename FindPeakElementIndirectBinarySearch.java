/*
Time Complexity: O(log n)
Space Complexity: O(1)

In this code, the binary search loop condition while (low < high) ensures that the loop terminates as soon as low and high converge
to a single index, where the peak element exists. The reason low <= high causes a Time Limit Exceeded (TLE) error is because it
creates an infinite loop. Let's go over why that happens.

Explanation:
With low < high:
This condition terminates the loop as soon as low equals high.
At that point, low (or high, since they are the same) points to the peak element, and the loop breaks.
With low <= high:
If we change the condition to low <= high, the loop might never terminate.
In each iteration, either low is set to mid + 1 or high is set to mid.
When low equals high, both low and high will point to the same index, which is the peak element.
However, the condition low <= high allows the loop to continue even when low == high.
Inside the loop, mid is calculated as low + (high - low) / 2, which will also be low (or high since they’re the same).
This results in an infinite loop because neither low nor high changes anymore.
Solution:
To avoid this issue and allow the loop to terminate correctly, we keep the condition as low < high. This way, the loop will stop once
low and high point to the same element, which is the peak. After the loop ends, we can return low or high (they’re the same at this point),
which is the index of the peak element.
*/
class FindPeakElementIndirectBinarySearch {
    public int findPeakElement(int[] nums) {

        int n = nums.length;
        int low = 0, high = n-1;

        while(low<high)
        {
            int mid = low+(high-low)/2;

            //We will not be checking the mid to check if it the peak, we will not be having any base logic
            if(nums[mid]<nums[mid+1])
            {
                low = mid+1;
            }
            else {
                high=mid; //here we are not sure if mid is the peak or not, so we include the element hence high=mid and not mid-1
            }
        }

        return low;
    }
}