# Time Complexity :

# O(LOG(N)) , binary search algorithm


# Space Complexity :  

# O(1), since you are just searching, not creating new matrix/array


# Approach:
# Start with left and right pointer and recursively divide the search range 
# based on the mid value comparison with target value, to find first and last position of the target value

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums or len(nums)==0:
            return [-1,-1]

        first = self.binarySearchFirst(nums,target)

        # if you didn't find first index, then indeed there is no "target" element present
        if(first == -1):
            return [-1, -1]
        
        # find the last index of "target" element
        last = self.binarySearchLast(nums, target)
        
        # return the indices
        return [first, last]
    

    def binarySearchFirst(self,nums, target):
        left = 0
        right = len(nums)-1
        while(left <= right):
            # check if the mid element is equal to target and is the first index of that "target" element
            mid = (left + right) // 2
            # check if the mid element is the first index
            if nums[mid] == target:
                if (mid==0 or nums[mid-1] != target) :
                    return mid
                right = mid-1
            elif nums[mid] > target:
                right = mid-1
            else:
                left = mid+1
        return -1


    def binarySearchLast(self,nums, target):
        left = 0
        right = len(nums)-1
        while(left <= right):
            # check if the mid element is equal to target and is the last index of that "target" element
            mid = (left + right) // 2
            # check if the mid element is the last index
            if(nums[mid] == target):
                if (mid==len(nums)-1 or nums[mid+1] != target):
                    return mid
                left = mid +1
            elif nums[mid] > target:
                right = mid-1
            else:
                left = mid+1
        return -1