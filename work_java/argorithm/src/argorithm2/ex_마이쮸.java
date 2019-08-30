package argorithm2;

import java.util.LinkedList;
import java.util.Queue;

public class ex_마이쮸 {
	static class Person{
		int num;
		int cnt;
		int sum;
		Person(int n, int c){num=n;cnt=c;}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return num + "번 먹은 갯수 : "+sum;
		}
	}

	public static void main(String[] args) {
//		int nextNum =1;
//		Queue<Person> queue = new LinkedList<>();
//		int mychucnt = 5;
//		Person p = null;
//		while(true) {
//			queue.add(new Person(nextNum++, 1));
//			p = queue.poll();
//			p.sum += (p.cnt > mychucnt ? mychucnt : p.cnt);
//			mychucnt -=p.cnt;
//			p.cnt++;
//			queue.add(p);
//			if(mychucnt <=0)
//				break;
//		}
//		System.out.println(p.num);
//		for(Person pp : queue) {
//			System.out.println(pp);
//		}
		
		
		
		
		
		

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> cnt = new LinkedList<>();
		int candy = 20;
		int num = 1;
		int re_num = 0;
		int re_cnum = 0;
		int eat = 1;
		int[] arr = new int[candy];

		while (true) {
			if (candy <=1) {
				System.out.println("마지막 사람은 : " +queue.poll());
				break;
			}
			queue.add(num);
			cnt.add(eat);

			re_num = queue.poll();
			re_cnum = cnt.poll();
			
			arr[re_num] += re_cnum;
			
			if (candy <= re_cnum) {
				System.out.println("마지막 사람은 : " +re_num);
				break;
			}

			candy -= re_cnum;
			eat += re_cnum;

			queue.add(re_num);
			cnt.add(eat);
			
			num++;
			eat = 1;
		}
		
		for(int i =1; i<=arr.length; i++) {
			if(arr[i]!=0) {
				System.out.println(i+"번이 " + arr[i]+"를 먹었습니다.");
			}else
				break;
		}
	}
}
