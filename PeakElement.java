// Time Complexity :findPeakElement: log n
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if((mid==0 || nums[mid-1]< nums[mid]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if(mid>0 && nums[mid]<nums[mid-1]){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        PeakElement array = new PeakElement();
        int[] nums = new int[8];
        nums[0]=4;
        nums[1]=5;
        nums[2]=6;
        nums[3]=2;
        nums[4]=8;
        nums[5]=4;
        nums[6]=2;
        nums[7]=3;


        System.out.println("one of the peak element  " +array.findPeakElement(nums));

    }

}
