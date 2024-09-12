import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0)
            return 0;
        return searchMin(nums, 0, nums.length-1);
    }
    
    public int searchMin(int[] nums, int low, int high){
        if(nums[low]<=nums[high])
            return nums[low];
        if(low == high-1)
            return nums[high];
        int mid = (high-low)/2 + low;
        if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1])
            return nums[mid];
        if(nums[mid-1] >= nums[low])
            return searchMin(nums, mid+1, high);
        else
            return searchMin(nums, low, mid-1);
    }
    
    public static void main(String[] args){
        Solution ob = new Solution();
        System.out.println(ob.findMin(new int[]{5,6,7,8,9,1,3}));
    }
}

//Time complexity : O(logN)
//Space complexity : O(1)
