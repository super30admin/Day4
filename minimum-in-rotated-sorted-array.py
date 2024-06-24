# Time complexity: O(logn)
# Space complexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        #if len(nums) <=1:
            #return 
        left = 0
        right = len(nums)-1

        while left <= right:
            
            if nums[left] <= nums[right]:
                return nums[left]
            mid = left + (right-left)//2
            if (mid !=0 and nums[mid] < nums[mid-1]):
                return nums[mid]
            elif nums[mid] >= nums[left]:
                left = mid+1
            else:
                right = mid -1