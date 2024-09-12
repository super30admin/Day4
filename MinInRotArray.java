// Time Complexity : O(logn).
// Space Complexity : O(n) where n is the size of array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was getting some weird errors but made a couple of changes and it
// started to run again.

class MinInRotArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if(nums.length==1){
            return nums[0];
        }
        if(nums[end]>nums[0]){
            return nums[0];
        }
        while(start<=end){
            int mid = (start+end)/2;
            //if(mid==0 || mid==end) return nums[mid];
            //if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]) return nums[mid];
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            else{
                if(nums[mid]>nums[0]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String [] args){
        int [] nums = new int[]{3,4,5,1,2};
        System.out.println(findMin(nums));
        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}