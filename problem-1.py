## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
"""
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Previously I missed the edge case when there is only 1 element. Having trouble with OOP concepts

"""

class first_last():
    def solution(self,nums, target):        # we will perform 2 binary search on first part part and on 2nd part
        def first(nums,target):             # first part binary sort to get first position of target
            low=0
            high=len(nums)-1
            while low <= high:
                mid= low + (high-low)//2
                if nums[mid]==target:                     # we will check if target == element at mid
                    if low==mid or nums[mid-1] != target: # check if element before mid == target or not if not then return mid
                        return mid                        # low==mid condition is to check if we have only 1 element
                                                          # return mid else move high to mid-1
                    else:
                        high=mid-1
                elif nums[mid] > target:                  # normal binary search
                    high=mid-1
                else:
                    low=mid+1
            return -1

        def last(nums,target):
            low=0
            high=len(nums)-1
            while low <= high:
                mid= low + (high-low)//2
                if nums[mid]==target:           # we will check if target == element at mid
                    if high==mid or nums[mid+1] != target:   # check if element after mid == target or not if not then return mid
                        return mid                       # high==mid condition is to check if we have only 1 element
                    else:
                        low=mid+1                  # return mid else move low to mid+1
                elif nums[mid] > target:
                    high=mid-1
                else:
                    low=mid+1
            return -1
        f=first(nums,target)
        l=last(nums, target)
        return [f,l]

if __name__ == '__main__':
    nums = [5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 10]
    target = 8
    fl=first_last()
    print(fl.solution(nums,target))




