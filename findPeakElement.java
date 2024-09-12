//time complexity : O(logn)
// space complexity : O(1)
//executed on leetcode: yes
// issues faced :
/**approach : we implement binary search and if the nums[mid]<nums[mid+1], it means that we are still climbing the hill, so we shift the start pointer to the right of mid.
 * in else case, if we are descending the hill, we shift the end to mid-1;
 * if mid reached the end, it means there is no descent in the hill and end element itself is the peak.
 **/ 
class Solution1 {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int start = 0;
        int end = nums.length-1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if((mid+1)<nums.length && nums[mid]<nums[mid+1]) start = mid + 1; //(mid+1)<nums.length ; if we dont use this, we will get an error in case input is [1,2,3].
            else if((mid+1)==nums.length) return mid;
            else end = mid - 1;
        }
        return start; 
    }
public static void main(String[] args)
{   Solution1 obj = new Solution1();
    int[] nums = {1,2,3,2,1};
    System.out.println("peak element = "+ obj.findPeakElement(nums));

}
}