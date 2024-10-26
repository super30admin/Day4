#// Time Complexity : O(log(n))
#// Space Complexity : O(1)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : Edge(0,n-1) condition is confusing.


#// Your code here along with comments explaining your approach in three sentences only

# TO find smallest term in a rotated array we can use binary search.
# but first we el;iminate the conditions we can use to make it run faster. (no rotation array)
# We can check if neighbours are smaller that m or not in the binary search. m-1 and m-1 (Alternative m-1 , m)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n-1
        
        while low <= high:
            
            if nums[low] <  nums[high]:         #No rotation array
                return nums[low]
                                                #For rotated array we take mid for binary search
            mid = low + (high - low)//2
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == n-1 or nums[mid+1]  > nums[mid]): #eleminate neighbours, -1 and n conditions 
                return nums[mid]
            elif nums[high] < nums[mid]: #check right. Left sorted
                low = mid + 1
            else:
                high = mid -1
        
        return -1
    
# Eliminate edges and neighbour condition
# class Solution:
#     def findMin(self, nums: List[int]) -> int:
#         n = len(nums)
#         low = 0
#         high = n-1
        
#         while low < high:                #Simple Binary
#             mid = low + (high - low)//2
#             if  nums[mid] > nums[high] : #right sorted
#                 low = mid + 1
#             else:
#                 high = mid               # boss condition 
#         return nums[low]