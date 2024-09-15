class Solution:
    def findPeakElement(self, nums):
        low = 0
        high = len(nums) - 1
        while low<= high:
            mid = low + (high-low)//2 # calculating mid
            if ((mid == high or nums[mid] > nums[mid + 1]) and (mid == low or nums[mid] > nums[mid - 1])):
                '''
                if both right and left elemnts of mid are lesser than 
                mid then we found our peak as mid.
                and if an element has just one neighbour and which is less than itself 
                then also we found peak.
                '''
                return mid
            elif (mid == high or nums[mid] < nums[mid + 1]):
                # if one of the element is greater than mid then move towards
                # that higher element and find peak in that part.
                low = mid + 1
            else: high = mid - 1