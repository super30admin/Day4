class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Defining the start and end variable
        start = 0
        end = len(nums)-1

        while (start<=end) :

            #Finding the Middle index
            mid = start+ ((end-start)//2)

            #Finding if the mid element is less than its previous one 
            #or mid equal to start index
            #and checking mid element if greater than next element 
            #or mid equal to end index return mid 
            if (( mid == start or nums[mid] > nums[mid-1] ) and  (mid == end or nums[mid] > nums[mid+1])):
                return mid
            
            #element at mid greater then element at end then move #start to right subarray
            elif nums[mid] < nums[mid-1] and mid!=0 :
                end = mid-1
            
            #Else move end to left sub array
            else:
                start = mid +1
        return -1

#This problem involves finding out the index of the element with highest value and we use binary search algorithm with time complexity O(logn).