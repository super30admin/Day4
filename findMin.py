
#Time Complexity=O(log n)
#Space Complexity=O(1)
# Diffciulties faced: I am using min() here , does that affect the time complexity?

# This algorithm is same as search.py submitted in Binary search -1  but instead of teh target I am replacing the target by min(nums) and instead of returning mid index, I am  returning the element present at that index

#1. Set low and high index of the array as 0 and length of array -1.
#2. Calcualte mid index.
#3. if the mid value is equal to min(nums), check if the its preceding value is equal to min(nums) or not so that we can confine our search space towards left and also check if mid is the 0th element (for the case where min(nums) is present at 0th index).
# If yes, then we return the mid, else we check if the min(nums) id greater or lesser then min(nums) and confine our search space as such by moving our low and high pointers.
# 4 Otherwise, we return -1 , ie if min(nums) is not found.
#5. Same procedure is followed for looking for last index.




class Solution:
    def findMin(self, nums: List[int]) -> int:
    #     class Solution:
    # def search(self, nums: List[int], target: int) -> int:
        r=len(nums)-1
        l=0
        if not nums:
            return -1
        
        while l<=r:
            mid=l+(r-l)//2
            if nums[mid]==min(nums):
                return nums[mid]
            if nums[l]<=nums[mid]:
                if nums[l]<=min(nums)<=nums[mid]:
                    r=mid-1
                else:
                    l=mid+1
            elif nums[r]>=nums[mid]:
                if nums[r]>=min(nums)>=nums[mid]:
                    l=mid+1
                else:
                    r=mid-1
                    
        return -1
#Time Complexity=O(log n)
#Space Complexity=O(1)


#Implementing the code withpout using min()
#1. As usual, calcualte the mid index value by taking low and high index.
#2. Now check if the mid element is greater then the last element in the array.
# If yes, this means that we can find smaller elements towards the right of the mid element hence we set our low index to mid+1.
# If no we set our high index to mid.
# We return the element present at index of the low index.




class Solution:
    def findMin(self, nums: List[int]) -> int:
    #     class Solution:
    # def search(self, nums: List[int], target: int) -> int:
        r=len(nums)-1
        l=0
        if not nums:
            return -1
        
        while l<r:
            mid=l+(r-l)//2
            if nums[mid]<nums[r]:
                r=mid
            else:
                l=mid+1
                    
        return nums[l]
