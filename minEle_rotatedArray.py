"""Time complesxity: O(log n)
space complexity: O(1)
Successfully excecuted on leetcode

approach:
Binary Search
1. Find the mid element.
2. Base case - when last element is greater than first element; smallest = first element
2. If mid>mid+1, mid+1 is smallest
3. If mid<mid-1, mid is smallest
4. If mid>first element, we need to look into right half
5. If mid<first element, we need to look into left half

"""

class Min_element_rotated_array:
    def findMin(self, nums):

        if len(nums) == 1:
            return nums[0]

        left = 0
        right = len(nums)-1

        if nums[-1] > nums[0]: #when last element is greater than first element, there is no rotation
            return nums[0]

        while right >= left:
            mid = left+(left-right) // 2

            if nums[mid]>nums[mid+1]: #if mid point greater than mid+1 element, array is rotated so mid+1 smallest element
                return nums[mid+1]

            if nums[mid-1] > nums[mid]: #if mid element is lesser than its prev element mid is smallest
                return nums[mid]

            if nums[mid] > nums[0]: # minimum value in right
                left = mid +1

            else :
                right = mid -1 # minimum in left