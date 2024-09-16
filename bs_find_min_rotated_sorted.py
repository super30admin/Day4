'''
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Find difficult in implementation


// Your code here along with comments explaining your approach
1. Find rotateIndex 
    - Go to middle , check whether elem in mid is greater than next if so next is pivot
    - else
        - discard left array if it was sorted [ mid is greater than left]
        - discard right array if it was sorted 
2. Return the element from rotateIndex 
'''



class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==1:
            return nums[0]

        rotate_idx=self.find_rotate_index(nums,0,len(nums)-1)
        return nums[rotate_idx]
        
        
    def find_rotate_index(self,nums,left, right):
        if nums[left] < nums[right]:
            return 0

        while left <= right:
            pivot = (left + right) // 2
            if nums[pivot] > nums[pivot + 1]:
                return pivot + 1
            else:
                if nums[pivot] < nums[left]:
                    right = pivot - 1
                else:
                    left = pivot + 1
