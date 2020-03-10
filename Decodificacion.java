package p3ma;

import java.util.ArrayList;
import java.util.*;

public class Decodificacion 
{
	private int[] lista;
	private ArrayList<Integer> divCuatro;
	private ArrayList<int[]> divSeis;
	private ArrayList<Integer> numsTraduccion;
	private String alf;
	
	//Constructor de la clase
	public Decodificacion(int lista[], String alf)
	{
		this.lista = lista;
		divCuatro = new ArrayList<Integer>();
		divSeis = new ArrayList<int[]>();
		numsTraduccion = new ArrayList<Integer>();
		this.alf = alf;
		
		System.out.println(lista.length);
		
		decodificar();
	}
	
	private void decodificar()
	{
		for(int i = 0; i < lista.length; i++)
		{
			int posCounter = 0;
			
			while(posCounter < 7)
			{
				if(posCounter <= 3)
				{
					divCuatro.add(lista[i]);
				}
				
				i++;
				posCounter++;
			}
			i = i - 1;
		}
		
		System.out.println("DIV CUATRO " + divCuatro.size());
		
		//Ahora dividimos en grupos de 6
		
		for(int i = 0; i < divCuatro.size(); i++)
		{
			int posCounter = 0;
			int[] arrayAux = new int[6];
			
			while(posCounter < 6)
			{
				arrayAux[posCounter] = divCuatro.get(i);		
				i++;
				posCounter++;
			}
			
			i = i - 1;
			
			posCounter = 0;
			divSeis.add(arrayAux);
		}
		
		/*
		for(int i = 0; i < divSeis.size(); i++)
		{
			int counter = 0;
			int[] arrAux2 = divSeis.get(i);
			
			while(counter < arrAux2.length)
			{
				System.out.print(arrAux2[counter]);
				counter++;
			}
			System.out.println("");
			counter = 0;
		}*/
		
		traducir();	
		
		for(int i = 0; i < numsTraduccion.size(); i++)
		{
			System.out.println(numsTraduccion.get(i));
		}
		
		System.out.println("------TRADUCIMOS---------");
		
		for(int i = 0; i < numsTraduccion.size(); i++)
		{
			System.out.print(alf.charAt(numsTraduccion.get(i)));
		}
	}
	
	private void traducir()
	{
		for(int i = 0; i < divSeis.size(); i++)
		{
			int aux[] = divSeis.get(i);
			int suma = 0;
			
			for(int j = 0; j < aux.length; j++)
			{
				if(aux[j] == 1)
				{
					suma += Math.pow(2, (5 - j));
				}
			}			
			numsTraduccion.add(suma);
		}
	}
	
}
