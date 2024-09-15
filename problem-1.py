#time comp- O(logn) 
#space comp-O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #check for first occurance
        first=self.binarySearch(nums,target,False)
        #check for seconf occurance
        last=self.binarySearch(nums,target,True)
        return [first,last]
    def binarySearch(self,nums,target,ifLast):
        l=0
        h=len(nums)-1
        while l<=h:
            #calculate mid
            mid=(l+h)//2
            if nums[mid]==target:
                #first
                if ifLast==False:
                    if mid!=0 and nums[mid]==nums[mid-1]:
                        h=mid-1
                    else:
                        return mid
                    
                #second
                else:
                    if mid!=len(nums)-1 and nums[mid]==nums[mid+1]:
                        l=mid+1
                    else:
                        return mid
            elif nums[mid]>target:
                h=mid-1
            else:
                l=mid+1
        return -1
        
                    
        
