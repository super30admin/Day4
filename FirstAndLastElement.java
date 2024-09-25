// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Have a flag to indicate first or last element.
Once found, based on the flag, keep shortening the search space.
 */
class FirstAndLastElement {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length==0) return new int[]{-1,-1};

        int first=binarySearch(nums,target,true);
        int last=binarySearch(nums,target,false);

        return new int[]{first, last};
    }

    private int binarySearch(int[] nums, int target,boolean isFirst){
        int low=0,high=nums.length-1,mid;
        int result=-1;
        while(low<=high){
            mid=low+(high-low)/2;

            if(nums[mid]==target){
                result=mid;
                if(isFirst){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return result;
    }
}