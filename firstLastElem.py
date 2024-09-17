# Time Complexity : O(log n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


class Solution(object):
        def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums == []:
                return [-1,-1]
        if target not in nums:
                return [-1,-1]
        if len(nums) == 1:
                return [0,0]
        l=0
        r=len(nums)-1
        mid = 0
        while(l<=r):
                mid = l + (r-l)/2
                if nums[mid] == target:
                break
                elif nums[mid] > target:
                r = mid-1
                else:
                l = mid+1
        #print(mid)
        l = mid
        r = mid
        i=0
        j=0
        retlist = [0,0]
        for i in reversed(range(mid+1)):
                if nums[i] == target:
                        retlist[0] = i
        for j in range(mid, len(nums)):
                if nums[j] == target:
                        retlist[1] = j
        return retlist