package EncuentratuCERVEZA;

import java.util.Random;
import java.util.Scanner;

public class encuentratucerveza {
	public static void ingreso(int []datos){
		Random ri = new Random();
		for(int i=0;i<datos.length;i++) {
			datos[i]=ri.nextInt(100);
		}
	}
	public static double sumpro(int []datosx) {
		int suma=0;
		double probabilidad=0;
		for(int i=0;i<datosx.length;i++) {
			suma+=datosx[i];
		}
		probabilidad=suma/datosx.length;
		return (probabilidad);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int invitados;
		Scanner teclado=new Scanner(System.in);
		System.out.println("ingrese la cantidad de invitados");
		invitados=teclado.nextInt();
		
		
		int []datos=new int [invitados];
		double probabilidad1=0;
		ingreso(datos);
		probabilidad1=sumpro(datos)/invitados*100;
		System.out.println("de "+invitados+ " vasos tienes la probabilidad del "
				+probabilidad1+"% Para encontrar tu vaso");
		
	}

}
