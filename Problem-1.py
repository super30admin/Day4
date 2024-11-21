# 34. Find First and Last Position of Element in Sorted Array
# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def BS_first(self, arr, target):
        start = 0
        end = len(arr) - 1

        while start <= end:
            mid = start + (end-start)//2

            if mid > 0:
                if arr[mid] == target:
                    if arr[mid-1] != target:
                        return mid
                    else:
                        end = mid - 1
                elif arr[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1

            elif mid == 0:
                if arr[mid] == target:
                    return 0
                elif arr[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            else:
                return len(arr) - 1
        return -1
    
    def BS_last(self, arr, target):
        start = 0
        end = len(arr) - 1

        while start <= end:
            mid = start + (end-start)//2

            if mid < len(arr) - 1:
                if arr[mid] == target:
                    if arr[mid+1] != target:
                        return mid
                    else:
                        start = mid + 1
                elif arr[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            elif mid == 0:
                if arr[mid] == target:
                    return 0
                elif arr[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            else:
                if arr[mid] == target:
                    return len(arr) - 1
                else:
                    return -1
        return -1

    def searchRange(self, nums, target):
        if not nums:
            return [-1,-1]
        
        start = 0
        end = len(nums) - 1

        if nums[start] == nums[end] == target:
            return [start, end]
        
        if nums[start] > target or nums[end] < target:
            return [-1,-1]

        return [self.BS_first(nums, target), self.BS_last(nums, target)]

obj = Solution()
# print(obj.searchRange([5,7,7,8,8,10], 8))
# print(obj.searchRange([5,7,7,8,8,10], 7))
# print(obj.searchRange([5,7,7,8,8,8,8,8,10], 8))
print(obj.searchRange([1,5], 4))