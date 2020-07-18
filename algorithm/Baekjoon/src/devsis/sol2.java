package NDS;

import java.util.*;

public class sol2 {

	public static void main(String[] args) {
		int[] goods = { 3, 8, 6 };
		int[] boxes = { 4, 5, 6 };
		solution(goods, boxes);
		// System.out.println(max);

	}
	// n개의 상품을 k개의 상자에 담기
	// 상품의 크기보다는 크거나 같은 상자에 담기
	// 상자 하나에 한가지 상품만 담기

	public static int solution(int[] goods, int[] boxes) {
		Arrays.sort(goods);
		Arrays.sort(boxes);
		int cnt = 0;
		int boxidx = 0;
		for (int i = 0; i < goods.length; i++) {
			if(boxidx > boxes.length-1)
				break;
			if (goods[i] <= boxes[boxidx]) {
				boxidx++;
				cnt++;
			}else {
				boxidx++;
				i--;
			}
		}
		return cnt;
	}

}
