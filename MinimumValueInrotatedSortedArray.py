class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return nums[0]
        left,right = 0,len(nums)-1
        while left <= right:
            if nums[left] <= nums[right]:
                return nums[left]
            mid = left + (right-left)//2 
            #mid function avoids integer overflow
            # return mid value if it is greater than its neighbors
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid+1]>nums[mid]):
                return nums[mid] 
            elif nums[left] <= nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return -1
# TC : O(log n)
# SC : O(1)
        