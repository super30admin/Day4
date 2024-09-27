/*******
## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Time Complexity :   O (log n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (162. Find Peak Element)
Any problem you faced while coding this :       No
*******/

class PeakElement {
    public int findPeakElement(int[] nums) { 
        int low = 0;
        int high = nums.length -1;

        // binary search
        while (low < high){
            int mid = low + (high - low) / 2;

            // nums nums[mid+1] < nums[mid], look into left part
            if (nums[mid] > nums[mid+1]){
                high = mid;
            }
            // else look into right part
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String args[]) 
    { 
        PeakElement obj = new PeakElement();
        int[] nums = {2,4,6,6,6,8,9};
        System.out.println("Peak Element Index: " + obj.findPeakElement(nums));
    }
}
