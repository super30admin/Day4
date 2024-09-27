# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def searchRange(self, nums, target):
        def find_right(nums,target):
            index = -1
            left = 0
            right = len(nums)-1

            while left <= right:
                mid = (left + right )// 2

                if nums[mid] == target:
                    index = mid

                if nums[mid] <= target:
                    left = mid+1
                else:
                    right = mid -1

            return index
    
        def find_left(nums,target):
            index = -1
            left = 0
            right = len(nums)-1

            while left <= right:
                mid = (left + right) // 2

                if nums[mid] == target:
                    index = mid

                if nums[mid] >= target:
                    right = mid-1
                else:
                    left = mid +1

            return index
        start_index = find_left(nums,target)
        end_index = find_right(nums,target)
        return [start_index, end_index ]
