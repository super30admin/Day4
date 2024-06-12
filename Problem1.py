#Time Complexity - O(log n)
#Space Complexity - O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = 0
        end = len(nums) - 1
        if len(nums) == 0:
            return [-1, -1]
        firstElement = self.searchFirst(start, end, nums, target)
        lastElement = self.searchLast(start, end, nums, target)
        return [firstElement, lastElement]
    
    def searchFirst(self, start, end, arr, target):
        while start <= end:
            mid = (start + end) // 2
            if arr[mid] == target:
                if mid - 1 >= 0 and arr[mid - 1] == target:
                    end = mid - 1
                    continue
                else:
                    return mid
            if arr[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1
    
    def searchLast(self, start, end, arr, target):
        while start <= end:
            mid = (start + end) // 2
            if arr[mid] == target:
                if mid + 1 < len(arr) and arr[mid + 1] == target:
                    start = mid + 1
                    continue
                else:
                    return mid
            if arr[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1