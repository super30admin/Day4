/*
Time Complexity:
The time complexity of this algorithm is O(log n), where n is the number of elements in the nums array.
In each iteration, binary search halves the search space by adjusting either low or high, depending on whether the peak might lie on the left or the right side of mid.
Halving the search space repeatedly leads to a logarithmic time complexity, O(log n).

Space Complexity:
The space complexity of this algorithm is O(1) (constant space).
It uses only a fixed amount of extra space for the variables low, high, and mid.
No additional data structures or recursive calls are used, so the space used by the algorithm does not increase with the size of the input array nums.

nums[i] != nums[i + 1] for all valid i.
Elements can be repeated, but it is not consecutive and an array is not sorted.
eg: -INFINITY [1,2,1,3,5,6,4] -INFINITY => correct input
    -INFINITY [1,1,2,3,5,6,4] -INFINITY => incorrect input

Peak element => element greater than both its neighbors.

For edge elements, don't compare with right member if it is the last element and don't compare
it with left member if it is the first element
 */
class FindPeakElement {
    public int findPeakElement(int[] nums) {

        int n = nums.length;
        int low = 0, high = n-1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            /*
                If mid id the peak,it is greater than adjacent elements, we will not use >= because we cannot have same consecutive elements
                No need to check mid if it is the corner element.
            */
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid==n-1 || nums[mid] > nums[mid+1]))
                return mid;

            else if(mid>0 && nums[mid]<nums[mid-1]) //check if we have a greater slope on left path
            {
                high=mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return -1;
    }
}