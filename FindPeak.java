//This problem can be solved by observing the fact that we would land on one of the peak elements by reducing the array towards the element that has the greater element than the middle element and use binary search to find the peak element. 
// The time complexity for this problem would be O(logn)
// The space complexity for this problem would be O(1)

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int l=0, h = nums.length-1,m;
        while(l<h){
            m = l+(h-l)/2;
            if(
                ((m ==0 || nums[m]>nums[m-1]) && (nums[m]>nums[m+1]))
                || 
                ((m==h || nums[m]>nums[m+1]) && nums[m] > nums[m-1])
            ){
                return m;
            }
            else if(nums[m]<nums[m+1]){
                l = m+1;
            }
            else{
                h=m-1;
            }
        }
        return l;
    }
}
