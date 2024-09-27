// Time Complexity : push: O(1), pop: O(1), peek: O(1) Amortized  
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
/* 
1. We are maintaining an in Stack and an out  stack 
2. We keep pushing the elements the elements in the in stack until a pop happens
3. now, we have all elements arranged in FIFO manner in out queue
4. so we can pop until the out stack becomes empty that will give us top of a queue
5. meanwhile we can keep pushing elements in the in stack
6. if the out queue is empty we need to again transfer all the elements
*/




public class FindMinimum {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high])
                return nums[low];
            int middle = low + (high - low) / 2;
            if (middle > 0 && nums[middle - 1] > nums[middle])
                return nums[middle];
            else if (nums[middle] <= nums[high]) {
                high = middle - 1;
            } else
                low = middle + 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        FindMinimum binarySearch=new FindMinimum();
        System.out.println(binarySearch.findMin(nums));
    }
}
