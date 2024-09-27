'''
LOGIC - Binary search algorithm is used here by considering the base and edge case conditions.
If left index is less or equal to right index, we can directly return the first element else
go in the unsorted direction of the error.
Time Complexity - O(log N), where N indicates the length of the list nums
Space Complexity - O(log 1)
Successfully executed all the testcases and accepted in leetcode
'''


class Solution:
    def findMin(self, nums: List[int]) -> int:
        l,r = 0,len(nums)-1
        while l<=r:
            if nums[l] <= nums[r]:
                return nums[l]
            m = l + (r-l)//2
            if (m == 0 or nums[m-1] > nums[m]) and (m == len(nums)-1 or nums[m] < nums[m+1]):
                return nums[m]
            else:
                if nums[l] <= nums[m]: # left sorted
                    l = m + 1
                else:
                    r = m - 1
        