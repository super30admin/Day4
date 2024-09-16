"""
Problem 2: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0

"""

    def findMin(self, nums):
        """
        find the min element in the rotated list
        Itype: list
        rtype: min_val(int)
        """
        if nums == []:
            return 
        
        min_val = float("inf")
        
        l,h = 0, len(nums) -1
        while (l<=h):
           
            mid = (l+h)//2
            
            if min_val >= nums[mid]:
                min_val = nums[mid]
                
            #Checking the mid value with last element
            if nums[mid] < nums[h]:
                h = mid -1
            else:
                l = mid +1
                
        return min_val

    #   Time Complexity: O(log n), where n is the number of elements in the list
    #   Space Complexity: O(1)