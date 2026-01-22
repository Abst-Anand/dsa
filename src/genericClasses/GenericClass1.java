package src.genericClasses;

public class GenericClass1<T> {
	private T data;
	
	public GenericClass1(T val){
		this.data = val;
	}
	
	public void setData(T val) {
		this.data = val;
	}
	
	public T getData() {
		return this.data;
	}

	public static void main(String[] args) {
		
		GenericClass1<Integer> obj = new GenericClass1<>(45);
		System.out.println(obj.getData());

	}

}


