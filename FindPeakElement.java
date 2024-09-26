package com.BinarySearch2;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int left =0;
        int right = nums.length-1;

        while(left < right){
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] < nums[midpoint+1]){
                left = midpoint + 1;
            }else{
                right = midpoint;
            }
        }

        return left;


    }

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement ();

        int[] nums = new int[]{1,2,3,1};

        System.out.println (sol.findPeakElement (nums));
    }



}

