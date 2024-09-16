// Time complexity : O(log n)
// Space complexity : O(1)
class FindPeakElementSolution 
{
public int findPeakElement(int[] nums)
{
int start =0, end= nums.length-1;
while(end>=start)
{
int mid = (start+end)/2;
if((mid==0||nums[mid-1]<=nums[mid])&&(mid==(nums.length-1)||nums[mid]>nums[mid+1])) 
    return mid;
if(mid>0&&nums[mid]>=nums[mid+1])
    end = mid-1;
else
    start = mid+1;
}
return -1;
}
}
