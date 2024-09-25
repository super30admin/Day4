/*
 * Time complexity - O(log(N)) where n is the  number of elements in the array 
 * Space Complexity  - O(1) no extra space used in this algortithm
 * Ran on leetcode - yes
 */

/*
 * Brute force - 1 
 * class Solution {
    public int findPeakElement(int[] nums) {
        // brute force
        int maxi = Integer.MIN_VALUE;
        int idx = 0; 
        for (int i = 0 ; i < nums.length; i++){
           if (nums[i]  > maxi){
               maxi = nums[i];
               idx = i ;
           }
        }
        return idx;
    }
}
 
Brute force - 2 
class Solution {
    public int findPeakElement(int[] nums) {
        // brute force
        // check only right elemnt as that the necesarry and sufficient condition
        for (int i = 0; i <nums.length-1; i++){
            if ( nums[i]  > nums[i+1]){
                return i;
            }
        }
        return nums.length-1;
    }
}
*/

class Solution {
    public int findPeakElement(int[] nums) {
     
        int lo = 0 ; 
        int hi = nums.length- 1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
           if (nums[mid+1] > nums[mid]){
               // move to the greater side of element 
               lo = mid+1;
           } else {
               // mid can be at the first element of the array in this case, assigning hi to mid-1 would be out of bounds 
               hi  = mid;
           }
        }
        return lo;
    }
}