// Time Complexity :findMin: O(log n) , in Binary search we're eliminating the half of the input
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing
public class FindMinInRotatedSortedArray {

        public int findMin(int[] nums) {
            int low = 0; int high =nums.length-1;

            while(low<=high){
                //base case
                if(nums[low]<=nums[high]){
                    return nums[low];
                }
                int mid = low+(high-low)/2;
                if((mid==0|| nums[mid-1]>nums[mid]) && (mid==nums.length-1 || nums[mid+1]>nums[mid])){
                    return nums[mid];
                }else if(nums[mid]<=nums[high]){ //check for right sorted array and if its sorted start binary serach on left
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            return 0;

        }

    public static void main(String args[]) {
        FindMinInRotatedSortedArray array = new FindMinInRotatedSortedArray();
        int[] nums = new int[8];
        nums[0]=4;
        nums[1]=5;
        nums[2]=6;
        nums[3]=7;
        nums[4]=8;
        nums[5]=9;
        nums[6]=2;
        nums[7]=3;


        System.out.println("index of the target is " +array.findMin(nums));

    }
}
