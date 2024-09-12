#find-minimum-in-rotated-sorted-array

# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :confused at first but the lecture made it clear

def findMin(nums):
    low=0
    high=len(nums)-1
    while(low<=high):
        if(nums[low]<=nums[high]):              #if its sorted then the minimum is the one on the leftmost
            return nums[low]
        mid = (high+low)//2
        if((mid==0 or nums[mid-1]>nums[mid]) and (mid ==len(nums)-1 or nums[mid+1]>nums[mid])):  #return if its the smallest or if there's no element on the left or right
            return nums[mid]
        elif (nums[mid]>=nums[low]):
            low=mid+1
        else:
            high=mid-1

#test
print(findMin([4,5,6,7,1,2]))
print(findMin([4,1,2]))