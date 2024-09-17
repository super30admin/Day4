class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Defining the start and end variable
        start = 0
        end = len(nums)-1

        while (start<=end) :
            #if element at start index less than the one at end return start element
            if nums[start] <= nums[end]:
                return nums[start]
            #Finding the Middle index
            mid = start+ ((end-start)//2)

            #Finding if the mid element is less than its previous one 
            #or mid equal to start index
            #and checking mid element if greater than next element 
            #or mid equal to end index return mid 
            if ((nums[mid] < nums[mid-1] or mid == start) and  (nums[mid]<nums[mid+1] or mid == end)):
                return nums[mid]
            
            #element at mid greater then element at end then move #start to right subarray
            elif nums[mid]>nums[end]:
                start = mid+1
            
            #Else move end to left sub array
            else:
                end = mid-1
        return -1

#This problem involves finding the min element from the sorted array
#using binary search algorithm to find out the minimum in the array 
#with time complexity O(logn).