//TC: O(log(n))
//SC: O(1)
/* We try to search for min value by search for target. 
*/

class Solution {
    public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    while(l < r) {
        int mid = l + (r - l) / 2;
        if(nums[mid] < nums[r]) {
            //System.out.println("mid element is "+nums[mid]+" right is "+nums[r]);
            r = mid;
        } else {
            //System.out.println("mid element is "+nums[mid]+" right is "+nums[l]);
            l = mid + 1;
        }
    }
    return nums[l];
    }
}
