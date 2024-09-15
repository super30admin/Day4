// Time Complexity : Binary Search - O(logn). Once binary search is done, check if left and right of the nums[mid] found are equal to nums[mid], if ys, update low or high values and repeat. Everytime, search space reduces by logn, So Asymtotically, the Time complexity is logn.
// Space Complexity : O(n) - size of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class FirstLastIndex { 
    private int first_pos(int[] nums, int target, int low, int high)
    { //Helper method to find the first/left most index of the target element. 
        while(low <= high)
        { //while condition for any binary search algo
            int mid = low + (high - low) / 2;  //formula avoiding integer overflow.
            if(nums[mid] == target)
            { //if target found then check if left of target/mid element is also equal to target.
                if(mid == 0 || nums[mid] > nums[mid - 1])
                { //If not, this is the leftmost index of target and return the answer
                    return mid;   
                }
                else{ //element at nums[mid -1] is equal to nums[mid], Ergo, decrement high and repeat the process again.
                    high = mid -1 ;
                }                    
                }
            else if(nums[mid] < target)
            { // reduce search space if target is not mid element and greater than mid element
                low = mid + 1;
            }
            else{  // reduce search space if target is not mid element and lesser than mid element
                high = mid - 1;
            }
            }
        return -1; //return -1 if target does not exist in the array
        }

  private int last_pos(int[] nums, int target, int low, int high)
    { //Helper method to find the last/right most index of the target element. 
        while(low <= high)
        {//while condition for any binary search algo
            int mid = low + (high - low) / 2; //formula avoiding integer overflow.
            if(nums[mid] == target)
            { //if target found then check if left of target/mid element is also equal to target.
                if(mid == high || nums[mid] < nums[mid + 1])
                { //If not, this is the rightmost index of target and return the answer
                    return mid;
                }
                else{ //element at nums[mid + 1] is equal to nums[mid]. Ergo, increment low and repeat the process again.
                    low = mid + 1 ;
                }                    
                }
            else if(nums[mid] < target)
            { // reduce search space if target is not mid element and greater than mid element
                low = mid + 1;
            }
            else{ // reduce search space if target is not mid element and lesser than mid element
                high = mid - 1;
            }
            }
        return -1; //return -1 if target does not exist in the array
        }  

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1}; //if array is empty or null, nothing to search for.
        int low = 0; //initial low  
        int high = nums.length - 1;  //initial high
        int first = first_pos(nums, target, low, high); //retrieves the leftmost index of target element.
        int last = last_pos(nums, target, low, high);  //retrieves the rightmost index of target element.
        int[] result = {first, last};    
        return new int[] {first, last};    //return the leftmost and rightmost index as an array 
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    FirstLastIndex obj = new FirstLastIndex();
    int[] input_array = {5,7,7,8,8,10};  //Sample input array rotated
    int target = 8;
    int[] result = obj.searchRange(input_array, target);
    System.out.println(target + " is present in the input array at start and end indexes - "); // returns [3,4]
    for(int i = 0; i < result.length; i++)
    {
        System.out.println(result[i]); // returns [3,4]
    }
    target = 6;
    result = obj.searchRange(input_array, target);
    System.out.println(target + " is present in the input array at start and end indexes - "); // returns [3,4]
    for(int i = 0; i < result.length; i++)
    {
        System.out.println(result[i]); // returns [-1,-1]
    }
    }
}
