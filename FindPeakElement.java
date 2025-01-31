//Here the idea is that the peak element should be greater than it's adjacent members. 
//To find that, we will travel to the side where the element is greater than the mid element. 
//It gives us more probability to find the peak element.
//Time complexity: O(log n)
//Space complexity: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == nums.length -1 ||nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid]<nums[mid+1]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}