import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = array.length;
        for(int num : array){
            map.put(num , 1 + map.getOrDefault(num , 0));
            if(map.get(num) > n / 2) return num;
        }
        return 0;
        
    }
}