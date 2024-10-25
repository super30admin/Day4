class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start = 0
        end = len(nums)-1
        n = len(nums)-1

        while(start <= end):
            mid = (start + end) // 2

            if (mid == 0 or (nums[mid] > nums[mid-1])) and (mid == n or (nums[mid] > nums[mid+1])):
                return mid
            elif (mid > 0 and (nums[mid] < nums[mid-1])):
                end = mid -1 
            else:
                start = mid + 1
        
        return -1
        