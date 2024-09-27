#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this :
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findIndex(nums: List[int],target: int):
            left = 0
            right = len(nums) -1
            ans=len(nums)

            while left <= right:
                mid = (left+right) // 2
                if nums[mid] >= target:
                    ans = mid
                    right = mid-1
                else:
                    left = mid+1
            return ans

        firstIndex = findIndex(nums, target)
        lastIndex = findIndex(nums, target+1)-1

        if firstIndex <= lastIndex:
            return [firstIndex,lastIndex]
        return [-1,-1]