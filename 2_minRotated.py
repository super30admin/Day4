# time complexity : O(log(n))
# space complexity : O(1)
# working on Leetcode : yes
# logic : pivot element is always lies in unsorted part of array

# search of min in rotated sorted array, which is pivot element.
def minsearch(nums):
    l = 0
    r = len(nums) - 1
    while l <= r:
        mid = l + (r - l) // 2
        # in below expression, the order of condition check is important.
        if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
            return nums[mid]
        # left part sorted
        if nums[mid] < nums[r]:
            r = mid - 1
        else:  # right part sorted
            l = mid + 1
    return -1

nums=[3,4,5,6,1,2]
print(minsearch(nums))

