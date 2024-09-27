'''
Time Complexity - O(logn)
Space Complexity - O(1)
'''


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def firstbinarysearch(nums, target):
            low = 0
            high = len(nums)-1
            while(low <= high):
                mid = low+(high-low)//2
                if(nums[mid] == target):
                    if(mid == 0 or nums[mid] > nums[mid-1]):
                        return mid
                    else:
                        high = mid-1
                elif(nums[mid] < target):
                    low = mid+1
                else:
                    high = mid-1
            return -1

        def secondbinarysearch(nums, low, target):
            high = len(nums)-1
            while(low <= high):
                mid = low+(high-low)//2
                if nums[mid] == target:
                    if (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                        return mid
                    else:
                        low = mid+1
                elif(nums[mid] < target):
                    low = mid+1
                else:
                    high = mid-1
            return -1
        if not nums:
            return [-1, -1]
        if (nums[0] > target or nums[len(nums)-1] < target):
            return [-1, -1]
        first = firstbinarysearch(nums, target)
        if first == -1:
            return [-1, -1]
        last = secondbinarysearch(nums, first, target)
        return [first, last]
