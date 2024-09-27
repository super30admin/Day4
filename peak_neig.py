# lc=162



# A peak element is an element that is greater than its neighbors.

# Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

# The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

# You may imagine that nums[-1] = nums[n] = -∞.




def findPeakElement(nums):
    if nums==None or len(nums) == 0:
        return -1
    l=0
    r=len(nums)-1
    
    while l<r:
        mid=l+(r-l)//2
        
        if nums[mid]<nums[mid+1]:
            l=mid+1
        else:
            r=mid
    return l


if  __name__ == "__main__":
    input1=[[1,2,3,1],[1,2,1,3,5,6,4]]


    for i in input1:
        print(findPeakElement(i))
        