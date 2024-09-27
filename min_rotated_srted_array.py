# lc= 153


# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

# (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

# Find the minimum element.

# You may assume no duplicate exists in the array.


def findMin(nums):
    if nums==None or len(nums)==0:
        return -1
    l, r=0,len(nums)-1
    while l<r:
        mid=l+(r-l)//2
        if nums[mid]>nums[r]:
            # [0,1,2,4,5,6,7] -- original array 
            # [4,5,6,7,0,1,2] -- shifted array
            # mid=3 val at mid =7
            # we check if value of mid is greater value at rightmost index
            # in a sorted array the value at mid will always be less than (or equal to)value at righmost.
            # if this is not the case we can just narrow the search to the right have of the array
            l=mid+1
        else:
            r=mid
            
    return nums[l]


if __name__ == "__main__":
    i1=[3,4,5,1,2] 
    val=findMin(i1)
    print(val)