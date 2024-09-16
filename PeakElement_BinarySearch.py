class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid = low+(high-low)//2
            if ((mid==low or nums[mid]>nums[mid-1]) and (mid == high or nums[mid]>nums[mid+1])):
                return mid
            elif nums[mid]<nums[mid-1] and mid!=0:
                high = mid-1
            else:
                low = mid+1
        return -1

# this implementation takes O(log(n)) complexity as any one of the peak element is found using binary search