class Solution {
public:
    int searchLeft(vector<int>& num, int target, int low, int high){
        int mid; 
        while(low <= high){
            mid = low + (high - low)/2;
            if(num[mid] == target){
                if(mid == low || num[mid] > num[mid - 1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(num[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    
    int searchRight(vector<int>& num, int target, int low, int high){
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(num[mid] == target){
                if(mid == high || num[mid] < num[mid + 1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(num[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result;
        //If the target is on the left, keep moving left until the preceeding number becomes less than the target.
        int start = searchLeft(nums, target, 0, nums.size()-1);
        //If the target is on the right, keep moving right until the preceeding number becomes greater than the target.
        int end = searchRight(nums, target, 0, nums.size()-1);
        result.push_back(start);
        result.push_back(end);
        return result;
    }
};