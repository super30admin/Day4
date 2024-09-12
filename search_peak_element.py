# Approach: To find peak, the element must be greater than its elements
# Brute Force approach: Iterate over the array and keep comparing i and i+1 index values and check if i  > i + 1, return that element
# The above approach runs in linear time complexity O(N)
# We could optimize the following using binary search approach
# Calculate the middle index and check if 
    # arr[middle] > arr[middle + 1] ---> if this is the case the peak is likely to be on the left side
    # arr[middle] < arr[middle + 1] ---> If this is the case the peak is likely to be there on the right side
# Time complexity: O(log(N))
# Space Complexity: O(1)
# Successfully ran on leetcode

def findPeakElement(nums):
    left = 0
    right = len(nums) - 1

    while left < right:
        middle = (left + right) // 2
        if nums[middle] > nums[middle + 1]:
            # peak is likely on left side, move right pointer
            right = middle
        
        else:
            left = middle + 1

    return left

