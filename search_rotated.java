package Solution;//find minimum in rotated array
public class search_rotated {
	

    public static int findMin(int[] nums) {
        
        if(nums.length == 0 || nums == null)
            return -1;
        
        int left = 0;
        int right = nums.length-1;
        if(nums[0] <= nums[nums.length-1])
            return nums[0];
        
        while(left<=right){
            int mid = left + (right - left)/2;
            if(mid > 0 && nums[mid-1] > nums[mid])
                return nums[mid];
            else if(nums[mid] >= nums[0]){
                left = mid+1;
                
            }
            else right = mid-1;
        }
        return -1;
        
    }
    
    public static void main(String args[]){
    	int[] nums= new int[]{4,5,6,7,8,1,2,3};
    	System.out.println(findMin(nums));
    }

}
