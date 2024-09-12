/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;
import java.io.*; 

/**
 *
 * @author Samartha_Swaroop
 */
public class Solution {
    public int[] searchRange(int nums[], int target) 
    { 
        int n = nums.length; 
        int first = -1, last = -1; 
        for (int i = 0; i < n; i++) { 
            if (target!= nums[i]) 
                continue; 
            if (first == -1) 
                first = i; 
            last = i; 
        } 
        if (first != -1) { 
            System.out.println("First Occurrence = " + first); 
            System.out.println("Last Occurrence = " + last); 
        } 
        else {
            System.out.println("Not Found"); 
    
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
