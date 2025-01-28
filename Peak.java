// Overall Time Complexity : O log(n) . The n is number of elements in the search space.
// Overall Space Complexity : O(1) . The space complexity of storing the values in variables like low, high uses constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problem involves identifying the peak element i.e. greater than its neighbours.
// The way to find the peak element is to find the slope (move towards higher elements) 

class Peak{
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int n = nums.length;

        while(low<=high){

            int mid = low + (high-low)/2;

            if((mid==0 || nums[mid]> nums[mid-1]) && (mid==n-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid>0 && nums[mid-1]>nums[mid]){
                high = mid -1;
               
            }
            else{
                low = mid+1;
            }

        }
        return 263;
       
    }
}
