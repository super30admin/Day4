//time complexity o(logn)
//spacen complexity o(1)
public class FindPeak {

	public static int findPeakElement(int[] nums) {
		
		int low=0;
		int high=nums.length-1;
		
    int peak= findusingbinary(nums,low,high);
    return peak;
	
}
	public static int findusingbinary(int []nums,int low,int high)
	{
		int mid=low+(high-low)/2;
		if((mid+1)<nums.length && (mid-1)>0 && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
		{
			return mid;
		}
		else if(nums[mid]<nums[mid+1])
			findusingbinary(nums, mid+1, high);
		else
			findusingbinary(nums, low, mid-1);
	
	return mid;
	}
	public static void main(String args[])
	{
		int nums[]= {7,8,9,0,1,2,4,5,6};
		System.out.print("max"+findPeakElement(nums));
	}
}
