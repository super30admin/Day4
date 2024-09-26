// Time Complexity :0(logn)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nothing wrote all edge cases before in rough hand.


// Your code here along with comments explaining your approach:- neighbour means checking side by sideby elements,for that checking middle and iterating l, h accordingly.
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int findPeakElement(int[] nums) {
       int l=0;
       int h=nums.length-1;
        while(l<=h){
            int middle=l+(h-l)/2;
            if((l==middle)&&(middle==h)){
                return l;
            }
            else if(l==middle){
                if(nums[l]>nums[h]){
                    return l;
                }
                else{
                    return h;
                }
            }
            if((nums[middle]>nums[middle-1])&&(nums[middle]>nums[middle+1])){
                return middle;
            }
            else if(nums[middle]<nums[middle+1]){
                l=middle+1;
            }
           else{
            h=middle-1;
        }
   }
    return -1;}
}
