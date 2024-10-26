# The code defines a findMin method to find the minimum element in a rotated sorted array using binary search.
# The array was initially sorted in increasing order and then rotated at some pivot, which makes finding the minimum tricky.
# The algorithm uses two pointers, 'start' and 'end', to represent the boundaries of the current search space.
# 
# In each iteration:
#   - The mid-point (mid) is calculated to divide the array in half.
#   - The current minimum value (curr_min) is updated by comparing it with nums[mid].
#   - If nums[mid] is greater than nums[end], it indicates that the minimum element lies in the right half, so the search space is adjusted by setting start = mid + 1.
#   - If nums[mid] is less than or equal to nums[end], the minimum lies in the left half, so the search space is adjusted by setting end = mid - 1.
# 
# After the loop, the method returns the minimum value by comparing curr_min with nums[start] to ensure the final minimum element is returned.
# 
# TC: O(log n) - The search space is halved in each iteration, so the time complexity is logarithmic.
# SC: O(1) - Constant space is used, as only pointers and a variable to store the current minimum are maintained.


class Solution:
    def findMin(self, nums: List[int]) -> int:
        start , end = 0, len(nums) - 1 
        curr_min = float("inf")
        
        while start  <  end :
            mid = start + (end - start ) // 2
            curr_min = min(curr_min,nums[mid])
            
            # right has the min 
            if nums[mid] > nums[end]:
                start = mid + 1
                
            # left has the  min 
            else:
                end = mid - 1 
                
        return min(curr_min,nums[start])
    