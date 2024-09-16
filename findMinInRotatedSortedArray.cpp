class Solution {
public:
    
    int  bsearch(vector<int>nums,int start,int end)
    {
        
        if(end<start)//the array in not rotated at all
        {
            return nums[0];
        }
        
        if(end==start)//the last element is the min element eg:-   5 4 3 2 1
        {
            return nums[start];
        }
        
        int mid=start+(end-start)/2;
        if(mid<end && nums[mid]>nums[mid+1])//the next element is the smallest 
        {
            return nums[mid+1];
        }
        else if(mid>start && nums[mid]<nums[mid-1])//the mid element is the smallest
        {
            return nums[mid];
        }
        
        if(nums[end]>nums[mid]) //condition for binary search
            return bsearch(nums,start,mid-1); 
            return bsearch(nums,mid+1,end);
        
    }
    int findMin(vector<int>& nums)
    {    
        int start=0;
        int end=nums.size()-1;
       return bsearch(nums,start,end);   
    }
};