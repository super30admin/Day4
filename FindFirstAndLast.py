# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class FindFirstAndLast:
    def binarySearchFirst(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (high + low) // 2
            if nums[mid] == target:
                if mid == low or nums[mid - 1] != target:
                    return mid # If the middle element is equal to the target and the element to the left of mid is not equal, return mid as the first occurence
                high = mid - 1 # If the lower element is also equal to target, do Binary search on the left
            elif target > nums[mid]: # Target larger than the middle element
                low = mid + 1 # Do Binary search on the right
            else:
                high = mid - 1 # Else, do Binary search on the left
        return -1 # Element not found

    def binarySearchSecond(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (high + low) // 2
            if nums[mid] == target:
                if mid == high or nums[mid + 1] != target:
                    return mid # If the middle element is equal to the target and the element to the right of mid is not equal, return mid as the second occurence also
                low = mid + 1 # If the higher element is also equal to target, do Binary search on the right
            elif target > nums[mid]: # Target larger than the middle element
                low = mid + 1 # Do Binary search on the right
            else:
                high = mid - 1 # Else, do Binary search on the left
        return -1 # Element not found

    def searchRange(self, nums, target):
        if not nums: # Empty array. Return -1,-1
            return [-1, -1]
        first = self.binarySearchFirst(nums, target) # Returns the first index the element is located at
        if first == -1:
            return [-1, -1]
        second = self.binarySearchSecond(nums, target) # Returns the first index the element is located at
        if second == -1:
            return [first, first]
        return [first, second]

# Example usage
findFirstAndLast = FindFirstAndLast()
nums = [5, 7, 7, 8, 8, 10]
target = 8
print(findFirstAndLast.searchRange(nums, target))  # Output: [3, 4]

target = 6
print(findFirstAndLast.searchRange(nums, target))  # Output: [-1, -1]
