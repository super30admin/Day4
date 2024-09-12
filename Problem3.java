// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes, while reassigning values to low and high.


//Approach
/*
Elements till the paek will be in sorted ascending order. 
Do Binary search till pointer low< pointer high(Not considering equal to since we are comparing one element in the array with its consecutive element and it might lead to out of bounds exception)
If mid element is greater than mid+1 element, then we have we might have our peak element. Assign high to mid to check if theelement is less than
mid-1. Else assign low to mid+1.
when low equals high, search is stopped and low is at peak value.
Return low.
*/



class Problem3 {
    public int findPeakElement(int[] nums) {
        
        int low =0;
        int high = nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]>nums[mid+1]){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        
        return low;
        
    }
}


class Main{
    public static void main(String args[]){
        Problem3 p = new Problem3();
        int[] nums = {1,4,3,2,1}; 
        System.out.println(p.findPeakElement(nums));
    }
}