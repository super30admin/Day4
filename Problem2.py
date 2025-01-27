#Find Minimum in Rotated Sorted Array
#The minimum which is pivot will be in unsorted part
#find unsorted array and discard sorted part
#handle cases for single and 2 elemets using mid == 0 and mid < n-1 condition

# Time complexity = O(logn)
# space complexity = O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        while low <= high:
            #check range
            if nums[low] <=  nums[high]:
                return nums[low]
            #check for mid
            mid  = low + (high-low) // 2
            if ((nums[mid] == 0 or (nums[mid] < nums[mid - 1]))
                and (nums[mid] == len(nums)-1 or nums[mid] < nums[mid+1])):
                return nums[mid]
            else:
                if nums[low] <= nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1