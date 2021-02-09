package main.java.study;

// https://opentutorials.org/module/1335/8715
public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	// 마지막 위치에 데이터 추가
	public boolean addLast(Object element) {
	    elementData[size] = element;
	    size++;
	    return true;
	}
	
	// 중간 위치에 데이터 추가
	public boolean add(int index, Object element) {
		// 엘리먼트 중간에 데이터를 추가하기 위해서는 끝의 엘리먼트로부터 index의 노드까지 뒤로 한칸씩 이동시켜야함.
		for(int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		
		// index에 노드를 추가
		elementData[index] = element;
		
		// 엘리먼트 숫자 1 증가
		size++;
		
		return false;
	}
	
	// 첫번째에 데이터 추가
	public boolean addFirst(Object element) {
		return add(0, element);
	}
	
	// toString 오버라이딩
	public String toString() {
		String str = "[";
		for(int i = 0; i < size; i++) {
			str += elementData[i];
			if(i < size - 1) {
				str += ",";
			}
		}
		
		return str + "]";
	}
	
	// 데이터 삭제
	public Object remove(int index) {
		// 엘리먼트를 삭제하기 전에 삭제할 데이터를 removed 변수에 저장
		Object removed = elementData[index];
		
		// 삭제된 엘리먼트 다음 엘리먼트부터 마지막 엘리먼트까지 순차적으로 이동해서 빈자리를 채움
		for(int i = index +1; i <= size - 1; i++) {
			elementData[i - 1] = elementData[i];
		}
		
		// 크기를 줄임
		size--;
		
		// 마지막 위치의 엘리먼트를 명시적으로 삭제
		elementData[size] = null;
		
		return null;
	}
	
	// 처음 엘리먼트 삭제
	public Object removeFirst() {
		return remove(0);
	}
	
	// 끝 엘리먼트 삭제
	public Object removeLast() {
		return remove(size - 1);
	}
	
	// 데이터 가져오기
	public Object get(int index) {
		return elementData[index];
	}
	
	// 엘리먼트의 크기
	public int size() {
		return size;
	}
	
	// 특정한 값을 가진 엘리먼트의 인덱스 값 조회
	public Object indexOf(Object o) {
		for(int i = 0; i < size; i++) {
			if(o.equals(elementData[i])) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(5);
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.removeFirst();
		numbers.removeLast();
		
		System.out.println(numbers.indexOf(3));
		System.out.println(numbers.toString());
		
	}
}
