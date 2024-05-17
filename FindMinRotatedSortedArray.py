# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class FindMinRotatedSortedArray:
    def findMin(self, nums):
        if not nums:
            return -1
        elif len(nums) == 1 or nums[0] <= nums[-1]:
            # Only one element or the entire array is sorted but not rotated
            return nums[0]
        
        low, high = 0, len(nums) - 1
        
        while low <= high:
            if nums[low] <= nums[high]:
                # sorted sub array. the lowest element is minimum
                return nums[low]
            
            mid = (high + low) // 2
            
            if (mid == high or nums[mid + 1] > nums[mid]) and (mid == low or nums[mid - 1] > nums[mid]):
                # Middle element is the smallest
                return nums[mid]
            elif nums[low] <= nums[mid]:
                # Left side is sorted. Check the middle only on the right
                low = mid + 1
            else:
                high = mid - 1
        
        # Dummy return statement
        return nums[low]

# Example usage
findMinRotatedSortedArray = FindMinRotatedSortedArray()
nums = [3, 4, 5, 1, 2]
print(findMinRotatedSortedArray.findMin(nums))  # Output: 1

nums = [4, 5, 6, 7, 0, 1, 2]
print(findMinRotatedSortedArray.findMin(nums))  # Output: 0

nums = [11, 13, 15, 17]
print(findMinRotatedSortedArray.findMin(nums))  # Output: 11
