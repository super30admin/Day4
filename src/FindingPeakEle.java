/**
 * 162. Find Peak Element
 * Peak element is an element which is greater than its immediate neighbours.
 * Using binary search, check if mid ele is greater than its next neighbour and in that case move the right pointer to the mid to check the previous ele of the mid element
 * Time COmplexity: O(log n)
 * Space COmplexity: O(1)
 */
public class FindingPeakEle {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1])                      //if mid ele is greater than mid+1, then move the right ptr to mid and check if its the peak ele
                    right = mid;
                else                                                //if mid ele is not greater than its next ele, then move the left ptr to mid+1 and check it there.
                    left = mid + 1;
            }
            return left;
        }
}
