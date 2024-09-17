
public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6,4};
		int ans = peakElement(nums);
		System.out.println(ans);
	}
	public static int peakElement(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return -1;
        }
        
        int low = 0, high = nums.length -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid-1 < 0 || nums[mid] > nums[mid-1]) && (mid +1 >= nums.length || nums[mid] > nums[mid+1])){
                return mid;
            }
            if(nums[mid+1] > nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
       return -1; 
    }


}
