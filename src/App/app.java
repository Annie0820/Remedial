package App;

import java.util.Collection;

import ListasCirculares.CircularList;
import ListasDobles.doubleLinkedList;
import ListasSimples.Linkedlist;

public class app <T extends Comparable<T>>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doubleLinkedList <Integer> numeros = new doubleLinkedList<Integer>();
		
		numeros.add(2);
		numeros.add(8);
		numeros.add(5);
		numeros.add(7);
		numeros.add(13);
		System.out.println("****Listas Dobles******");
		System.out.println("Numeros insertados");
		System.out.println("Junto con sus indices");
		numeros.printer();
		System.out.println("***********************");
		System.out.println("Indice del valor 7");
		numeros.IndexOf(7);
		System.out.println("***********************");
		System.out.println("Buscar y reemplazar el valor 8 en la posición 2 por el 4");
		numeros.addIndex(2, 4);
		System.out.println("***********************");
		System.out.println("Buscar y reemplazar el valor 7 por el 9");
		numeros.replace(7, 9);
		numeros.printer();
		System.out.println("*****Listas simples*****");
		
		Linkedlist <Integer> num = new Linkedlist <Integer>();
		num.add(7);
		num.add(5);
		num.add(8);
		num.add(9);
		num.add(2);
		num.add(6);
		//Collection.sort(num);
		System.out.println("Listas circulares");
		CircularList <Integer> n = new CircularList <Integer>();
		num.add(9);
		num.add(96);
		num.add(36);
		num.add(87);
		num.add(28);
		num.add(19);
		num.printer();
	}

}
