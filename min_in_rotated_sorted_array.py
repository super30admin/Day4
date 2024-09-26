#method-binary seach
#first find the middle element,then check the following
#case-1: if middle element is greater than first element ,return middle+1
#else, now check if the minimum element lies on right sub-array or left-subarray
#repeat the process until case-1 is satisfied.


class Solution:
    def findMin(self, nums: List[int]) -> int:
        '''O(logn) time complexity
            O(1) space complexity'''
        low=0
        high=len(nums)-1
        #case where array is not rotated and edge case of single element
        if nums[high]>=nums[low]:
            return nums[low]
        #case when array is rotated
        while(low<=high):
            middle=low+(high-low)//2
            #if nums[middle+1]<nums[middle]:
            #    return nums[middle+1]
            #check if middle element >next element,then middle element is the pivot and middle+1 element is the minimum 
            if nums[middle]>nums[middle+1]:
                return nums[middle+1]
            #case where mid falls on minimum element
            if nums[middle]<nums[middle-1]:
                return nums[middle]
            else:
                #check which side is sorted,minimum lies on unsorted side
            #check if minimum is on right side
                if nums[middle]>nums[0]:
                    low=middle+1
            #if minimum on left side
                else:
                    high=middle-1
                
        