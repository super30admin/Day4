public class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        if(nums.length==0)
            return -1;
        if(nums.length==1)
            return 0;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(mid==0){
                return nums[mid]>nums[mid+1] ? mid:mid+1;
            }
            if(mid==nums.length-1){
                return nums[mid] >nums[mid-1] ? mid: mid-1;
            }

            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid]>nums[mid-1]){
                low = mid+1;
            }else {
                high =mid-1;
            }

        }
        return -1;
    }
    public static void main(String[] args){
        int [] arr = {1,2,5,8,4,3};
        PeakElement p = new PeakElement();
        p.findPeakElement(arr);
    }
}
