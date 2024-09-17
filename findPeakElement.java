//Time : O(n)
//space: O(1)
//leetcode : yes
class Solution {
    linear search
     public int findPeakElement(int[] nums) {
         //simply search the next element is lesser than current element, if found return index 
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
         //else return last element
        return nums.length - 1;
    }
}
