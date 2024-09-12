import java.util.*;
import java.io.*;

class Solution {
    int first = -1;
    int last = -1;
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};
        int first = binarySearchFirst(nums, target, 0, nums.length-1);
        int last = binarySearchLast(nums, target, first, nums.length-1);
        return new int[]{first, last};
    }
    
    public int binarySearchFirst(int[] nums, int target, int low, int high){
        if(nums[low]>target || (low == high && nums[low]!=target))
            return -1;
        int mid = (high-low)/2 + low;
        if(nums[mid] == target && (mid==0 || nums[mid-1] < target))
            return mid;
        if(nums[mid] > target || (nums[mid]==target && nums[mid-1]==target))
            return binarySearchFirst(nums, target, low, mid-1);
        else 
            return binarySearchFirst(nums, target, mid+1, high);
    }
    
    public int binarySearchLast(int[] nums, int target, int low, int high){
        if(low == -1 || nums[high]<target || (low == high && nums[low]!=target))
            return -1;
        int mid = (high-low)/2 + low;
        if(nums[mid] == target && (mid+1 == nums.length || nums[mid+1] > target))
            return mid;
        if(nums[mid] < target || (nums[mid]==target && nums[mid+1]==target))
            return binarySearchLast(nums, target, mid+1, high);
        else 
            return binarySearchLast(nums, target, low, mid-1);
    }
    
	public static void main (String[] args) 
	{
		Solution ob = new Solution();
		int[] ans = ob.searchRange(new int[]{3,3,4,4,4,4,5,7,7,7,8}, 6);
		System.out.println(ans[0]+" "+ans[1]);
		ans = ob.searchRange(new int[]{4,5,8,12,13,13,13,17}, 13);
		System.out.println(ans[0]+" "+ans[1]);
	}
}

//Time complexity = O(logN)
//Space complexity = O(1)


