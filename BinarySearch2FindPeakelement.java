// In this problem our aim is to find the peak element present in an array i.e; a element in the array which is greater than the elements present adjacent to it.
// Implemented using optimised recursion method
// Time Complexity: O(log n)

class Solution{

    public int findPeakElement(int[] nums)
    {
        return bsHelper(nums, 0, nums.length -1);
    }

    // Function to find the peak value in an array
    private int bsHelper(int[] nums, int l, int r)
    {
        //if the left index and the right index are equal then the peak is found return index of peak
        if(l == r)
        {
            return l;
        }

        // finding the mid element 
        int mid = l +(r-l)/2;

        //Check if the value of mid element is greater than the value adjacent to it 
        if (nums[mid] > nums[mid+1])
        {
            //Assign the right element as the mid element and call the function because peak lies on the left side
            return bsHelper(nums, l, mid);
        }

        //If mid value is lesser than the value on its adjacent right
        else
        {
            //Assign the left element as the value at mid+1 index because peak value is on the right portion of the array
            return bsHelper(nums, mid+1, r);
        }

    }
}