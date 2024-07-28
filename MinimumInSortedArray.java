public class MinimumInSortedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid]<nums[mid-1]) && nums[mid]<nums[mid+1]){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 1000;
    }

    public static void main(String [] args){
        int[] nums = new int[]{4,5,6,1,2,3};
        int result = findMin(nums);
        System.out.println("Mininum element is: " + result);
    }
}
