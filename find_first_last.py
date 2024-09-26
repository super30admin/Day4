# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def searchRange(self, nums, target):
        def find_end(nums,target):
            index = -1
            start = 0
            end = len(nums)-1

            while start <= end:
                mid = (start + end )// 2

                if nums[mid] == target:
                    index = mid

                if nums[mid] <= target:
                    start = mid+1
                else:
                    end = mid -1

            return index
    
        def find_start(nums,target):
            index = -1
            start = 0
            end = len(nums)-1

            while start <= end:
                mid = (start + end) // 2

                if nums[mid] == target:
                    index = mid

                if nums[mid] >= target:
                    end = mid-1
                else:
                    start = mid +1

            return index
        
        return [find_start(nums,target), find_end(nums,target)]
