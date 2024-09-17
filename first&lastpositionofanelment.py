#Time Complexity : O(log N)

class Solution:
    
    def searchleft(self, nums: List[int], target: int) -> int:
            low =0
            high =len(nums) -1
            while(low<=high):
    
                mid = low + (high-low)//2
                if(nums[mid] == target): 
                 #             to check if mid is the first index
                    if(mid==0 or nums[mid-1]!= nums[mid]):return mid
                    else:
                        high = mid -1
                elif(nums[mid]>target):
                    high = mid -1
                else:
                    low = mid+1
                
            return -1
                
                
    def searchright(self, nums: List[int], target: int) -> int:
            low =0
            high =len(nums) -1
            mid = low + (high-low)//2
            while(low<=high):
    
                mid = low + (high-low)//2
                if(nums[mid] == target): 
                #             to check if mid is the first index
                    if(mid==len(nums)-1 or nums[mid]!= nums[mid+1]):return mid
                    else:
                        low = mid +1
                elif(nums[mid]>target):
                     high = mid -1
                else:
                    low = mid+1
                
            return -1
        
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(nums==None or len(nums)==0): return [-1,-1]
        return [self.searchleft(nums,target), self.searchright(nums,target)]
        
           
    
         
        
        

        