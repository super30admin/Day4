// Time Complexity: O(log n)
// Space Complexity: O(1)

/*
This code finds the minimum element in a rotated sorted array using binary search:
- It initializes pointers `l` (start) and `h` (end).
- It iteratively adjusts `l` or `h` based on comparisons between the middle (`mid`) element and the end (`h`) element.
- It returns `nums[l]`, which holds the minimum value once `l` equals `h`, indicating the smallest element in the rotated sorted array.
 */

class Solution {
    public int findMin(int[] nums) {
     
        
        int l = 0;
        int h = nums.length-1;
        
        
        while(l<h)
        {
           
            int mid = l+(h-l)/2;
            if (nums[mid]>nums[h]) {
                l=mid+1;
            }
            else {
                h=mid;
            }
        }
        return nums[l];
    }
}