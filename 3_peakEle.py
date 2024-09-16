# time complexity : O(log(n))
# space complexity : O(1)
# working on Leetcode : yes


# find any peak element
# logic: 1) find mid and check if a[mid] > a[mid-1] then l=mid+1 else r=mid-1
# 2) break when a[mid-1] <a[mid] and a[mid+1]<a[mid] return mid

def peak(nums):
    l = 0
    r = len(nums) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
            return mid
        elif mid > 0 and nums[mid] < nums[mid - 1]: # mid should not be end points of array
            r = mid - 1
        else:
            l = mid + 1

    return -1


nums = [1,2,3,1]

print(peak(nums))



# find mid