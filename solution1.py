# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def search_range(self, nums, target):
        if len(nums) == 0: return [-1, -1]
        
        # search for first position 
        def search_low(nums, target):
            head, tail = 0, len(nums) - 1
            while head <= tail:
                mid = (head + tail)//2
                if nums[mid] >= target:
                    tail = mid - 1
                else:
                    head = mid + 1
            return head
        # search for seconf position       
        def search_high(nums, target):
            head, tail = 0, len(nums) - 1
            while head <= tail:
                mid = (head + tail)//2
                if nums[mid] > target:
                    tail = mid - 1
                else:
                    head = mid + 1
            return tail
        
        start = search_low(nums, target)
        end = search_high(nums, target)
        if start <= end:
            return [start, end]
        else:
            # does not exist 
            return [-1, -1]