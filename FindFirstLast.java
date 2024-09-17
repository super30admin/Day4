//time compleity o(n)
//space compexity o(1)
public class FindFirstLast {
	
	 public int[] searchRange(int[] nums, int target) {
		 
		 int first=findfirst(nums,target,0,nums.length);
		int last= findlast(nums,target,0,nums.length);
		 int a[]=new int[2];
		 a[0]=first;
		 a[1]=last;
		 
		 return a;
	 }

	 public int findfirst(int nums[],int target,int low,int high) {
		 
		 int mid=low+(high-low)/2;
		 if(nums[mid]==target && nums[mid-1]<target)
		 {
			 return mid;
		 }
		 else if(nums[mid]>target)
		 {
			 findfirst(nums,target,low,mid-1);
		 }
		 else
		 {
			 findfirst(nums,target,mid+1,high);
		 }
		 return -1;
		 
	 }
	 public int findlast(int nums[],int target,int low,int high) {
		 
		 int mid=low+(high-low)/2;
		 if(nums[mid]==target && nums[mid+1]>target)
		 {
			 return mid;
		 }
		 else if(nums[mid]>target)
		 {
			 findfirst(nums,target,low,mid-1);
		 }
		 else
		 {
			 findfirst(nums,target,mid+1,high);
		 }
		 return -1;
		 
	 }

	public static void main(String args[])
	{
		
	}

}
