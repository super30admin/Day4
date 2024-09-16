// Time complexity o(logn).
// Space complexity 0(1).
// runned on leetcode.

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
		
		int l=0;
		int h = nums.length-1;
		
		while(l<h) {
			int mid = l+(h-l)/2;
			
			if(nums[mid]>nums[h]) {
				l = mid +1;
			}
			else {
				 h = mid;
			}
			
		}
		return nums[l];
			
	} 
public static void main (String[] args) {
	    Solution s1 = new Solution();
	    int nums[] ={1,2,3,1};
	    int result = s1.findMin(nums);
		System.out.println(result);
	}
}