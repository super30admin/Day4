# Time complexity: O(log n)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
#check if mid is greater than mid -1 and mid + 1 also if mid is zero and n-1 then return mid
#else check i mid-1 > mid then make high as mid - 1
#else make low as mid + 1

def findPeakElement(self, nums: List[int]) -> int:
    n = len(nums)
    low = 0
    high = n - 1
    while low <= high:
        mid = low + (high - low) // 2
        if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == n - 1 or nums[mid] > nums[mid + 1]):
            return mid
        elif mid>0 and nums[mid-1] > nums[mid]:
            high = mid -1
        else:
            low = mid + 1
    return nums[low]
        