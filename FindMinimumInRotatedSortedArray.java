//Time Complexity: O(log N)

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        
        int start = 0,end = nums.length-1;
        
        while(start<end)
        {
            int mid = start + (end - start)/2;
            
            if(nums[mid]<nums[end])
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return nums[start];
    }

    public static void main(String args[])
    {
        int nums[] = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
    
}
