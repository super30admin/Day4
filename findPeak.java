// Time Complexity: O(logN)
// Space complexity: O(1)

class findPeak {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            //if peak found at mid return it
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid == (nums.length-1) || nums[mid]>nums[mid+1])){
                return mid;
            } else if(nums[mid]<nums[mid+1]){ // else move to the greater element side
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        findPeak obj = new findPeak();
        int[] testcase = {1,2,1,3,5,6,4};
        int result = obj.findPeakElement(testcase);
        System.out.println(result);
    }
}