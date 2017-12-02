package ListasDobles;

import Node.nodo;

public class doubleLinkedList<T>  {
	private nodo<T> start = null, end = null;

	public doubleLinkedList() {
		start = new nodo();
		start.setIndex(0);
		end = new nodo();
		end.setIndex(0);
		Reindex();
	}

	public doubleLinkedList(T value) { 
		this();
		end.setBack(new nodo<T>(value));
		start.setNext(end.getBack());
		start.getNext().setIndex(0);
		Reindex();
	}

	public void add(T value) {
		nodo<T> tmp = end.getBack();
		end.setBack(new nodo<T>(value));
		if (tmp == null) {
			start.setNext(end.getBack());
		} else {
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
		Reindex();
	}
	
	public void IndexOf(T value) { 
		nodo<T> finder = Search(value); 
		if (finder != null)
			System.out.println(finder.getIndex()-1);
	}

	public int size() {
		nodo<T> tmp = start;
		int i = 0;
		while (tmp.getNext() != null) {
			i++;
			tmp = tmp.getNext();
		}
		return i;
	}

	public void Reindex() {
		nodo<T> tmp = start;
		int i = 1;	
		int p = 1;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			tmp.setPosition(p);
			i++;
			p++;
		}
	}
	
	public void printer() {
		printer(start);
	}

	private void printer(nodo<T> tmp) {
		if (tmp.getNext() == null) {
			return;
		} else {
			System.out.println("Valor: " +tmp.getNext().getValue()+" index:"+tmp.getIndex());
			printer(tmp.getNext());
		}

	}
	
	public boolean addIndex(int i, T newvalue) {
		if(i>size()||i<=0) return false;
		i = i-1;
		nodo<T> finder = Search(i);
		nodo<T> nodo = new nodo<T>(newvalue);
		if (finder != null && finder.getNext()!=null) {
			nodo.setNext(finder.getNext());
			finder.setNext(nodo);
			nodo.setBack(finder);
			nodo.getNext().setBack(nodo);
			Reindex();;
			return true;
		} else {
			add(newvalue);
			return false;
		}
	}

	public nodo<T> Search(int index) {
		return Search(index, start, end);
	}

	private nodo<T> Search(int index, nodo<T> start, nodo<T> end) {
		if (start.getNext().getIndex() == (index))
		{
			return start.getNext();
		} else if (end.getBack().getIndex() == (index)) 
		{
			return end.getBack();
		} else if (start.getNext().equals(end) || start.equals(end))
		{
			System.out.println("Valor inexistente");
			return null;
		}
		return Search(index, start.getNext(), end.getBack());
	}
	public nodo<T> Search(T value){
		return Search(value, start, end);
	}

	private nodo<T> Search(T value, nodo<T> start, nodo<T> end) {
		System.out.println(start.getNext());
		if (start.getNext() == null || end.getBack() == null) {
			return null;
		} else if (start.getNext().getValue().equals(value)) {
			System.out.println(start.getNext().getPosition());
			System.out.println(start.getNext().getIndex());
			return start.getNext();
		} else if (end.getBack().getValue().equals(value)) {
			System.out.println(end.getBack().getPosition());
			System.out.println(end.getBack().getIndex());
			System.out.println();
			return end.getBack();
		} else if ((start.getNext().equals(end)) || (start.equals(end))) {
			System.out.println("Valor inexistente");
			return null;
		}
		return Search(value, start.getNext(), end.getBack());
	}

public void replace(T value, T newValue) {
		nodo<T> tmp=Search(value);
		tmp.setValue(newValue);
		Reindex();
	}
}