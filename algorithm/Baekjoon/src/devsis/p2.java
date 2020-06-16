package devsis;

import java.io.*;
import java.util.*;

public class p2 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
//       int[] ans = solution(new int[] {4,5,-4});
//       int[] ans = solution(new int[] {5,-5});
//       int[] ans = solution(new int[] {5,-1,-2,-3,-4});
//      int[] ans = solution(new int[] { 1, 5, -5, 5, -5, 5, -5, -2 });
//      int[] ans = solution(new int[] {1,6,4,2,-2,-5});
      // System.out.println(Arrays.toString(ans));

   }

   static public int[] solution(int[] snowballs) {
       
       boolean flag=true;
       ArrayList<Integer> arr= new ArrayList<>();
       for(int i=0;i<snowballs.length;i++) {
          arr.add(snowballs[i]);
       }
       while(flag) {
          flag=false;
          for(int i=1;i<arr.size();i++) {
             int val=arr.get(i-1);
             int next=arr.get(i);
             //양수랑 음수일때 비교
             if(val>0&&next<0) {
                if(Math.abs(val)>Math.abs(next)) {
                   System.out.println(val+ " "+next);
                   flag=true;
                   arr.remove(i);
                }else if(Math.abs(val)<Math.abs(next)){
                   flag=true;
                   arr.remove(i-1);
                   i--;
                }else {
                   flag=true;
                   arr.remove(i);
                   arr.remove(i-1);
                }
             }
          }
       }
       int[] answer = {};
       if(!arr.isEmpty()) {
          answer = new int[arr.size()];
          int cnt=0;
          for(int i=0;i<answer.length;i++) {
             answer[cnt++]=arr.get(i);
          }
       }
       return answer;
  }

}