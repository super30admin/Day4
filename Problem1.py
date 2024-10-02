# nums = [5,7,7,8,8,10], target = 8  OUTPUT = [3,4]
# nums = [5,7,7,8,8,10], target = 6  OUTPUT = [-1,-1].. Same for empty array
nums = [5,7,7,8,8,8,9,9,10,10,10,10,11,11,11,12,13,13,14,14]
class Solution:
    def binary_search(self, nums, low, high, target):
        while low <= high:
            
            mid = (low + high) // 2
            if nums[mid] == target:
                #print("Mid is ", mid)
                low, high = mid, mid
                
                while low >= 0 and nums[low] == target:
                    low -= 1
                
                while high <= len(nums)-1 and nums[high] == target:
                    high += 1
                
                return mid, low+1, high-1 
                
            elif nums[mid] < target:
                return self.binary_search(nums, mid+1, high, target)
            
            else:
                return self.binary_search(nums, low, mid-1, target)
        
        if (low > high):
            return -1,-1,-1
    
    def searchRange(self, nums, target: int):
        high = len(nums) - 1
        mid, low, high = self.binary_search(nums, 0, high, target)
        output = []
        output.append(low)
        output.append(high)
        return output
        
        
s1 = Solution()
print(s1.searchRange(nums, 5))
print(s1.searchRange(nums, 8))
print(s1.searchRange(nums, 12))
print(s1.searchRange(nums, 14))
print(s1.searchRange(nums, 24))
