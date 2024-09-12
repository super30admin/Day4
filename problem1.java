// TC: O(log n)
// SC: O(1)
// Leetcode run: Yes




/* I will try to explain it more simply. What we are essentially doing is going in the direction of the rising slope(by choosing the element which is greater than current). How does that guarantee the result? Think about it, there are 2 possibilities.a) rising slope has to keep rising till end of the array b) rising slope will encounter a lesser element and go down.
In both scenarios, we will have an answer. In a) the answer is the end element because we take the boundary as -INFINITY b) the answer is the largest element before the slope falls..*/



class Solution {
  public int findPeakElement(int[] nums) {
    int n = nums.length - 1;
    if(n==0)
      return 0;
    if(nums[0] > nums[1])
      return 0;
    if(nums[n] > nums[n-1])
      return n;
    int start = 1, end = n-1;
    while(start <= end) {
      int mid = start + (end - start)/2;
      if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
        return mid;
      else if(nums[mid] < nums[mid+1])
        start = mid + 1;
      else
        end = mid - 1;
    }
    return -1;
  }
}