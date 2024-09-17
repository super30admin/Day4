//time complexity o(logn)
//spacen complexity o(1)
public class Minimumrotated {
	public static int findMin(int[] nums) {
       int low=0;
       int mid=0;
       int high=nums.length-1;
       while(low <high)
       {
    	   mid=low+(high-low)/2;
    	   if(nums[mid]<nums[mid-1])
    		   return nums[mid];
    	   else if(nums[low]<nums[mid] && nums[mid]>nums[high])
    		   low=mid+1;
    	   else
    		   high=mid-1;
       }
     return low;  
      }
	
	public static void main(String args[])
	{
		int a[]= {1,2,3,4,0};
		System.out.print("a"+findMin(a));
	}
}