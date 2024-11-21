'''
To find min using binary search, we compute mid and find the sorted side by comparing mid with low and high. If mid > low, move right as left is sorted and min element will be present on unsorted side. If mid < high, move left as right is sorted. If mid is less than elements at both mid-1 and mid+1, then that is the min element.

Time complexity: O(log(N))
Space Complexiy: O(1)

Passes all leetcode testcases

'''


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while(low<=high):
            if nums[low] <= nums[high]: return nums[low]
            mid = low+(high-low)//2
            if(mid == 0 or nums[mid-1]>nums[mid]) and (nums[mid]<nums[mid+1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
