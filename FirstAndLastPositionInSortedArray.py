# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarysearch(flag):
            ans = -1
            l = 0
            r = len(nums) - 1
            while l <= r:
                mid = (l + r) // 2
                if nums[mid] == target:
                    if flag == "LEFT":
                        ans = mid
                        r = mid - 1
                        continue
                    else:
                        ans = mid
                        l = mid + 1
                        continue
                if nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1
            return ans
        
        left = binarysearch("LEFT")
        right = binarysearch("RIGHT")
        
        return [left,right]