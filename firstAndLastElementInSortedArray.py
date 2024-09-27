class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if not nums:
            return [-1,-1]
        
        elif target<nums[0] or target>nums[len(nums)-1] :
            return [-1,-1]
        

        solution = [-1,-1]
        low, high = 0, len(nums)-1
        flag = False
        while low<=high and not flag:

            mid = (low+high)//2

            if target == nums[mid]:
                if mid==0 or target != nums[mid-1]:
                    flag = True
                    solution[0]= mid 
                else:
                    high = mid-1
                
            elif target < nums[mid]:
                high = mid -1
                
            else:
                low = mid + 1

        flag = False
        if solution[0]!=-1:
            low, high = 0, len(nums)-1

            while low<=high and not flag:

                mid = (low+high)//2

                if target == nums[mid]:
                    if mid == len(nums)-1 or target != nums[mid+1]:
                        flag = True
                        solution[1]=mid
                    else:
                        low = mid+1

                elif target < nums[mid]:
                    high = mid -1
                else:
                    low = mid + 1


        return solution
    
#  Time complexity is 2 x log n ~ log n as we are running binary search twice
#  Approach we are taking is to run binary search twice, once for lowest index and once for highest index
        
    
        
        
