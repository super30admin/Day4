class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first_pos = self.BinarySearchLeft(nums, target)
        if first_pos == -1:
            return [-1, -1]
        else:
            return [first_pos,self.BinarySearchRight(nums, target)]


    def BinarySearchLeft(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        while (low <= high):
            mid = low + (high - low)//2
            if nums[mid] == target:
                if (mid == 0) or (nums[mid] > nums[mid - 1]): # Compare mid with mid - 1 to check if its first occurence
                    return mid
                else:
                    high = mid - 1 #  else Keep Moving Left
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def BinarySearchRight(self, nums: List[int], target: int) -> int:
        low, high = self.BinarySearchLeft(nums, target), len(nums) - 1
        while (low <= high):
            mid = low + (high - low)//2
            if nums[mid] == target:
                if (mid == len(nums) - 1) or (nums[mid] < nums[mid + 1]): # Compare mid with mid+1 to check if its the last occurence
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

        