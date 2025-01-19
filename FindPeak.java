
public class FindPeak {
    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1)
            return 0;

        int n = nums.length;
        int low = 1;
        int high = nums.length-2;

        if(nums[0]>nums[1])
            return 0;   //Check if first element is peak

        if(nums[n-1]>nums[n-2]) //check if last element is peak
            return n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] > nums[mid-1] && nums[mid]>nums[mid+1])  //Found Peak
                return mid;

            //Adjust search space in the direction of potential peak
            if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
