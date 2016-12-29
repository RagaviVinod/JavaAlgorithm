public class LinkedList {
	private ListNode head;
	private int length = 0;
	
	public LinkedList() {
		length = 0;
	}
	public synchronized ListNode getHead() {
		return head;
	}

	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public synchronized void insertAtEnd(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length++;
	}

	public void insert(int data, int position) {
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}
		if (head == null) {
			head = new ListNode(data);
		} else if (position == 0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		} else {
			ListNode temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		length += 1;
	}

	public synchronized ListNode removeFromBegin() {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}

	public synchronized ListNode removeFromEnd() {
		if (head == null) {
			return null;
		}
		ListNode p = head, q = null, next = head.getNext();
		if (next == null) {
			head = null;
			return p;
		}
		while ((next = p.getNext()) != null) {
			q = p;
			p = next;
		}
		q.setNext(null);
		return p;
	}

	public synchronized void removeFromMatched(ListNode node) {
		if (head == null)
			return;
		if (node.equals(head)) {
			head = head.getNext();
			return;
		}
		ListNode p = head, q = null;
		while ((q = p.getNext()) != null) {
			if (node.equals(q)) {
				p.setNext(q.getNext());
				return;
			}
			p = q;
		}
	}

	public void remove(int position) {
		if (position < 0) {
			position = 0;
		}
		if (position >= length) {
			position = length - 1;
		}
		if (head == null) {
			return;
		}
		if (position == 0) {
			head = head.getNext();
		} else {
			ListNode temp = head;
			for (int i = 0; i < position; i += 1) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		length -= 1;
	}

	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		ListNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";

	}

	public int length() {
		return length;
	}

	public int getPosition(int data) {
		ListNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}

	public void clearList() {
		head = null;
		length = 0;
	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(6);
		ListNode n5 = new ListNode(7);
		LinkedList sll1 = new LinkedList();
		sll1.insertAtBegin(n1);
		sll1.insertAtEnd(n2);
		sll1.insertAtEnd(n3);
		sll1.insertAtEnd(n4);
		sll1.insertAtEnd(n5);
		sll1.insert(2, 0);
		System.out.println("the length of the singly linked list is "+ sll1.length());
		System.out.println("the elements in the linked list are");
		System.out.println(sll1);

	}
}
