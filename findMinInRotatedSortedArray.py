# Time Complexity : O(lgN)
# Space Complexity : O(1).. didn't use extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No. Just had to figure out 
# the logic (rotated array type question) which was discussed in previous class. Took awhile but 
# I got it after drawing out a few examples.

# Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        """
        an array sorted in ascending order... Not duplicates
        Spitballing initial thoughts before starting: 
            - brute force is O(N) iterate through the nums array one and find the min value.. (linear search)
            - Can use binarySearch for O(logN) time.. 
        since its rotated.. we can use the trick to search in the sorted array
        In rotated... the min element is the min if the element before it is greater. 
        Can keep going until two values left..?
        """
        if not nums:
            return -1 
        
        left = 0 
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if nums[mid] < nums[right]: #right side is sorted..check left side
                if left == mid:
                    return nums[mid]
                right = mid
            elif nums[mid] > nums[left]: #left is sorted..check right side
                if right == mid:
                    return nums[mid]
                left = mid 
            else:
                return min(nums[left], nums[right])
            
            