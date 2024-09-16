class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]: 
        if nums==None and len(nums)==0:
            return [-1,-1]

        def find_first_index(nums,target):
            l=0
            h=len(nums)-1
            while l<=h:
                mid=l+(h-l)//2
                if nums[mid]==target:
                    if target!=nums[mid-1] or mid==0:
                        return mid
                    h=mid-1
                elif target>nums[mid]:
                    l=mid+1
                else:
                    h=mid-1
            return -1
        def find_last_index(nums,target):
            l=0
            h=len(nums)-1
            while l<=h:
                mid=l+(h-l)//2
                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid+1]!=target:
                        return mid
                    l=mid+1
                elif target>nums[mid]:
                    l=mid+1
                else:
                    h=mid-1
            return -1
        first=find_first_index(nums,target)
        if first==-1:
            return [-1,-1]
        last=find_last_index(nums,target)
        return [first,last]


