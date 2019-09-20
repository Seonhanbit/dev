package argorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MyStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyStack stack = new MyStack(10);
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		
//		try {
//			System.out.println(stack.pop());
//		}catch(MyStackEmptyException e){
//			System.out.println("스택 비었어 ㅠㅠ ");
//		}
		MyStack stack = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.파일에서 읽기\n2. 새로 생성");
		int sel = sc.nextInt();
		if(sel ==1) {
			//파일 읽기
			ObjectInputStream oi;
			try {
				oi = new ObjectInputStream(new FileInputStream("data.dat"));
				stack = (MyStack)oi.readObject();
				oi.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			stack = new MyStack(10);
		}		
		
		while(true) {
			System.out.println("1. Push (입력 예 : 1 10)\n2. Pop (입력 예 : 2)\n0. 종료");
			sel = sc.nextInt();
			if(sel ==1) {
				int data = sc.nextInt();
				stack.push(data);
			}else if(sel ==2) {
//				try {
				System.out.println(stack.pop());
//				catch(MyStackEmptyException e) {
//					e.printStackTrace();
//				}
			}else if(sel==0) {
				//파일에 쓰고 종료
				
				try {
					ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.dat"));
					os.writeObject(stack);
					os.flush();
					os.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;				
			}else if(sel==-1) {
				break;
			}
		}
		
		
	}

}
