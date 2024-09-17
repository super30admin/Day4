'''Time-complexity - O(logn)
Space Complexity - O(1)'''
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        def binarySearch(nums,target,flag):
            low = 0
            high = len(nums)-1
            
            while(low<=high):
                mid = low+((high-low)//2)
                if(nums[mid]==target):
                    if(flag):
                        if(mid==0 or nums[mid]>nums[mid-1]):
                            return mid
                        else:
                            high = mid-1
                    else:
                        if(mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                            return mid
                        else:
                            low = mid+1
                elif(nums[mid]>target):
                    high = mid-1
                else:
                    low = mid+1
            return -1
        
        first = binarySearch(nums,target,1)
        if(first==-1):
            return [-1,-1]
        last = binarySearch(nums,target,0)
        
        return [first,last]
            