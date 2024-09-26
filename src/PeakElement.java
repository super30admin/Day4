
public class PeakElement {
	
	public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int peak = binarySearch(nums, low,high);
        return peak;
    }
    public int binarySearch(int[] nums, int low, int high){
        int mid = (low+high)/2;
        if( (mid == 0 || nums[mid-1] <= nums[mid]) && (mid == nums.length-1 || nums[mid] >= nums[mid+1])){
            return mid;
        }
        if(mid > 0 && nums[mid-1] > nums[mid]){
            return binarySearch(nums, low, mid-1);
        }else{
            return binarySearch(nums, mid+1, high);
        }
    }

	public static void main(String[] args) {
		PeakElement myObj = new PeakElement();
		int[] arr = {1,2,1,3,5,6,4};
		System.out.println(myObj.findPeakElement(arr));
	}

}
