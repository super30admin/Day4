# Time Complexity = O(log n)
# Sapce Complexity = O(1)
# Leetcode = Yes
# Approach = We can perform two binary searches, StartPos and EndPos, to find first and last occurance. StartPos finds the first occurrence of the target by checking if the current mid is the start or if the previous element is smaller. Similarly, EndPos finds the last occurrence by checking if the current mid is the end or if the next element is larger. Both functions run in 


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        class FindTargetRange:
            def StartPos(arr, target, low, high):
                while low <= high:
                    mid = low + (high - low) // 2
                    if arr[mid] == target:
                        if mid == low or arr[mid - 1] < arr[mid]:
                            return mid
                        else:
                            high = mid - 1
                    elif arr[mid] > target:
                        high = mid - 1
                    else:
                        low = mid + 1
                return -1

            def EndPos(arr, target, low, high):
                while low <= high:
                    mid = low + (high - low) // 2
                    if arr[mid] == target:
                        if mid == high or arr[mid] < arr[mid + 1]:
                            return mid
                        else:
                            low = mid + 1
                    elif arr[mid] > target:
                        high = mid - 1
                    else:
                        low = mid + 1
                return -1

        firstPos = FindTargetRange.StartPos(nums, target, 0, len(nums) - 1)
        lastPos = FindTargetRange.EndPos(nums, target, 0, len(nums) - 1)
        return [firstPos, lastPos]
