package main.java.study.list.LinkedList;


// https://opentutorials.org/module/1335/8857
public class LinkedList {
	
	// 첫번째 노드를 가리키는 필드
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {	// Inner Class
		// 데이터가 저장될 필드
		private Object data;
		// 다음 노드를 가리키는 필드
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		// 노드의 내용을 출력해서 확인
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	
	// 처음 위치에 데이터 추가
	public void addFirst(Object input) {
		// 노드 생성
		Node newNode = new Node(input);
		
		// 새로운 노드의 다음 노드로 해드를 지정
		newNode.next = head;
		
		// 해드로 새로운 노드를 지정
		head = newNode;
		size++;
		
		if(head.next == null) {
			tail = head;
		}
		
	}
	
	// 마지막 위치에 데이터 추가
	public void addLast(Object input) {
		// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용
		if(size == 0) {
			addFirst(input);
		}else {
			// 노드 생성
			Node newNode = new Node(input);
			
			// 마지막 노드의 다음 노드로 생성한 노드를 지정
			tail.next = newNode;
			
			// 마지막 노드를 갱신
			tail = newNode;
		
			// 엘리먼트의 개수를 1 증가
			size++;
		}
		
	}
	
	// 중간에 데이터 추가
	Node node(int index) {
		
		Node x = head;
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
		
	}
	
	// 중간에 추가
	public void add(int k, Object input) { 
		// 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst 사용
		if(k == 0) {
			addFirst(input);
		}else {
			Node temp1 = node(k-1);
			
			// k번째 노드를 temp2에 저장
			Node temp2 = temp1.next;
			
			// 새로운 노드를 생성
			Node newNode = new Node(input);
			
			// temp1의 다음 노드로 새로운 노드를 지정
			temp1.next = newNode;
			
			// 새로운 노드의 다음 노드로 temp2를 지정
			newNode.next = temp2;
			size++;
			
			// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정
			if(newNode.next == null) {  
				tail = newNode;
			}
		}
		
	}
	
	// 첫번째 노드 삭제
	public Object removeFirst(){
	    // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경
	    Node temp = head;
	    head = temp.next;
	    // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 저장
	    Object returnData = temp.data;
	    temp = null;
	    size--;
	    return returnData;
	    
	}
	
	// 중간 노드 삭제
	public Object remove(int k){
		
	    if(k == 0) return removeFirst();
	    
	    // k-1번째 노드를 temp의 값으로 지정
	    Node temp = node(k-1);
	    
	    // 삭제 노드를 todoDeleted에 저장
	    // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.   
	    Node todoDeleted = temp.next;
	    
	    // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정
	    temp.next = temp.next.next;
	    
	    // 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장
	    Object returnData = todoDeleted.data; 
	    
	    if(todoDeleted == tail){
	        tail = temp;
	    }
	    
	    // cur.next를 삭제
	    todoDeleted = null; 
	    size--;
	    
	    return returnData;
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	// 데이터 출력
	public String toString1() {
	    // 노드가 없다면 []를 리턴
	    if(head == null){
	        return "[]";
	    }       
	    // 탐색 시작
	    Node temp = head;
	    String str = "[";
	    // 다음 노드가 없을 때까지 반복문을 실행
	    // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외
	    while(temp.next != null){
	        str += temp.data + ",";
	        temp = temp.next;
	    }
	    // 마지막 노드를 출력결과에 포함
	    str += temp.data;
	    return str+"]";
	    
	}
	
}
