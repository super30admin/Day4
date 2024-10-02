# TC and SC = O(logn)

#4,5,6,7,8,9,0,1 - left sorted
#0,1,2,3,4,5,6,7 -
#8,9,0,1,2,3,4,5 - right sorted
class Solution:
    def binary_search(self, nums, low, high):
        while low < high:
            
            mid = ( low + high ) // 2
            
            if nums[mid] < nums[mid-1] and nums[mid] <= nums[mid+1]:
                return nums[mid]

            elif nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return nums[mid+1]

            elif nums[low] <= nums[mid]: #left sorted array
                low = mid + 1
                
            else: #right Sorted
                high = mid
        
        return nums[low]
                
    def findMin(self, nums) -> int:
        high = len(nums)-1
        low = 0

        if high == 0:
            return nums[0]

        if nums[low] < nums[high]:
            return nums[low]
        
        if len(nums) - 1 < 2:
            if nums[0] < nums[1]:
                return nums[0]
            else: 
                return nums[1]
        
        minimum = self.binary_search(nums, low, high)
        return minimum
  
    
arr1 = [4,5,6,7,8,9,0,1]
arr2 = [8,9,0,1,2,3,4,5]
arr3 = [3,1,2]
s1 = Solution()
print(s1.findMin(arr1))
print(s1.findMin(arr2))
print(s1.findMin(arr3))
print(s1.findMin([2,1]))
print(s1.findMin([2,3,1]))
