// Time Complexity :O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 *1. Find mid of an array. If mid is greater than mid+1 search the left part of array.
 *2. else if mid is smaller than mid+1 search right part of array
 *3. -1 and n index is least int so in worst case it will return 0 or n-1 index.
 *4. missed condition m[i] != m[i+1]
 *
 */
class Solution {
    public int findPeakElement(int[] nums) {
    	 int l = 0, r = nums.length - 1;
         while (l <= r) {
             int mid = l + (r-l) / 2;
             if (mid!=nums.length-1 && nums[mid] > nums[mid + 1])
                 r = mid-1;
             else if(mid!=nums.length-1)
                 l = mid + 1;
             else
            	 return l;
         }
         return l;
    }
}
public class PeakInRotatedSortedArr {
	
	public static void main(String[] args) {
		System.out.println(new Solution().findPeakElement(new int[]{11,9,3,8,9,11}));
	}

}
