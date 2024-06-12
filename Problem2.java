/*Algorithm:
    1. Get the mid element, check if the element is less than both leftside of its element and the right side of its element. If yes return the nums[mid]. In case of already sorted array we return the first element.
    2. If leftside of the mid element is the sorted then we move to the rightside of the array from mid.
    3. If the rightside of the mid element is sorted then we move to the leftside of the array from mid.
    
    Time Complexity: O(logn)
    Space Complexity: O(1)
    
    Did the code run successfully on leetcode? Yes

*/

class Solution {
    public int findMin(int[] nums) {
        
        int high = nums.length-1;
        int low = 0;
        while(low<=high){
            if(nums[low]<=nums[high])
                return nums[low];
            
            int mid = low +(high-low)/2;
            if((low==mid || nums[mid-1]>nums[mid]) && (mid==high || nums[mid+1]>nums[mid]))
                return nums[mid];
            else if(nums[low]<=nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        
        return -1;
        
    }
}