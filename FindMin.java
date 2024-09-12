/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmin;

/**
 *
 * @author Samartha_Swaroop
 */
public class FindMin {
    public int findMin(int[] nums) {
    if(nums==null || nums.length==0)
        return -1;
 
    int i=0; 
    int j=nums.length;
 
    while(i<=j){
        if(nums[i]<=nums[j])
            return nums[i];
 
        int m=(i+j)/2;
 
        if(nums[m]>=nums[i]){
            i=m+1;
        }else{
            j=m;
        }
    }
 
    return -1;
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
