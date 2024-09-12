#find-first-and-last-position-of-element-in-sorted-array

# // Time Complexity : O(log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :knew how it worked but had some trouble in implementing

def searchRange( nums, target: int):
    #three cases:

    first = left_value(nums, target)            #first, find the left most value 
    second = right_value(nums, target)          #find the last most value
    return [first, second]
    
def left_value(nums, target):
    low=0
    high=len(nums)-1
    while (low<=high):
        mid = low + (high-low)//2
        if(nums[mid]==target):
            if(mid==0 or nums[mid]>nums[mid-1]):                #if arrived at the leftmost value, then return the index
                return mid
            else:                                               #if not, keep moving left
                high=mid-1
        elif(nums[mid]>target):                                 #if value is greater than target, then look to the left
            high=mid-1
        else:                                                   #if value is less than target, then look to the right
            low=mid+1
    return -1
    
def right_value(nums, target):
    low=0
    high=len(nums)-1
    while (low<=high):
        mid = low + (high-low)//2
        if(nums[mid]==target):
            if(mid==len(nums)-1 or nums[mid]<nums[mid+1]):      #if arrived at the rightmost value, then return the index
                return mid
            else:                                               #if not, keep moving right
                low=mid+1
        elif(nums[mid]>target):                                 #if value is greater than target, then look to the left
            high=mid-1
        else:                                                   #if value is less than target, then look to the right
            low=mid+1
    return -1
                
       