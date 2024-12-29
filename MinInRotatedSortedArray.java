//TC: O(log n)
//SC: no extra space, O(n) just for the array
//approach: one side of mid will always be sorted in rotated sorted array,
// if mid is not the min, check which side is sorted, and can minimum lie there, if not go to other side

public class MinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int n=nums.length;
        if(n ==1) return nums[0];
        int low=0; int high =n-1;
        while(low<=high){
            if(nums[low]<=nums[high]) return nums[low];
            int mid = low+ (high-low)/2;
            if((mid == low || nums[mid] < nums[mid-1])
                    && (mid == high || nums[mid] < nums[mid+1] )){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]){
                low = mid+1;
            }else high = mid-1;
        }
        return -1;
    }

}
