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
		// 노드 생성
		Node newNode = new Node(input);
		
		// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용
		if(size == 0) {
			addFirst(input);
		}else {
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
}
