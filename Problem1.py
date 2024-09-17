class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums)-1
        
        while left <= right:
            mid = int(left+(right-left)/2)
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return [self.find_left(nums, 0, mid, target), self.find_right(nums, mid, len(nums)-1, target)]
        return [-1,-1]
    
    def find_left(self, nums, left, right, target):
        while left<right:
            mid = int(left+(right-left)/2)
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid-1] < target:
                return mid
            else:
                right = mid - 1
        return left
    
    def find_right(self, nums, left, right, target):
        while left<right:
            mid = int(left+(right-left)/2)
            if nums[mid] > target:
                right = mid -1
            elif nums[mid+1] > target:
                return mid
            else:
                left = mid + 1
        return right