'''
Since the list is sorted, to get the first and last indexes of the target
I used two loops, one starts from 0 and other from last index. Loops stops
on first encounter of the target.
I have used flag variables to keep track of the existence of target in the sorted list.
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
'''


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        ans = []
        flag1 = flag2 = 0
        for i in range(len(nums)):
            if nums[i] == target:
                ans.append(i)
                flag1 = 1
                break

        for i in range(len(nums) - 1, -1, -1):
            if nums[i] == target:
                ans.append(i)
                flag2 = 1
                break
        if flag1 == 0 and flag2 == 0:
            return [-1, -1]

        return ans