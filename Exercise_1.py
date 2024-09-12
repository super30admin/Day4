# 34. Find First and Last Position of Element in Sorted Array
# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


# Time Complexity = O(log n)
# Space Complexity = O(1)

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def searchElement(nums, target, left_bts=True):
            
            start = 0 
            end = len(nums) -1
            while start <= end:
                mid = (start + end) // 2
                if nums[mid] == target:
                    if left_bts:
                        if mid == start or nums[mid - 1] < target:
                            return mid
                        end = mid - 1
                    else:
                        if mid == end or nums[mid + 1] > target:
                            return mid
                        start = mid + 1
                elif nums[mid] > target:
                    end = mid - 1
                else:
                    start = mid + 1

            return -1
        

        left_element = searchElement(nums, target, left_bts=True)
        if (left_element == -1):
            return [-1, -1]

        right_element = searchElement(nums, target, left_bts=False)
        return [left_element, right_element]
