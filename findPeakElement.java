public class findPeakElement {

    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if( (mid == 0 || nums[mid] > nums[mid -1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid+1])){
                return mid;
            }else if(mid!=0 && nums[mid] < nums[mid-1]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println("peak element is  : " + findPeakElement(new int[]{1,2,3,1}));
        System.out.println("peak element is  : " + findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }

}
