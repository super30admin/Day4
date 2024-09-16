/*
LeetCode Submitted = No passing (38/59) test cases (Some Bug is there and not spent much time on it; will try after class again)
Time complexity = O(logN)
Space complexity = O(1) */
/* The approach I used is assuming the middle of the array is peak and then recursively call the left part of the array and right part of the array to see the peak still valid otherwise update peak with another value
*/
class Solution {
    public int peakElements(int[] nums,int l,int r){
        int mid  = (l + (r - l)/2);
        //Base case
        if(l > r)
            return -1;
        
        if(l == r)
            return l;
       
        if(nums[mid] >= nums[l] && nums[mid] >= nums[r]){
            int peak_value = mid;
            if(mid == (l + 1) && mid == (r + 1))
                return mid;
            
            int leftCheck  = peakElements(nums,l+1,mid);
            int rightCheck = peakElements(nums,mid,r-1);
            if(leftCheck != -1 || rightCheck != -1){
                peak_value = Math.max(leftCheck,rightCheck);
            }
            
            return peak_value;
            }
                
        
       if(nums[mid]<nums[l] && nums[mid]<nums[r]){
            r = l + 1;
        }else{
            if(nums[mid]>=nums[l])
                l = l + 1;
        
            if(nums[mid]>=nums[r])
                r = r - 1;
           
       }
        return(peakElements(nums,l,r));
    }
    
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <1)
            return -1;
        if(nums.length == 1)
            return 0;
        else{
            return peakElements(nums,0,nums.length - 1);
        }
    }
}
