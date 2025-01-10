class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1,-1]
        first = self.binarySearchFirst(nums,target)
        if first == -1:
            return [-1,-1]
        
        last = self.binarySearchLast(nums, target)
        return [first,last]

    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if (mid == 0) or nums[mid-1] != target:
                    return mid
                else:
                    #keep on moving left
                    high = mid -1 
            elif nums[mid]<target:
                low = mid +1
            else:
                high = mid - 1
        return -1

    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if (mid == len(nums)-1) or nums[mid+1] != target:
                    return mid
                else:
                    #keep on moving right
                    low = mid + 1
            elif nums[mid]<target:
                low = mid +1
            else:
                high = mid - 1
        return -1