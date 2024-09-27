public class findMinimumInRotatedSortArray {
    public static  int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high - low)/2;
            //if mid is minimum
            if( (mid == 0 || nums[mid] < nums[mid -1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println("Minimum : " + findMin(new int[]{3,4,5,1,2}));
        System.out.println( "Minimum : " + findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
