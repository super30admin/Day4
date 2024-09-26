
public class MinElementRSortedArray {
	
	public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        return search(nums, low, high);
    }
    
    public int search(int[] nums, int low, int high){
        int min = nums[0];
        int mid = (low+high)/2;
        if(low == mid){
            min = nums[mid];
        }
        if(nums[low] > nums[high]){
            if(nums[low] > nums[mid]){
                return search(nums, low, mid);
            }else{
                return search(nums, mid+1,high);
            }
        }else{
            min = nums[low];
        }
        return min;
    }

	public static void main(String[] args) {
		MinElementRSortedArray myObj = new MinElementRSortedArray();
		int[] arr = {4,5,6,7,0,1,2};
		System.out.println(myObj.findMin(arr));
	}

}
