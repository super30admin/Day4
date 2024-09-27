class Solution:
    def start(self,nums,target,mid) -> int :
        low1=0
        high1=mid-1
        
        
        while(low1 <= high1):
            mid1=int(low1+(high1-low1)/2)
            if(nums[mid1]== target):
                
               
                if(mid1 != low1 and nums[mid1-1] == target):
                    high1= mid1-1
                    
                    
                else:
                    print(mid1)
                    return(mid1)
            elif(target > nums[mid1]):
                low1=mid1+1
            

            elif(target< nums[mid1]):
                high1=mid1-1

    def end(self,nums,target,mid) -> int :
        low1=mid+1
        high1=len(nums)-1
        while(low1 <= high1):
            mid1=int(low1+(high1-low1)/2)
            if(nums[mid1]== target):
                
                if(mid1!=high1 and nums[mid1+1] == target):
                    low1= mid1+1
                
                else:
                    return(mid1) 
            elif(target > nums[mid1]):
                low1=mid1+1

            elif(target< nums[mid1]):
                high1=mid1-1
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low=0
        high=len(nums)-1
        out=[]
        while(low<=high):
            mid=int(low+(high-low)/2)
            if(nums[mid]== target):
                temp=mid
                print("printing temp")
                print(temp)
                if(mid != low and nums[mid-1] == target ):
                    print('mid')
                    print(mid)
                    x=self.start(nums,target,mid)
                    out.append(x)
                    print("printing out")
                    print(out)
                    
                else:
                    out.append(mid)
                    print("in this loop")
                    
                    
                if( (mid!= high) and nums[mid+1]  == target):
                    out.append(self.end(nums,target,temp))
                    print('printing in next')
                    print(out)
                    return out

                else:
                    print("in this loop[]")
                    out.append(mid)
                    return out    
            elif(target > nums[mid]):
                low=mid+1
                

            elif(target< nums[mid]):
                high=mid-1
                
            
        return [-1,-1]    



          
        