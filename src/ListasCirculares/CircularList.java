package ListasCirculares;

import Node.nodo;

public class CircularList <T> {

	private nodo<T> sentinel = null;
	private nodo<T> actual = null;
	
	public CircularList() {
		sentinel = new nodo<T>();
		actual   = new nodo<T>();
		sentinel.setIndex(-1);
		actual.setIndex(-1);
	}
	
	public CircularList(T value) {
		this();
		sentinel.setNext(new nodo <T>(value));
		actual = sentinel.getNext();
		sentinel.getNext().setNext(actual);
	}

/*INICIO RE-INDEX*/
	public void reindex() {
			nodo <T> tmp = sentinel;
			int inde = 0;
			while (tmp.getNext().equals(tmp.getNext())) {
				tmp = tmp.getNext();
				tmp.setIndex(inde);
				inde++;
			}
	}
/*FIN RE-INDEX*/
	
/*INICIO ADDFIRST*/
	public void addFirst(T value) {
		nodo<T> nuevo = new nodo<T>(value);
		nodo<T> last = getLast();
		
		if(isEmpty()){
			sentinel.setNext(nuevo);
			nuevo.setNext(nuevo);
		}else{
			nuevo.setNext(sentinel.getNext());
			sentinel.setNext(nuevo);
			last.setNext(nuevo);
		}
		reindex();
	}
/*INICIO ADDFIRST*/

/*INICIO GETLAST*/
	public nodo<T> getLast(){
		nodo <T> tmp = sentinel.getNext();
		if(!isEmpty()){
			while(!sentinel.getNext().equals(tmp.getNext()))
				tmp = tmp.getNext();
			System.out.println(tmp.getValue());
			return tmp;
		}//end if
		return null;
	}
/*FIN GETLAST*/

/*INICIO REMOVE*/
	public boolean remove(T value){
		if(!isEmpty()){
			nodo<T> found = Search(value);
			if(found != null){
				nodo<T> tmp = SearchBefore(value, sentinel.getNext());
				if(tmp.equals(tmp.getNext()))
					sentinel.setNext(null);
				else if(sentinel.getNext().equals(found)){
					 sentinel.setNext(found.getNext());
					 tmp.setNext(found.getNext());
				 }else{
					 tmp.setNext(found.getNext());
				 }
			}
		}
		return true;
	}
/*FIN REMOVE*/
	
/*INICIO REMPLAZAR*/
	public void replace(T value, T newvalue){
        if (Searchh(value)) {
        	nodo<T> tmp = sentinel;
            while(tmp.getValue() != value){
                tmp = tmp.getNext();
            }
            tmp.setValue(newvalue);
        }
    }
/*FIN REMPLAZAR*/
	
/*INICIO LIMPIAR*/
	public void eliminar(){
        sentinel.setNext(null);
        sentinel.setIndex(-1);
        actual.setValue(null);
        actual.setIndex(-1);
    }
/*FIN LIMPIAR*/
	
/*INICIO BUSCAR ANTES*/
	private nodo<T> SearchBefore(T value, nodo <T> list){
		if(list.getNext().getValue().equals(value)){
			return list;
		}
		if(list.getNext().equals(sentinel.getNext())){
			return null;
		}
		
		return SearchBefore(value, list.getNext());
	}
/*FIN BUSCAR ANTES*/
	
/*INICIO BUSCAR*/
	public nodo<T> Search(T value){
		return (!isEmpty())?Search(value, sentinel.getNext()):null;
	}
	private nodo<T> Search(T value, nodo<T> list){
		if(list.getNext().getValue().equals(value)){
			return list.getNext();
		}
		if(list.getNext().equals(sentinel.getNext())){
			return null;
		}
		
		return Search(value, list.getNext());
	}
	public boolean Searchh(T value){
		return (!isEmpty())?Searchh(value, sentinel.getNext()):null;
	}
	private boolean Searchh(T value, nodo<T> list){
		if(list.getNext().getValue().equals(value)){
			return true;
		}
		if(list.getNext().equals(sentinel.getNext())){
			return false;
		}
		
		return Searchh(value, list.getNext());
	}
/*FIN BUSCAR*/
	
/*INICIO BACIA O NO*/
	public boolean isEmpty(){
		return (sentinel.getNext() == null)?true:false;
	}
/*FIN BACIA O NO*/
	
/*INICIO IMPRIMIR*/
	public void pronter() {
		nodo <T> tmp = sentinel.getNext();
		if(!isEmpty()){
			while (!tmp.getNext().equals(sentinel.getNext())) {
				System.out.println(tmp.getValue());
				tmp = tmp.getNext();
			}
			//System.out.println(tmp.getValue());
		}
	}
/*FIN IMPRIMIR*/
	
}