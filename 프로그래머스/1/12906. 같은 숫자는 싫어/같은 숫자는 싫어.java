import java.util.*;

public class Solution {
    public LinkedList<Integer> solution(int []arr) {
        
   
        LinkedList<Integer> q = new LinkedList();
        
        q.add(arr[0]);
        for(int i =1 ; i< arr.length;i++){
            int last = q.getLast();
            int now = arr[i];
            
            if(now != last){
                q.add(now);
            }
            
        }
        
        // int[] answer = new int[q.size()];
        
       
        
        
        
 
        return q;
    }
}