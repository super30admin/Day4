'''#brute force: time comp- O(n)
#space comp-O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        for i in range(0,len(nums)-1):
            if nums[i+1] < nums[i]:
                return i
        return len(nums)-1
'''                
#Efficient Approach:
#time-comp : O(logn)
#space comp : O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        while l<=h:
            mid=(l+h)//2
            #check if peak value found
            if (mid==0 or nums[mid]>=nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>=nums[mid+1]):
                return mid
             # if peak is on left side
            if mid!=0 and nums[mid]<=nums[mid-1]:
                h=mid-1
            #if peak on right side
            else:
                l=mid+1
        return -1
           
          
                
            


            
        
