#Time Complexity: O(log n)
#Space Complexity: O(1)
#Problem sucessfully accepted in leetcode: yes
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start = 0
        end = len(nums)-1
#If only 1 element in array, return it
        if start==end: return start
        while(start<=end):
            mid = start+(end-start)//2
#Compare current element with element before and after present index, if index is not at start or end 
            if mid>0 and mid<len(nums)-1:
#Element is peak if it is greater than next and previous elements
                if nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1]:
                    return mid
                elif nums[mid-1]>nums[mid]:
                    end= mid-1
                else:
                    start=mid+1
#If current element is zero, compare to 1st index
            elif mid==0:
                if nums[mid]>nums[mid+1]:
                    return 0
                else:
                    return 1
#If current index is last, compare only with element before it 
            elif mid==len(nums)-1:
                if nums[mid]>nums[mid-1]:
                    return mid
                else:
                    return mid-1
                