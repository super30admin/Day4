class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1, -1]

        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        second = self.binarySearchSecond(nums, target)
        return [first, second]

    def binarySearchFirst(self, nums: List[int], target:int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if (nums[mid] == target):
                if (mid == low) or (nums[mid - 1] != nums[mid]):
                    return mid
                else:
                    high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else: 
                print('in else')
                high = mid - 1
        return -1
        
    def binarySearchSecond(self, nums: List[int], target:int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if (mid == high) or (nums[mid + 1] != nums[mid]):
                    return mid
                else:
                    low = mid + 1
            elif target > nums[mid]:
                low = mid + 1
            else: 
                high = mid - 1
        return -1

    