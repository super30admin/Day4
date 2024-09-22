# Time Complexity : O(logn)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding fucntions in python


# Your code here along with comments explaining your approach in three sentences only
# -> First Binary Search to find the first occurence of the element
# -> Second Binary Search to find the last occurene of the element
# -> If the element exists, then return first and last index of occurences or return [-1,-1]

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #To check if the array is empty
        if(len(nums)==0):
            return [-1,-1]
        n = len(nums)-1

        #Binary search to find the first occurence of element
        def FirstBinarySearch(nums,low,high,target):
            while(low<=high):
                mid = low+(high-low)//2
                #To check if our target exists in mid
                if(nums[mid]==target):
                    #If it exists, check if it's starting element or not
                    if(mid == 0 or nums[mid]>nums[mid-1]):
                        #If yes, return index of mid
                        return mid
                    else:
                        #If not update high value, as we expect the first occurence exists in the left of array
                        high = mid - 1
                #To check if the mid element is greater than target then traverse towards left as we know this is a sorted array and target should exist towards left
                elif(nums[mid]>target):
                    high = mid-1
                #To check if the mid element is less than target then traverse towards right as we know this is a sorted array and target should exist towards right
                else:
                    low = mid + 1
            return -1
        
        def LastBinarySearch(nums,low,high,target):
            while(low<=high):
                mid = low+(high-low)//2
                #To check if our target exists in mid
                if(nums[mid]==target):
                    #If it exists, check if it's ending element or not
                    if(mid == len(nums)-1 or nums[mid]<nums[mid+1]):
                        return mid
                    #If not update low value, as we expect the last occurence exists in the right of array
                    else:
                        low = mid + 1
                #To check if the mid element is greater than target then traverse towards left as we know this is a sorted array and target should exist towards left
                elif(nums[mid]>target):
                    high = mid-1
                #To check if the mid element is less than target then traverse towards right as we know this is a sorted array and target should exist towards right
                else:
                    low = mid + 1
            return -1
        
        first = FirstBinarySearch(nums,0,n,target)
        #If first function returns -1 then the element doesn't exist in array
        if(first == -1):
            return [-1,-1]
        last = LastBinarySearch(nums,0,n,target)
        return [first,last]
        


        
        