class Solution:
    def findMin(self, nums: List[int]) -> int:
        high, low = len(nums) - 1, 0

        while low <= high:
            mid = (low + high)//2
            # Check if we reached the range which is already sorted the  first element will be minimum
            if nums[low] <= nums[high]: 
                return nums[low]
            # check if min element is at mid (a mid is minimum if its smaller than both of its neighbors)    
            if (mid==0 or (nums[mid] < nums[mid - 1])) and ((nums[mid] < nums[mid + 1])):
                return nums[mid]
            # Check if left side is sorted go to right side as the min lies at the unsorted side
            elif (nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid - 1
        