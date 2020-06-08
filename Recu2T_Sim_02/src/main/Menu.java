package main;

import java.util.Scanner;

import diccionario.Diccionario;
import diccionario.Entrada;

public class Menu {

	public static Scanner teclado = new Scanner(System.in);
	public static Diccionario dic = new Diccionario();
	
	public static void main(String[] args) throws Exception {
		
		int menu = 1;

		while (menu != 0) {
			System.out.println("0. Salir");
			System.out.println("1. Nueva entrada en diccionario.");
			System.out.println("2. Consultar el diccionario.");
			System.out.println("3. Listado de entradas que empiecen por una letra.");
			System.out.println("4. N�mero de consultas.");
			System.out.println("5. Imprimir diccionario espa�ol.");
			System.out.println("6. Imprimir diccionario ingl�s.");

			menu = Integer.parseInt(teclado.nextLine());

			switch (menu) {
			case 0:
				System.out.println("Hasta luego!");
				break;

			case 1:
				String spaWord = leerString("Introduce la palabra en espa�ol:");
				String engWord = leerString("Introduce la palabra en ingl�s:");

				Entrada e = new Entrada(spaWord, engWord);
				
				try {
					dic.nuevaEntrada(e);
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
				break;

			case 2:
				int idioma = leerEntero("Introduce el idioma: 1(espa�ol) | 2(ingl�s)");
				String palabraTraducir = leerString("Introduce la palabra a traducir:"); 
				
				try {
					System.out.println(dic.consultarDiccionario(idioma, palabraTraducir));
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
				break;

			case 3:
				char letra = leerCaracter("Introduce una letra para buscar palabras:");
				
				try {
					System.out.println(dic.entradasEmpiezanPorLetra(letra));
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}

				break;

			case 4:
				try {
					System.out.println("Consultas realizadas: " + dic.numeroConsultas());
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
				break;
				
			case 5:
				try {
					System.out.println(dic.mostrarDiccionarioEspanol());
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
				break;

			case 6:
				try {
					System.out.println(dic.mostrarDiccionarioIngles());
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}				
				break;

			//Opci�n oculta
			case 7:
				System.out.println(dic.mostrarEntradas());
				break;

			default:
				System.out.println("La opci�n seleccionada no es v�lida");
				break;
			}

		}
		
	}
	
	
	public static String leerString(String m) {
		String aux;
		
		System.out.println(m);
		aux = teclado.nextLine();
		
		return aux;
	}
	
	public static int leerEntero(String msg) {
		int resultado;
		
		System.out.println(msg);
		resultado = Integer.parseInt(teclado.nextLine());
		
		return resultado;
	}
	
	public static char leerCaracter(String msg) {
		char resultado;
		
		System.out.println(msg);
		resultado = teclado.nextLine().charAt(0);
		
		return resultado;
	}

}
