class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        output = float('inf')
        
        while (left<=right):
            mid = left + (right - left) // 2
            #min lies on the left side
            if nums[right] >= nums[mid]:
                output = min(output, nums[mid])
                right = mid - 1
            #min lies on the right side
            elif nums[mid] >= nums[right]:
                output = min(output, nums[mid])
                left = mid + 1
                
        return output