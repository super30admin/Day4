// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        low=0
        high=len(nums)-1
        while low <=high:
            mid=low+(high-low)//2
            print(low,high,mid)
            if  (mid==0 or nums[mid]<nums[mid-1] ) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]) : #if nums[mid]>nums[high]
                                                                                                    # we know array is unsorted in the right side
                '''
                    Normal binary search
                '''
                return nums[mid]
            elif nums[high]<nums[mid]: #check only for right side as the array is rotated in right.
                low=mid+1
            else:
                high=mid-1
        return -1