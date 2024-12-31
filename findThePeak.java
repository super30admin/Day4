// Time Complexity: O(log n)
// Space Complexity: O(1)


public class findThePeak {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,3,1 })); // 2
        System.out.println(findPeakElement(new int[] { 1,2,1,3,5,6,4 })); // 5
    }
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low) / 2;
            //check for the peak
            if((mid ==0 || nums[mid]>nums[mid-1])&& (mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            if (nums[mid+1]>nums[mid]){
                low = mid+1;
            }
            else high = mid-1;
        }
        return -1;
    }
}
