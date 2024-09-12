'''
Time complexity : O(logn (base2)) as we are eleminating half space in each iteration 
Space complexity : O(1) as we are only storing 3 var at a time (low,high,mid) 

Approch : 
first we search for the target element in the list 
after getting the index of target:
    check if the index is 0 : then this one is first occurance
    else check if the previous element smaller than this : then this is the first occurnce
    else: 
        we do binary serach in the left half to find the first occurance 
        we make low = 0 and high = mid - 1 :
            we check is the mid is 0: then mid is first occurance 
            we check is the previous element is samller than this: then this is the first occurance
            else we do low = mid + 1
    
        do same for last occurce by serching it in right side of the target (mid + 1, n-1)
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 : return [-1,-1]
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high -low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid -1]:
                    l = mid
                else: l = self.findleft(nums,mid,target)
                if mid == len(nums)-1 or nums[mid] < nums[mid + 1]:
                    r = mid
                else: r = self.findright(nums,mid,target)
                return [l,r]
            if target < nums[mid]:
                high  = mid - 1
            else:
                low = mid + 1
                
        if low > high:
            return [-1,-1]
    
    
    def findleft(self,nums,mid,target):
        low = 0
        high = mid - 1
        while low<=high:
            mid = low + (high -low)//2
            if nums[mid] == target and (mid == 0 or nums[mid-1] <nums[mid]):
                return mid
            if target <= nums[mid]:
                high = mid-1
            else:
                low = mid + 1
                
    def findright(self,nums,mid,target):
        n = len(nums)
        low = mid + 1
        high = n-1
        while low<=high:
            mid = low + (high -low)//2
            if nums[mid] == target and (mid == n-1 or nums[mid] < nums[mid + 1]):
                return mid
            if target < nums[mid]:
                high = mid-1
            else:
                low = mid + 1
    
            