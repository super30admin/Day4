class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
    
        if not nums:
            return [-1, -1]
        
        left = 0
        right = len(nums) - 1
        res = []
        
        mid = left + (right - left) // 2
        
        while True:
            
            if nums[mid] != target:
                mid = self.binarySearch(left, right, nums, target)
                if mid == [-1, -1]:
                    return [-1, -1]
        
            # Find first occurence
            if nums[mid] == target:
                mid1 = mid
                while mid1 - 1 >= 0 and nums[mid1 - 1] == target:
                    mid1 = self.binarySearch(left, mid1 - 1, nums, target)
                res.append(mid1)

            # Find last occurence
            if nums[mid] == target:
                mid1 = mid
                while mid1 + 1 <= len(nums) - 1 and nums[mid1 + 1] == target:
                    mid1 = self.binarySearch(mid1 + 1, right, nums, target)
                res.append(mid1)
                return res  # return result                
        
    def binarySearch(self, l, r, nums, target):
        
        while l <= r:
            mid = l + (r - l) // 2
            if target == nums[mid]:
                return mid
            elif target > nums[mid]:
                l = mid + 1
            else:
                r = mid - 1
        
        return [-1, -1]
        
