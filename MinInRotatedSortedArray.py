# time complexity: O(log(n))
# space complexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if(len(nums)==1):
            return nums[0]
        if(nums[0]<nums[-1]):
            # array is sorted
            return nums[0]
        beg = 0
        end = len(nums) - 1
        
        # find pivot, nums[mid]<nums[mid+1]
        while(beg<=end):
            mid = (beg + end)//2
            if(nums[mid-1]>nums[mid]):
                # pivot
                return nums[mid]
            if(nums[mid]>nums[end]):
                # min is on right side
                beg = mid + 1
            else:
                # min in on left side
                end = mid - 1
