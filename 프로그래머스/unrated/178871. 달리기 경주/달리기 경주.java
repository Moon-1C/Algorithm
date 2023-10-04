import  java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> rank = initalRank(players);
        for(String calledName : callings){
            int calledRank = rank.get(calledName);
            changeRank(rank,calledRank,calledName ,players);
        }
    
    
        String[] answer = new String[players.length];
        for(Map.Entry<String ,Integer> entry:rank.entrySet()){
            answer[entry.getValue()]=entry.getKey();
        
        }
        return answer;
    }
    
    
    public Map<String,Integer> initalRank(String[] players){
        Map<String,Integer> Rank = new HashMap<>();
        for(int i =0;i<players.length;i++){
            Rank.put(players[i],i);
        }
        return Rank;
    }
    
    public void changeRank(Map<String ,Integer> rank, int calledRank,
        String calledName,String[] players){
        String Temp = players[calledRank-1];
        players[calledRank-1]=players[calledRank];
        players[calledRank] = Temp;
        rank.put(calledName,calledRank-1);
        rank.put(Temp,calledRank);
    
        
    }
}