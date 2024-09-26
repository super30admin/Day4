// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
/**
 *1. first find element using binary search.
 *2. After finding element check mid is starting index in the array if not check left of mid is same or not.
 *3. If yes continue binary search on left array till you find min index.
 *4. check mid is end index in the array if not check right of mid is same or not.
 *5. If yes continue binary search on right array till you find max index.
 */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1,-1};
        ans[0]= binarySearch(nums, target, 0, nums.length-1, true);
        if(ans[0] >-1) {
        	ans[1] = binarySearch(nums, target, 0, nums.length-1, false);
        }
      return ans;
    }
    
    public int binarySearch(int[] nums, int target,int left,int right,boolean isfirst) {
    	while(left<=right) {
    		int mid = left+(right-left)/2;
    		
    		if(nums[mid]==target) {
    			if(isfirst && mid !=left && nums[mid-1]==target) {
    				right = mid-1;
    			}else if(!isfirst && mid!=right && nums[mid+1]==target) {
    				left = mid+1;
    			}
    			else {
    				return mid;    				
    			}
    		}else if (nums[mid] > target) {
    			right = mid-1;
    		}else {
    			left = mid+1;
    		}
    	}
    	return -1;
    }
    
  
}

public class FirstAndLastPosInArray{
	public static void main(String[] args) {
		int[] arr = new int[] {5,7,7,8,8,10};
		int[] sol = new Solution().searchRange(arr, 8);
		System.out.println(sol[0]+"..."+sol[1]);
	}
}