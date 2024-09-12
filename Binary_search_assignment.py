class Solution5:

    # Algorithm -Search in Rotated Sorted Array
    # 1: check if the left part of list sorted or right part of listed is sorted
    # 2: check if target isin sorted list. 
    # 3:                             if  yes  -->binary search 
    #                                else:
    #                                       move the low pointer to mid+1 if target not in left sorted list
    #                                       move the high pointer to mid-1 if target not in right sorted list

    #Complexity: Time complexity: O(log(n))
    #            Space complexity: O(1)  
    def search(nums, target):
            length=len(nums)

            if length == 0: return-1
            if (length==1) & (nums[0]==target): return 0

            low=0
            high=length-1
            while low<=high:
                mid=low+(high-low)//2
                print(low,high,mid)
                if nums[mid] ==target:
                    return mid
                else:
                    if nums[low]<=nums[mid]: #left sorted

                        if (nums[low]<= target) &(target < nums[mid]):
                            high=mid-1
                        else:
                            low=mid+1
                    else:
                        if (nums[mid]< target) &(target <= nums[high]): #right sorted
                            low=mid+1
                        else:
                            high=mid-1
            return -1


#finding a target element in a sorted array of unknown length size.
# Algorithm
# 1. start with low=0,high=1. Search if nums[high] < target: if yes that means target is not within (low,high)
# 2. Increment the size of search space by Low=high,high=2*high
# 3. Once within the range regular binary bearch. If present return index else -1

#Complexity: Time complexity: O(log(n))+O(log(m)) 
#                             m is number is elements in normal binary search after finding the range
#            Space complexity: O(1)  
class Solution6:
    def findmin_unknownlength(nums,target):
        if len(nums)==0:
            return -1
        if (length==1) & (nums[0]==target): return 0

        low=0
        high=len(nums)-1

        while nums[high]<target:
            low=high
            high=2*high

        while low<=high:
            mid=low+(high-low)/2

            if nums[mid]==targte:
                return nums[mid]
            else:
                if nums[mid]<target:
                    low=mid+1
                else:
                    high=mid-1
                    
 class Solution7:
    # Algorithm -Search left and right index in Sorted Array
    # 1: Do binary search to find left most index of target by m0ving the high pointer closer to left
    #                             Base condition to return index is the target > nums[left_index-1]  
    # 2:                          right most index of target by moving the low pointer closer to right
    #                             Base condition to return index is the target < nums[right_index+1]                                       

    #Complexity: Time complexity: O(log(n))
    #            Space complexity: O(1)
    def binarysearchleft(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            # print(low,high,mid)
            if (nums[mid]==target):
                if (mid==0) or (nums[mid-1]<nums[mid] ):
                    return mid
                else:
                    high=mid-1
            else:
                if nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
        return -1

    def binarysearchright(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if (nums[mid]==target):
                if (mid==high) or (nums[mid]<nums[mid+1]):
                    return mid
                else:
                    low=mid+1
            else:
                if nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1

        return -1

        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        length=len(nums)

        if length == 0: return [-1,-1]
        if (length==1):
                if (nums[0]==target):
                    return [0,0]
                else:  
                    return [-1,-1]

        left=self.binarysearchleft(nums,target)
        right=self.binarysearchright(nums,target)
        return [left,right]
        
			
class Solution8:
#Algorithm:
# 1. check if the list is sorted if yes return low
#    check if mid is minimum element
# 2. The pivot mostly lies in unsorted part of the array
# 3. go to unsorted part of list 
#                        right unsorted = nums[mid]>nums[high] move low=mid+1
#                        left unsorted  = nums[mid]<nums[low]  move high=mid-1
#     Complexity: Time complexity: O(log(n))
#                 Space complexity: O(1)
    def findMin(nums):
            if len(nums)<=1:
                return nums[0]

            low=0
            high=len(nums)-1

            while low<=high:

                if nums[low]<nums[high]:
                    return nums[low]

                mid=low+(high-low)//2

                if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                        return mid

                else:
                    if nums[mid]>nums[high]: #right is unsorted
                        low=mid+1
                    else:
                        high=mid-1
		
class Solution9:
# Algorithm - Find mid and check if its peak
# 1: Intution is that the peak will be lying in the increasing part of list when mid value is compare to its neighbhours  
# 2: mid> mid+1 then move high to mid-1 else move low to mid+1

#Complexity: Time complexity: O(log(n))
#            Space complexity: O(1)
    def findPeakElement(self, nums: List[int]) -> int:
        
        low=0
        high=len(nums)-1
        
        while low<=high:
            
            mid=low+(high-low)//2
            
            if (mid==0 or nums[mid]>nums[mid-1])&(mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            else:
                if nums[mid]>nums[mid+1]:
                    high=mid-1
                else:
                    low=mid+1
        
        
