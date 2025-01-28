"""
// Time Complexity :
Problem 1 - O(log n) as we binary search reducing the size of the array
Problem 2 - O(log n) as we traverse by decreasing the size of the array
Problem 3 - O(log n) as we traverse by decreasing the size of BIG array
// Space Complexity :
Problem 1 - O(1) as the lookup for my element is just one operation
Problem 2 = O(1og n) at the start and recursively reach to O(1) since the size is decreasing by 2
and ultimately to the last element 
Problem 3 - O(log n) at the start and recursively reach to O(1)
// Did this code successfully run on Leetcode :
Yes the code submission ran successfully.
// Any problem you faced while coding this :
"""

'''// Your code here along with comments explaining your approach in three sentences only'''
# Problem 1 - Find starting and ending position of element in sorted array
# Create two functions that will return the starting and ending position indexes. Optimal path is
# where our middle element returns as the start and end position and we return it. Also edge cases
# where we get the answer directly.
# The starting position will first look at the mid element with the target and parse through the array
# until the array element is less than the target element.
# For the ending position first look for the mid element and parse through the array until the array
# element is less than the target element. 
class Solution(object):   
    def first_BinarySearch(self, nums, target):
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target: #If mid element is target return the index
                #Edge cases for the mid element
                if mid == 0 or nums[mid - 1] != target:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target: #if mid element is less than target look on the right array
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def last_BinarySearch(self, nums, target):
        low = 0
        high = len(nums) - 1    
        while(low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target: #If mid element is target return the index
                #Edge cases for the mid element
                if mid == len(nums)-1 or nums[mid + 1] != target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target: #if mid element is less than target look on the right array
                low = mid + 1
            else:
                high = mid - 1
        return -1
         
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # If the array is empty then we return [-1,-1]
        if nums == None or len(nums) == 0: return [-1,-1] 
        # If the target is less than the starting element and greater than last element
        # Since the array is sorted we can say that the element does not exist and return [-1, -1]
        if target < nums[0] or target > nums[len(nums)-1]: return[-1, -1]
        first_pos = self.first_BinarySearch(nums, target)
        # If the starting position index is -1 then our last poition is also going to be -1
        if first_pos == -1: return[-1,-1]
        last_pos = self.last_BinarySearch(nums, target)
        return [first_pos, last_pos]   

# Problem 2 - Minimum in a rotated array
# Check length of the array to cover all edge cases
# Check if the mid element is less than its neighbouring elements, return the mid element as it is
# our best case scenario.
# Continue moving either left of the array of right till so that we reduce our search space
# Finally we will have two elements where the lowest index element is less than highest index element
# We will return comparing the elements and return the lowest.
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1: return nums[0] #If length of array is 1 then return the element
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2 #find the mid element
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == low or nums[mid] < nums[mid -1]) and (mid == high or nums[mid] < nums[mid +1]): 
                #compare mid element with one element left from the mid and right element from mid
                #Also compare edges
                return nums[mid]

            if(nums[low] <= nums[mid]): #left side of the array is sorted
                low = mid +1 #we will move to right side of the array
            else:
                high = mid -1

# Problem 3 - Find peak element from array
# Check edge cases if the array is empty then return -1 or if has one element return 0
# Check if my mid element is greater than neighbouring elements then its the peak element
# If not then if the mid element is greater than mid - 1 we go to the right side of the array
# as there is a gurantee that the peak will be on the increasing number numbers rather than 
# decreasing numbers

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2
        #Optimal scenario where my mid element is the peak
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif mid == 0 or nums[mid] > nums[mid-1]: 
            #Only greater than condition fails for two elements. Hence check mid == 0
            #Move to the right side of the array
                low = mid + 1
            else:
            #Move to the left side of the array
                high = mid - 1
        return 1111
