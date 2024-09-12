# Approach: 
# Brute Force: Initialize minimum to maybe some infinity number and iterate over the array and keep updating the minimum value
# This runs linearly in O(N) time complexity
# Optimized solution: Using Binary Search
# Base cases are single elements in array & if the array is rotated back to original form, we simply return first val
# Otheriwse wrt to middle element we check, if there is a minimum and continue with binary search
# Time Complexity: O(log(N))
# Space Complexity: O(1)
# Successfully ran on leetcode

def findMin(nums):
    # base case 1: if single element
    
    if len(nums) == 1:
        return nums[0]

    # base case 2: If array is rotated 'n' times and back to original sorted positions
    # check if last index element is > first, if yes return first as minimum
    
    left = 0
    right = len(nums) - 1
    if nums[right] > nums[left]:
        return nums[left]


    while left <= right:

        middle = (left + right) // 2
        if nums[middle] > nums[middle + 1]:
            return nums[middle + 1]

        if nums[middle] < nums[middle - 1]:
            return nums[middle]
    
    #  If both above conditions dont hold true, it means the elements are all in sorted manner, and likely wont have a min here
    #  perform binary search

        if nums[middle] > nums[0]:
            # sorted, find min in right half
            left = middle + 1

        else:
            # left is unsorted, find min here
            right = middle - 1






