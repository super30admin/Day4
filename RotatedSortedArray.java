// Overall Time Complexity : O log(n) . The n is number of elements in the search space.
// Overall Space Complexity : O(1) . The space complexity of storing the values in variables like low, high uses constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problem involves indentifying the pivot element in such way that it is lesser than the neighbours.
// The pivot element always lies on non-sorted half of the array.
class RotatedSortedArray {
   
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length-1;
            int n = nums.length;
    
            while(low<=high){
    
                if(nums[low]<=nums[high]) return nums[low];
                int mid = low+(high-low)/2;
    
                if((mid==0 || nums[mid]<nums[mid-1]) && (mid==n-1 || nums[mid]<nums[mid+1])){
                    return nums[mid];
                }
                else if(nums[low]<=nums[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            return 232;
    }
    }
    
