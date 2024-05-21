# Time Complexity :

# O(LOG(N)) , binary search algorithm


# Space Complexity :  

# O(1), since you are just searching, not creating new matrix/array


# Approach:
# Start with left and right pointer and recursively divide the search range 
# based on the mid value comparison with its neighbors, 
# then do binary search in direction of increasing values

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0 or not nums:
            return 0
        left = 0 
        right = len(nums)-1

        while(left<=right):
            mid = (left + right) // 2
             
            # check if mid element is greater than its neighbors
            if (mid==0 or nums[mid] > nums[mid-1]) and (mid==len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            
            # else mbinary search in the direction of increasing values
            elif nums[mid+1] > nums[mid]:
                left = mid+1
            else:
                right = mid-1
            
        return 0