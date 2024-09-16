"""
https://leetcode.com/problems/find-peak-element/
A peak element is an element whose value is greater than both of its neighbors.
Provided an input array nums, such that nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that nums[-1] = nums[n] = -∞.
:return:peak element
Input nums = -inf [1,2,3,1] -inf
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2. We will find the mi value and will
always move towards to greater side of the array.
Tc:O(logn)
SC:(1)
"""

# import math
# s=float('-inf')
# list=[1,2,1,3,4,5,6]
# i=0
# while(list[i]>s and list[i]>list)

def findpeakelement(nums):
    # nums[-1]=float('-inf')
    # nums[len(nums)]=float('-inf')
    # for i in range(len(nums)-1):
    #     if nums[i]>nums[i-1] and nums[i]>nums[i+1]:
    #         return "the index is and the the number is", [i, nums[i]]
    if len(nums)==0:
        return -1
    low=0
    high=len(nums)-1
    while(low<=high):
        mid=(low+high)//2
        if (mid ==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
            return mid
        elif mid!=0 and nums[mid]< nums[mid-1]:
            high=mid-1
        else:
            low=mid+1
    return 123



nums=[1,2,3,1]
print(findpeakelement(nums))
