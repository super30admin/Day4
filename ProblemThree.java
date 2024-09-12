/*Question :Given an integer array sorted in ascending order, write a function to searchtargetinnums. 
Iftargetexists, then return its index, otherwise return-1.However, the array size is unknown to you. 
You may only access the array using anArrayReader interface, 
where ArrayReader.get(k)returns the element of the array at indexk (0-indexed)

Timecomplexity:O(log(N))
Spacecomplexity:O(1)
Does it successfully run on leetcode:Yes




*/
public class ProblemThree {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1; //searching the target range 
        while(reader.get(high)<target){
            low=high;
            high*=2;
        }
        // by the end of the while loop we get the range of target and then we do a simple binary search to get the index of the target.
       while(low<=high){
           int mid=low+(high-low)/2;
           if(reader.get(mid)==target){
               return mid;
           }
           else if(reader.get(mid)<target){
                low=mid+1;
           }
           else{
               high=mid-1;
           }
       }
        return -1;
    }
   
}
