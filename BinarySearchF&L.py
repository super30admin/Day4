class Solution:
    def binarySearchF(self,arr,t):
        l=0
        h=len(arr)-1
        while l<=h:
            mid=(l+h)//2
            if arr[mid]==t:
                if mid==0 or arr[mid]>arr[mid-1]:
                    return mid
                else:
                    h=mid-1
            elif arr[mid]>t:
                h=mid-1
            else:
                l=mid+1

        return -1

    def binarySearchL(self,arr:List[int],l:int,h:int,t:int)->int:
        while l<=h:
            mid=(l+h)//2
            if arr[mid]==t:
                if mid==h or arr[mid]<arr[mid+1]:
                    return mid
                else:
                    l=mid+1
            elif arr[mid]>t:
                h=mid-1
            else:
                l=mid+1
        return -1


    def searchRange(self, nums: List[int], target: int) -> List[int]:#O(log n)
        if nums==None or len(nums)==0:return [-1,-1]
        if nums[0]>target or nums[len(nums)-1]<target:return [-1,-1]
        first=self.binarySearchF(nums,target)
        if first==-1:return [-1,-1]
        else:
            last=self.binarySearchL(nums,first,len(nums)-1,target)
            return [first,last]
