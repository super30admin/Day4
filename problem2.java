// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
//time complexity:O(log n)
//space complexity:O(1)
//leetcode soluton accepted

class Solution {
    public int findMin(int[] nums) {
        //setting the low and higher bounds
        int left =0;
        int right= nums.length-1;
        //we are not doing left<=right becasue the loop wont break
        //idea is to converge the left and right index to one point in the array and returning the value
        
        while(left<right){
            //finding the middle bound
            int mid = left +(right-left)/2;
            //since there is no target in this we dont have a conditon called target == nums[mid]
            if (nums[mid]>nums[right]){
                //if this condition goes through we know that the minimum value has accourded somewhere on the right side
                left = mid+1;
            }else{
                //we know that the other ocndition  pivot is at mid or less than mid
                //there is a possiblity that the mid index would have hte lowest value so we cant discard right =mid
                //using mid-1 would cause use to discard that value 
                right =mid;
            }
            //after this point the value converges before brekaing the loop
        }
        //we shrink the whole left and right to the possbile minimum value to find  the minimum
        return nums[left];
    }
}