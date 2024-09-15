class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        
        while l <= r:
            mid = l + (r - l) // 2
            if ((mid == 0 or nums[mid] < nums[mid-1]) and 
                (mid == len(nums) - 1 or nums[mid] < nums[mid+1])):
                return nums[mid]
            elif nums[mid] < nums[r]:           #move towards the unsorted side
                r = mid - 1                     #defaults left in case its perfectly sorted
            else:
                l = mid + 1
        return -1