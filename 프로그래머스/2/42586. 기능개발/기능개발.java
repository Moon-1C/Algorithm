import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        int THRESHHOLD = 100;
        
        
        
        List<Integer> answer = new ArrayList();
        int days[] =new int[speeds.length];
    
        for(int i =0;i<progresses.length;i++){
            
            int remain = (THRESHHOLD  - progresses[i]);
            int speed = speeds[i];
            int day = 0;
            if(remain %speed ==0){
                day = remain /speed;
            }else{
                day = remain /speed+1;
            }
            
            days[i] = day;
        }
        
        int now = days[0];
        int count =0;
        for(int i  = 0 ; i<days.length;i++){
            if(now <days[i]){
                //새로운 카운팅 시작
                now = days[i];
                answer.add(count);
                count = 1;
            }else{
                
                count++;
                
            }
        }
        
        if(count!=0){
            answer.add(count);
        }
        
        
        
        
        
        
        return answer;
    }
}