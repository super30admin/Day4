// Time Complexity :O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 *1. one side of the array is sorted always in rotated sorted array
 *2. check is array rotated or now. iff not return first element
 *3. if rotated do binary search and check left and right elements of mid for pivot.
 *4. is left of mid is greater mid element is the least.
 *5. if right of mid is smaller mid+1 is the least. 
 *
 */
class Solution {
    public int findMin(int[] nums) {
        int left =0;
        int right = nums.length-1;
        int mid;
        if(nums[left]<=nums[right]) {
        	return nums[left];
        }
        
    	while(left<=right) {
    		mid = left+(right-left)/2;
    		if(nums[mid]> nums[mid+1]) {
    			return nums[mid+1];
    		}
    		
    		if(nums[mid]< nums[mid-1]) {
    			return nums[mid];
    		}

    		
    		if(nums[mid]>=nums[left] ) {
    			left = mid+1;
    		}else{
    			right = mid-1;
    		}
    		
    	}
    	return -1;
    }
}
public class MinRotatedSortedArr {
	
	public static void main(String[] args) {
		System.out.println(new Solution().findMin(new int[]{3,4,5,1,2}));
	}

}
