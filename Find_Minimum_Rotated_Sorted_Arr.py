# 153 Find Minimum in Rotated Sorted Array

#time =
#space = 

def min_rotatedsorted_arr(nums):
    left, right = 0, len(nums) - 1

    while left < right:
        mid = (left + right) // 2
        
        # Compare middle element with the rightmost element
        if nums[mid] > nums[right]:
            # The minimum is in the right half
            left = mid + 1
        else:
            # The minimum is in the left half (including mid)
            right = mid

    # When left == right, we have found the smallest element
    return nums[left]
# nums1 = [3, 4, 5, 1, 2]
# print(min_rotatedsorted_arr(nums1))  # Output: 1

nums2 = [4, 5, 6, 7,-1, 0, 1]
print(min_rotatedsorted_arr(nums2))  # Output: 0

# nums3 = [11, 13, 15, 17]
# print(min_rotatedsorted_arr(nums3))  # Output: 1