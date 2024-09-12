time complexity: O(logn)
space complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0; //initialising start to 0
        int end = nums.length - 1; //end to last element
        while (start < end) { //while start is less than end
            int middle = start + (end - start) / 2; //initialising mid
            if (nums[middle] > nums[middle + 1]) end = middle; //if mid element is greater than next element, then move end to middle
            else start = middle + 1; //else move start to middle+1
        }
        
        return start; //return start index
    }
}