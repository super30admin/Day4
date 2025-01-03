
######### Find peak element ###########

# Time Complexity :  O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# perform binary search if the mid element is smaller than its previous peak lies 
# to the left so update right and if mid is bigger than next element then peak
# lies to the right so update left. and if mid is greater than both left and right
# element return mid as that is a peak element index


def find_peak(nums):
    l = 0
    r = len(nums)-1
    while l <=r:
        mid = (l+r)//2
        if (mid==l or nums[mid] > nums[mid-1]) and (mid==r or nums[mid] > nums[mid+1]):
            return mid
        elif nums[mid] > nums[mid+1]:
            r = mid - 1
        else:
            l = mid + 1
    return -1


print(find_peak([1,2,1,3,5,6,4]))
