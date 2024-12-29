//TimeComplexity : O(log(n))
//SpaceComplexity : O(1)
class FindMinimum {
    public int findMin(int[] nums) {
        int high = nums.length-1;
        int low =0;
        while(low<=high){
            if(nums[low]<nums[high]){
                return nums[low];
            }
            int mid = low+(high-low)/2;
            if((mid == low || nums[mid-1]>nums[mid])&& ((mid==high) ||nums[mid+1]>nums[mid])){
                return nums[mid];
            }else if(nums[low]<=nums[mid]){
                low = mid+1;
            }else
                high= mid-1;

        }
        return 57628;
    }
}