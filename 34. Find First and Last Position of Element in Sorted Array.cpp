//Time Complexity = O(log n)
//Space Complexity = O(1)

class Solution {
public:
int firstindex(vector<int>& a,int n,int x)
{
    int low=0,high=n-1,mid;
    while(low<=high)
    {
        mid=low+(high-low)/2;
        if(a[mid]==x)
            if(mid==0 || a[mid-1]<x)
                return mid;
        if(a[mid]<x)
            low=mid+1;
        else
            high=mid-1;
    }
    return -1;
}
    
int lastindex(vector<int>& a,int n,int x)
{
    int low=0,high=n-1,mid;
    while(low<=high)
    {
        mid=low+(high-low)/2;
        if(a[mid]==x)
            if(mid==n-1 || a[mid+1]>x )
                return mid;
        if(a[mid]<=x)
        low=mid+1;
        else
        high=mid-1;
    }
    return -1;
}
    
vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans;
        ans.push_back(firstindex(nums,nums.size(), target));
        ans.push_back(lastindex(nums,nums.size(), target));
        return ans;
    }
};
