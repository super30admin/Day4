/*
Time -O(logn)
Space - O(1)
find the abnormality taht previous element is greater than the next element 
if abnorrmality then move high or else move low 


*/

class Solution {
    public int findPeakElement(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int mid;
        while(low<high){
            mid = low +(high-low)/2;
           
            if(nums[mid]>nums[mid+1]){
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        return low;
        
    }
}