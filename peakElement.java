//Time Complexity: O(n)
//Space Complexity: O(1)
/* Approach: If the element before mid is greater than mid, then we reduce the search space and assign "h = mid -1", similarly if mid is less than the element after mid, then "l=mid+1". Otherwise, we would be in a case where we would have found the peak leemnt already.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=(h-l)/2+l;
            if(((mid==0)||(nums[mid]>nums[mid-1]))&&((mid==nums.length-1)||(nums[mid]>nums[mid+1]))){
                return mid;
            }
            else if(mid>0&&nums[mid]<nums[mid-1]){
                h=mid-1;
            }
            else if(mid<nums.length-1&&nums[mid]<nums[mid+1]){
                //
                l=mid+1;
            }
        }
        return -1;
    }
}
