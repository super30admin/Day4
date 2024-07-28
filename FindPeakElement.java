public class FindPeakElement {
    public static int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == 0){
                return mid;
            }
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid > 0 && nums[mid-1]>nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1 ;
            }
        }
        return 1000;
    }

    public static void main (String[] args){
        int[] array = new int[]{1,2,5,6,7,8};
        int result = findPeakElement(array);
        System.out.println("Peak ELement is: " + result);
    }
}
