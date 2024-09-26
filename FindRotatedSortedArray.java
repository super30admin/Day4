package com.hashmap;

public class FindRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {4,5,6,7,0,1,2};
        FindRotatedSortedArray obj = new FindRotatedSortedArray();
        System.out.println("Minimum in rotated sorted array="+obj.findMin(nums));

	}

	
	public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int mid = 0;
        int left = 0;
        int right = nums.length-1;
        while(left<right)
        {
            mid = left + (right-left)/2;
            if(mid>0 && nums[mid]<nums[mid-1]) return nums[mid];
            else if(nums[mid]>nums[left] && nums[mid]>nums[right])
            {
                left = mid + 1;
            }
            else right = mid -1;
        }
        if(left<nums.length-1 && nums[left]>nums[left+1]) return nums[left+1];
        return nums[left];  
    }
}
