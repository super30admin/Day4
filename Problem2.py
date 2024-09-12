"""
153. Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
Find the minimum element.
You may assume no duplicate exists in the array.
Example 1: Input: [3,4,5,1,2] Output: 1
Example 2: Input: [4,5,6,7,0,1,2] Output: 0
Approach --
1. Since its a rotated array, it is observed empirically that the min value is
in the unsorted part of the array
2. take two variables low (0th element) and high (last element)
3. check if already sorted -> nums[low] <= nums[high], if yes return nums[low], else find mid.
Check if mid element is the smallest element
4. check if immediate element of mid is less than mid or high than mid, if so return that element
5. else perform binary search pn unsorted part by doing if nums[low] <= nums[mid]
Time complexity - O(log n)
space complexity - O(1)
"""

n = [4, 5, 6, 7, 0, 1, 2]


def findminimum(nums):
    if nums is None or len(nums) == 0:
        return -1
    low = 0
    high = len(nums)-1
    while low <= high:
        # check if already sorted
        if nums[low] <= nums[high]:
            return nums[low]
        mid = low + (high-low)//2   #prevent overflow

        # check if immediate element of mid is less than mid or high than mid, if so return that element
        if (mid == low or nums[mid - 1] > nums[mid]) and (mid == high or nums[mid + 1] > nums[mid]):
            return nums[mid]

        if nums[low] <= nums[mid]:
            low = mid + 1
        else:
            high = mid - 1
    return -1

print(findminimum(n))
