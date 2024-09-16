class Solution:
    def findMin(self, A):

        left=0
        right= len(A)-1
        result = -1
        while left < right:

            mid = (left + right)//2

            if A[mid] < A[-1]:

                result = mid

                right = mid - 1

            else:

                left = mid + 1

        return(result)


"""
Time complexity: O(log n)
Space Complexity: O(1)


First, the range is search is found by comparing the middle element with the last and the first element
Binary search concept implemented.

"""
