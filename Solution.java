package First_Last_Occurence;

class Solution {
    private static int binarySearchRight(int nums[],int target)
 {
     int low = 0;
     int high = nums.length-1;
     while(low<=high)
     {
         int mid = low + (high-low)/2;
         
         if(nums[mid]==target)
         {
            if(mid == nums.length-1 || nums[mid] < nums [mid + 1])   
            {
                return mid;
            }
               
             else
             {
                 low = mid+1;
             }
         }
         
         else if(nums[mid] > target)
         {
             high = mid-1;
         }
         
         else
         {
             low = mid+1;
         }
     }
     
     return -1;
 }
 
 private static int binarySearchLeft(int nums[], int target)
 {
     int low = 0;
     int high = nums.length-1;
     while(low<=high)
     {
         int mid = low + (high-low)/2;
         
         if(nums[mid]==target)
         {
            if(mid == 0 || nums[mid] > nums [mid - 1])   
            {
                return mid;
            }
             
             else
             {
                 high = mid-1;
             }
         }
         
         else if(nums[mid] > target)
         {
             high = mid-1;
         }
         
         else
         {
             low = mid+1;
         }
     }
     
     return -1;
 }
 
 
static public int[] searchRange(int[] nums, int target) {
     if (nums == null || nums.length ==0 )
     {
         return new int[]{-1,-1}; 
     }
     
     int left = binarySearchLeft(nums,target);
     int right = binarySearchRight(nums, target);
     return new int[] {left, right};
     
     
 }

	public static void main(String[] args) {
		
		int[] nums = {2,3,4,4,5,5,5,6,7,8};
		int[] obj = searchRange(nums,5);
		System.out.println("The index of first and last occurences are : " + obj);
		
		// TODO Auto-generated method stub

	}

}
