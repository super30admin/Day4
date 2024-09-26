# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

from typing import List

def findMin(nums: List[int]) -> int:
    l, r = 0, len(nums) - 1
    res = nums[0]
    while l <= r:
        m = l + (r-l)//2
         
        if nums[l] < nums[r]:
            res = min(res, nums[l])
            break
               
        res = min(res, nums[m])
        if nums[m] >= nums[l]: #in left sorted portion
            l = m + 1
        else:
            r = m - 1
    return res



nums = [4,5,6,7,0,1,2]

# nums = [3,4,5,-1,2]


print(findMin(nums))