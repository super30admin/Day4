public class findMinimum {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
    public static void main(String[] args){
        int [] arr = {4,5,6,7,1,2};
        findMinimum f = new findMinimum();
        f.findMin(arr);
    }
}
