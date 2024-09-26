package com.hashmap;

public class FindPeakElement {


	
	public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int start = 0;
        int end = nums.length-1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if((mid+1)<nums.length && nums[mid]<nums[mid+1]) start = mid + 1; //(mid+1)<nums.length ; if we dont use this, we will get an error in case input is [1,2,3].
            else if((mid+1)==nums.length) return mid;
            else end = mid - 1;
        }
        return start; 
    }
public static void main(String[] args)
{   FindPeakElement obj = new FindPeakElement();
    int[] nums = {1,2,3,2,1};
    System.out.println("peak element = "+ obj.findPeakElement(nums));

}

}
