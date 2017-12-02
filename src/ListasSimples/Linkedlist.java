package ListasSimples;


import java.util.Collection;

import Node.nodo;

public class Linkedlist<T > {
	
	private nodo<T> sentinel = null;
	private nodo <T>raiz;
	private int i = 0;
	public Linkedlist() {
		sentinel = new nodo<T>();
		sentinel.setIndex(-1);
		
	}

	public Linkedlist(T value) {
		this();
		nodo<T> tmp = new nodo(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);

	}

	public void addStart(T value) {
		nodo<T> tmp = sentinel.getNext();
		nodo<T> _new = new nodo<T>(value);

		_new.setNext(tmp);

		sentinel.setNext(_new);
		reIndex();
	}

	private void reIndex() {
		int i=0;
		nodo<T> tmp=sentinel;
		
		while(tmp.getNext()!=null) {
			
			tmp.setIndex(i++);
			tmp=tmp.getNext();
		}
	}
	
	public T IndexOf(long index) {
		return IndexOf(index,sentinel);
	}
	
	private T IndexOf(long index, nodo<T> list) {
		if (list.getNext()==null) {
			return null;
		}
		long i=list.getIndex();
		if(i==index) {
			return list.getNext().getValue();
		}else {
			return IndexOf(index, list.getNext());
		}
	}
	public void printer() {
		printer(sentinel);
	}

	
	private void printer(nodo<T> tmp) {
		reIndex();
		if (tmp.getNext() == null) {
			return;
		} else {
			System.out.println(tmp.getNext().getValue());
			printer(tmp.getNext());
		}
	}
	
	public void add(T value) {
		add(value, sentinel);
	}

	public void add(T value, nodo<T> list) {
		if (list.getNext() == null) {
			list.setNext(new nodo<T>(value));
			return;

		}
		add(value,list.getNext());
	}

}
