
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        return [findFirstOccurrence(nums, target), findLastOccurrence(nums, target)]

    
def findFirstOccurrence(nums, target):
    # Setting start and end variables
    start, end = 0, len(nums) - 1

    # Defining first occurance variable
    firstOccurrence = -1

    while start <= end:
        # Finding the Middle index
        mid = start + ((end - start) // 2)

        #If target equals to element at the mid index
        if target == nums[mid]:
            firstOccurrence = mid
            end = mid - 1
        # If the target is less than the element
        # at the middle index
        elif target < nums[mid]:
            end = mid - 1
        # If the target is greater than the element
        # at the middle index
        else:
            start = mid + 1
    return firstOccurrence


def findLastOccurrence(nums, target):
    # Setting start and end variables
    start, end = 0, len(nums) - 1

    # Defining last occurance variable
    lastOccurrence = -1

    while start <= end:
        # Finding the Middle index

        mid = start + (end - start) // 2

        #If target equals to element at the mid index
        if target == nums[mid]:
            lastOccurrence = mid
            start = mid + 1
        # If the target is less than the element
        # at the middle index
        elif target < nums[mid]:
            end = mid - 1
        # If the target is greater than the element
        # at the middle index
        else:
            start = mid + 1
    return lastOccurrence


#This problem involves finding the first and last occurance 
# of the target variable implemented using binary search algorithm 
# with two function for finding each first and last occurance
# with time complexity being O(logn). 