package argorithm;

import java.io.Serializable;

class MyStackOverflowException extends RuntimeException {

}

class MyStackEmptyException extends RuntimeException{
	
}

public class MyStack<T> implements Serializable{

private T[] stack;
private int top;
	
	//최대 스택의 크기를 매개변수로 받아옴
	public MyStack(int size) {
		//new를 사용하는 것은 이미 타입이 결정되어 있어서 int 안됨
		stack = (T[]) new Object[size];
		top =-1;
	}
	
	public void push(T data) {
		if(top >=stack.length -1) {
			//사용자 정의 예외를 사용하는 이유 > 
			//직접 대응하기 상황만 알려주면 저 예외를 캐치해서 UI단에서 원하는 대응을 하도록 하기 위해
			throw new MyStackOverflowException();
		}
		top++;
		stack[top]=data;
	}
	
	public T pop() {
		if(top<0) {
			throw new MyStackEmptyException();
		}
			return stack[top--];
	}
	
	

}
