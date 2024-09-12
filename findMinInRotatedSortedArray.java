//time complexity : O(logn) as we are employing binary search
//Space Complexity : O(1) // i guess
//executed on leetcode : yes
//issues faced :  many cases failed, i had to react to each case and then modify the code after line 23.intially i was returning nums[left]
//cases which failed previosuly : [2,1] , [1,2] and [2,3,1].

// ** CONFUSION: In which cases, do we use while(left<right) and while(left<=right) in binary search.

/** Approach:
 * 1. we use binary search, find the mid point, line 26 states that if we find a[mid] which is less than previous element, we have found the pivot element(minimum element); mid>0 , if this is not given, condition will give error as a[-1] would be accessed
 * 2. if mid element is greater than the a[left] and if it is greater than a[right]; it means that array from a[left] to a[mid] is sorted. so we need not find min element here. so we make left = mid+1 and continue our search on the right side of mid.
 * 3. if the above condition fails, we search on the left side of mid.
 * 4.in case, where left==right, two cases arise: case 2: where left is not last element of array, it means that a[left] is the minimum
 * else, we need to check if  nums[left]>nums[left+1], if yes, element at left+1 is the min element.
 */



class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int mid = 0;
        int left = 0;
        int right = nums.length-1;
        while(left<right)
        {
            mid = left + (right-left)/2;
            if(mid>0 && nums[mid]<nums[mid-1]) return nums[mid];
            else if(nums[mid]>nums[left] && nums[mid]>nums[right])
            {
                left = mid + 1;
            }
            else right = mid -1;
        }
        if(left<nums.length-1 && nums[left]>nums[left+1]) return nums[left+1];
        return nums[left];  
    }
    public static void main(String[] args)
    {
        int[] nums = {4,5,6,7,0,1,2};
        Solution obj = new Solution();
        System.out.println("Minimum in rotated sorted array="+obj.findMin(nums));
    }
}