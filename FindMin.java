// Time Complexity : O(1) to check which side is unsorted. After every stage,move to unsorted side - O(logn) 
// Space Complexity : O(n) - size of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

class FindMin {
    public int findMin(int[] nums) { 
        //check for unsorted side. move high as mid if left is unsorted. Else move low as mid + 1 if right unsorted. In the end return element where low == high
        int low = 0;
        int high = nums.length -1;
        while(low != high)
        {
            int mid = low + (high - low) /2;
            if(nums[mid] < nums[high])
            {
                high = mid; 
            }
            else{
                low = mid + 1; 
            }
        }
    return nums[low];
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    FindMin obj = new FindMin();
    int[] input_array = {3,4,5,1,2};  //Sample input array rotated
    System.out.println("The minimum element in the array is - " + obj.findMin(input_array)); // returns index element 1
    
    }
}