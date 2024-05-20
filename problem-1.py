# Time Complexity
# O(log n)
# Space Complexity
# O(1)

# Approach :

# we apply binary search on both parts of the middle element
# if we see that arr[mid-1] is not equal to the arr[mid] th element, we reutrn that arr[mid]th index
# similary if we see that arr[mid+1] th is not equal to arr[mid]th index, we return arr[mid] th index


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if not nums:
            return [-1, -1]

        lenArr = len(nums)
        firstIndex = self.bsFirst(nums, target, lenArr)
        if firstIndex == -1:
            return [-1, -1]
        secondIndex = self.bsSecond(nums, target, lenArr)

        return [firstIndex, secondIndex]

    def bsFirst(self, arr, target, lenArr):
        low = 0
        high = lenArr-1

        while low <= high:
            mid = (low + high)//2
            if arr[mid] == target:
                if (mid == 0 or arr[mid-1] != target):
                    return mid
                high = mid-1
            if arr[mid] < target:
                low = mid+1
            if arr[mid] > target:
                high = mid-1

        return -1

    def bsSecond(self, arr, target, lenArr):
        low = 0
        high = lenArr-1
        while low <= high:
            mid = (low + high)//2
            if arr[mid] == target:
                if (mid == high or arr[mid+1] != target):
                    return mid
                low = mid+1
            if arr[mid] > target:
                high = mid-1
            if arr[mid] < target:
                low = mid+1

        return -1
