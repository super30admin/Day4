// Time Complexity : O(logn).
// Space Complexity : O(n) where n is the size of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I forgot to put the mid!=0 condition and was stuck for a while because of
// that.

class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = (start + end)/2;

            if(mid!=0 && nums[mid]<nums[mid-1]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start-1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,1};
        System.out.println(findPeakElement(nums));
        nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}