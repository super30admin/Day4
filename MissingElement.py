class Solution:
    def findMissingElement(self, nums):
        low=0
        high=len(nums)-1
        if(len(nums)==1):
            return "Nothing Missing"
            
        mid=(low+high)//2
        if(nums[mid]-mid==1):
            return "Nothing Missing"
        while(low<=high):
            mid=(low+high)//2
            if (mid==len(nums)-1 or nums[mid+1]-nums[mid]>1) and (mid==0 or nums[mid+1]-nums[mid]>1):
                return mid+2
            
            #go towards the left hand side..
            elif mid>0 and nums[mid]-mid==2:
                high=mid-1
            else:
                low=mid+1
                    
sol=Solution()
print(sol.findMissingElement([1,2]))
