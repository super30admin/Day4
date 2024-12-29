class Solution:
    def binarySearchFirst(self, nums, target):
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low + (high-low) // 2
            if (nums[mid] == target):
                if (mid==low or nums[mid-1] != nums[mid]):
                    return mid
                high=mid-1
            elif nums[mid] < target:
                low = mid+1
            else:
                high=mid-1
        return -1

    def binarySearchSecond(self,nums,target):
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if (mid == high or nums[mid+1] != nums[mid]):
                    return mid
                low = mid+1
            elif nums[mid] < target:
                low = mid+1
            else:
                high=mid-1
        return -1
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        if target < nums[0] or target > nums[-1]:
            return [-1,-1]
        
        first = self.binarySearchFirst(nums,target)
        if first == -1:
            return [-1,-1]
        second = self.binarySearchSecond(nums,target)

        return [first,second]