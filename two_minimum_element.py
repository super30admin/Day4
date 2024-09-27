class Solution:
    def findMin(self, nums):
        low = 0
        high = len(nums) - 1
        '''
        Simple binary search where we see if mid element is less than the element at highest pointer.
        If it is true then we adjust our high pointer to mid such that it comes to mid 
        else, we make low to point to mid+1 element until we finish traversing loop and hence return low pointer
        '''
        while low < high:
            mid = (low + high) // 2

            if nums[mid] < nums[high]:
                high = mid
            else:
                low = mid + 1

        return nums[low]


minimum_element = Solution()
print(minimum_element.findMin([4,5,6,7,0,1,2]))
print(minimum_element.findMin([11,13,15,17]))

'''
time complexity O(log(n)) - n is the number of elements in array
space complexity O(1) - no auxillary space used
'''