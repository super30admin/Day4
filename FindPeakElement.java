// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
/*Approach
*divided the array into two parts and with respect to middle we will check which neighbour is greater 
* then we will move to that side and thenw we will continue this
*it will stop at a point where both the left and right pointers are passing to same value which will be the peak
because the neighbours will be smaller than that
 */

public class FindPeakElement{
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        int left = 0;
        int right = nums.length -1 ;
        while(left < right)
        {
            int mid = left+(right - left)/2;
            if(nums[mid] < nums[mid+1])
            {
                left = mid + 1;
            }
            
            else
            {
                right = mid ;
            }
        }
        
        
        return left;
    }
public static void main(String args[]){
    FindPeakElement obj = new FindPeakElement();
    int position = obj.findPeakElement(new int[]{1,2,1,3,2,1,1});// there can be multiple peaks
    System.out.println("The peak element is in position : " + position);
}
}