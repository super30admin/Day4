#Time Complexity: O(log n)
#Space Complexity: O(1)

class Solution(object):
        
        #Binary search in the first half of the array
        def binarySearchFirst(nums, target):
            low = 0
            high = len(nums)-1
            
            while (low <= high):
                mid = low + (high - low)//2
                if target == nums[mid]: #checking if target is the value at mid
                    if (mid == 0) or (nums[mid] > nums[mid-1]): #since sorted array, true here means start index of target will not exist before mid
                        return mid  #true condition stated mid is the start position
                    else:
                        high = mid - 1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
                    
        
        #search the second half for last position          
        def binarySearchLast(nums, target):
            low = 0
            high = len(nums)-1
            
            while (low <= high):
                mid = low + (high - low)//2
                if target == nums[mid]: #checking if target is the value at mid
                    if (mid == len(nums)-1) or (nums[mid] < nums[mid+1]): #since sorted array, true here means start index of target will not exist before mid
                        return mid  #true condition stated mid is the start position
                    else:
                        low = mid + 1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
        
        #search for the range 
        def searchRange(self, nums, target):
            if (nums == None) or (len(nums) == 0):
                return (-1,-1)
            if (target < nums[0] or target > nums[len(nums) - 1]):
                return (-1,-1)
            
            firstIndex = Solution.binarySearchFirst(nums, target)
            lastIndex = Solution.binarySearchLast(nums, target)
            
            return (firstIndex, lastIndex)
