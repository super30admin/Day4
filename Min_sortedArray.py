#153. Find Minimum in Rotated Sorted Array
#Time Complexity: O(log n)
#sapce Complexity : O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if(nums == None or len(nums) == 0):
            return -1
      
        low = 0
        high = len(nums) - 1
        
        while(low<=high):
            #checking  for the sorted case
            if(nums[low] < nums[high]):
                return nums[low]
           
        #now checking for rotated case : the minimum will be in the unsorted side always
           
            mid = int(low+(high-low)/2)
           
            if((mid == len(nums)-1 or (nums[mid] < nums[mid+1])) and (mid == 0 or (nums[mid] < nums[mid-1]))):
                return nums[mid]
            elif(nums[mid] < nums[high]):
                high = mid - 1
            else:
                low = mid + 1
                
        return -1
            
                
            