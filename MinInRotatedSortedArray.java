/*
Time complexity : O(logN)
space complexity : O(1)
Leetcode execution : successful
Steps:
    1) check for pre-conditons like nums size also if array having single element return that itself.
    2) run binary search, if mid is lessthan it's next value return mid
    3) else if mid+1 element exists and greater than mid return mid+1
*/
class MinInRotatedSortedArray{
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){return -1;}

        int low = 0;
        int high = nums.length-1;

        if(nums.length==1 || nums[0]< nums[nums.length-1]){
            return nums[0];
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid-1>=0 &&nums[mid]<nums[mid-1]){
                return nums[mid];
            }

            if(mid+1 <= nums.length-1 && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[low]<nums[mid]){
                low = mid +1;
            }
            else {
                high = mid -1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        MinInRotatedSortedArray min = new MinInRotatedSortedArray();
        int arr[] = {4,5,6,1,2,3};
        System.out.println(min.findMin(arr));

    }
}