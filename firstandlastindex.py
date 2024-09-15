# Time complexity - O(logn)
# Space complexity - O(1)

# Ran on Leetcode - Yes


class Solution:
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        final = [-1,-1]
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            
            mid = (left + right)//2
        
            
            if nums[mid] == target:
                final = [mid,mid]
                self.binarySearch(nums,left,mid-1,target,final,index=0,side="left")
                self.binarySearch(nums,mid+1,right,target,final,index=1,side="right")
                break
                
            elif nums[mid] > target:
                # left side
                right = mid-1
            
            else:
                # right side
                left = mid+1
            
        return final
            
    def binarySearch(self, nums, left, right,target,final,index,side="left"):
        mid = left + (right-left)//2
        if left<=right:
        
            if side == "left":

                if nums[mid] == target:
                    
                    final[index] = mid
                    self.binarySearch(nums,left,mid-1,target,final,index=index,side="left")
                elif nums[mid] < target:
                    self.binarySearch(nums,mid+1,right,target,final,index=index,side="left")

            elif side == "right":
                
                if nums[mid] == target:
                    final[index] = mid
                    
                    self.binarySearch(nums,mid+1,right,target,final,index=index,side="right")
                elif nums[mid] > target:
                    self.binarySearch(nums,left, mid-1,target,final,index=index,side="right")
                    


