class Solution {
    public int[] searchRange(int[] nums, int target) {
    int first = -1, last = -1;
    int[] ans = new int[2];
    int n = nums.length;

    for (int i = 0; i < n; i ++) {
        if (nums[i] == target) {
            if (first == -1) first = i;
            last = i;
        }
    }

    ans[0] = first;
    ans[1] = last;
    return ans;
    }
}

// Time Complexity :    O(n)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    None

/* Your code here along with comments explaining your approach in three sentences only - Will initise first and last variable to -1 and traverse the array to check if we have our target. 
    Once the target is met we store its index in both first and last variable and keep searching and updating the last variable with indexes.
*/
