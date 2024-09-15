// Time Complexity : O(1) to check if left and right of mid are greater than it. After every stage, search space reduces  by half so - O(logn) 
// Space Complexity : O(n) - size of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

class FindPeak {  
    public int findPeakElement(int[] nums) {  //set low to 0, high to last index of the array
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){ 
        int mid = low + (high - low) / 2;   //Formula to calculate mid avoiding integer overflow 
        if((mid == high || nums[mid] > nums[mid + 1]) && (mid==0 || nums[mid] > nums[mid -1]))
        { //Check if mid is the peak element. Return index of mid if true
            return mid;
        }
        else if(mid > 0 && nums[mid] < nums[mid - 1])
        { //if left of mid is greater than mid, then move left by setting high to mid - 1
            high = mid - 1;
        }
            else{ //if right of mid is greater than mid, then move right by setting low to mid + 1 
                low = mid + 1;
            }
        }
    return -1;  //return if no peak found
    }

}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    FindPeak obj = new FindPeak();
    int[] input_array = {1,2,1,3,5,6,4};  //Sample input array rotated
    System.out.println("One of the peak elements in the array is - " + obj.findPeakElement(input_array)); // returns index [1 or 5]
    
    }
}