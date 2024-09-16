#Time Complexity:
#O(log(n)) - where n is total number of elements in array

#Space Complexity:
# O(1)

#Approach:
#Execute binary search to find the pivot at each index
#We check if mid element is the pivot or if mid + 1 is the pivot 
# mid and mid + 1 both checked as sometimes pivot might be lost during shifting of low/high
# If mid and mid + 1 both are not pivots then mid - 1, mid, mid + 1 are in ascending order meaning pivot is somewhere else
# Move to whichever side is unsorted -> That side has the pivot



class Solution:
    
        
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        if nums[0] <= nums[n-1]:
            return nums[0]
        
        
        low = 0
        high = n-1
        
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] < nums [mid - 1]:
                return nums[mid]
            if nums[mid + 1] < nums[mid]:
                return nums[mid + 1]
            else:
                if nums[low] <= nums[mid]: #left side sorted and also considering duplicates
                    low = mid + 1
                else: #right side sorted
                    high = mid - 1
            
            
                    
            

                
        
            
            
            
            