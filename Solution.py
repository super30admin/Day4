######### Find the first and last occurence of an element ###########
# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially forgot to reset the index for the second binary search.

def find_first_and_last(nums, target):
    start = -1
    end = -1
    l = 0
    r = len(nums)-1
    while l <= r:
        mid = (l+r)//2
        if nums[mid] < target:
            l = mid + 1
        elif nums[mid] > target:
            r = mid - 1
        else:
            if mid==0 or nums[mid-1]!= target:
                start = mid
                break
            else:
                r = mid - 1

    if start == -1:
        return [-1,-1]

    l = start
    r = len(nums)-1
    while l <= r:
        mid = (l+r)//2
        if nums[mid] < target:
            l = mid + 1
        elif nums[mid] > target:
            r = mid - 1
        else:
            if mid==len(nums)-1 or nums[mid+1]!= target:
                end = mid
                break
            else:
                l = mid + 1
        
    if end == -1:
        return [-1,-1]
    else:
        return [start,end]


######### Find minimum in rotated sorted array ###########

# Time Complexity :  O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Keep checking the mid element with the last element if the mid element is smaller than the last pivot is to the left of mid
# and if the mid element is bigger than the last element then the pivot is on the right of the mid element. This pivot is
# also our min value in a rotated sorted array.

def find_pivot(nums):
  l = 0
  r = len(nums)-1
  while l<= r:
    mid = (l+r)//2
    if nums[mid] > nums[-1]:
      l = mid + 1
    else:
      r = mid - 1
  return nums[l]

    

