class Solution {
    public int findPeakElement(int[] nums) {
        //Find the maximum in the element
        // have a canidate and see if the element is greater than all of the left arr
        // Then check if the 
        
        int left =0;
        int right =nums.length -1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if((mid == 0||(nums[mid] > nums[mid-1])) &&  (nums[mid] > nums[mid+1])){
                return mid;
            }
             else if (nums[mid] < nums[mid+1]){
                left = mid+1;
            }
            
            else if( nums[mid] < nums[mid-1]){
                right =mid -1;
            }
            
           
              
        }
        return left;
        
    }
}

//Complexity : O(logN)
