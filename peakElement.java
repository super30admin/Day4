//Time complexity : O(logn)
//Space complexity : O(1)
//Did it run on leet code : Yes

public class peakElement {
    class Solution {
        public int findPeakElement(int[] nums) {
    
            int low=0;
            int high = nums.length-1;
            while(low < high){
                int mid = (low+high) /2;
                //if the mid is greater than mid+1 
                //Assign high as mid
                //else increase low 
                if(nums[mid]>nums[mid+1]){
                   high = mid;
                }
                else {
                    low = mid +1;
                }
            }
            return low;
        }
    }
    
}