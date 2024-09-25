# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        arr_size = len(nums)

        def findFirst():
            start = 0
            end = arr_size - 1

            while(start <= end):
                mid = start + (end - start)//2
                if nums[mid] < target:
                    start = mid + 1
                elif nums[mid] > target:
                    end = mid - 1
                else:
                    if mid - 1 >= 0 and nums[mid-1] == target:
                        end = mid - 1
                    else:
                        return mid
            return -1

        def findLast():
            start = 0
            end = arr_size - 1

            while(start <= end):
                mid = start + (end - start)//2
                if nums[mid] < target:
                    start = mid + 1
                elif nums[mid] > target:
                    end = mid - 1
                else:
                    if mid + 1 < arr_size and nums[mid + 1] == target:
                        start = mid + 1
                    else:
                        return mid
            return -1

        start = findFirst()
        last = findLast()
        return [start, last]
