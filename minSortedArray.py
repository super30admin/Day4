'''
Time Complexity -->
O(logn)

Space Complexity -->
O(1)

Approach
1. keep a low , high and mid index value
2. Check if nums[high] < nums[mid]
3. If so go to right and perform binary search and keep track of min value
4. else go to left and perform the same
'''

class Solution:
    def findMin(self, nums: List[int]) -> int:
        min_val = float('inf')
        l = 0
        h = len(nums)-1
        while l<=h:
            mid = (l+h)//2
            if nums[mid]<min_val:
                min_val = nums[mid]
            if nums[h]<nums[mid]: #the high element is smaller than mid so we have to visit the right list
                l = mid+1
            else:
                h = mid-1
        return(min_val)           #Keep track of the smallest elements
            
        