
public class FirstLastRSortedArray {
	
	public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        if(nums.length == 0 || nums == null){
            return new int[]{-1,-1};
        }
        int left = binarySearchLeft(nums, low, high, target);
        int right = binarySearchRight(nums, low, high, target);
        
        return new int[]{left,right};
    }
    
    public int binarySearchLeft(int[] nums, int low, int high, int target){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(nums[mid] > target){
            return binarySearchLeft(nums, low, mid-1, target);
        }else if(nums[mid] < target){
            return binarySearchLeft(nums, mid+1, high,target);
        }else{
            if(mid == 0 || nums[mid] > nums[mid-1]){
                return mid;
            }else{
                return binarySearchLeft(nums, low, mid-1,target);
            }
        }
    }
    
    public int binarySearchRight(int[] nums, int low, int high, int target){
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(nums[mid] > target){
            return binarySearchRight(nums, low, mid-1,target);
        }else if(nums[mid] < target){
            return binarySearchRight(nums, mid+1,high,target);
        }else{
            if(mid == nums.length -1 || nums[mid] < nums[mid+1]){
                return mid;
            }else{
                return binarySearchRight(nums,mid+1, high,target);
            }
        }
    }

	public static void main(String[] args) {
		FirstLastRSortedArray myObj = new FirstLastRSortedArray();
		int[] arr = {5,7,7,8,8,10};
		int[] res = myObj.searchRange(arr, 8);
		for(int temp:res) {
			System.out.println(temp);
		}
	}

}
