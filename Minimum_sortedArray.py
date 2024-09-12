#Time Complexity: O(log(n)), since binary search is used.
# Space Complexity :O(1), as no extra space is used apart from some variables.
# This question is checked on leetcode 

class Solution:
    def findMin(self, arr: list) -> int:
        start = 0
        end = len(arr) - 1
        if arr[start]<=arr[end]: # if the first element is minimum
            return arr[start]
        else:
            while(start<=end):
                mid = int(start + (end-start)/2) # calculate middle index
                if arr[mid]< arr[mid-1]: # if the mid element is minimum
                    return arr[mid]
                if arr[mid]> arr[mid+1]:
                    return arr[mid+1]
                if arr[mid] > arr[0]:# check right array
                    start = mid + 1
                else: # check left array
                    end = mid - 1