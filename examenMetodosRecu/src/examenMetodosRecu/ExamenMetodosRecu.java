package examenMetodosRecu;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExamenMetodosRecu {
	static String crearCadena(Scanner in) {
		String cadena="";
		do {
			System.out.println("Introduzca cadena (max 30): ");
			cadena=in.nextLine();
		}while(cadena.length()>30);
		return cadena;
	}
	static String invertirCadena(Scanner in, String cadena) {
		String cadenaReves="";
		for(int i=cadena.length()-1;i>=0;i--) {
			cadenaReves=cadenaReves+cadena.charAt(i);
		}
		return cadenaReves;
	}
	static void visualizar(String cadena, String cadenaReves) {
		System.out.println("Cadena: "+cadena);
		System.out.println("Cadena invertida: "+cadenaReves);
	}
	static void contarCoincidencias(String cadena, String cadenaReves, int[] coincidencias) {
		int total=0;
		int letras=0;
		int numeros=0;
		int otros=0;
		for(int i=0;i<cadena.length();i++) {
			if (cadena.charAt(i)==cadenaReves.charAt(i)) {
				total++;
				if(Character.isLetter(cadena.charAt(i)))
					letras++;
				else if(Character.isDigit(cadena.charAt(i)))
					numeros++;
				else
					otros++;
				}
		}
		coincidencias[0]=total;
		coincidencias[1]=letras;
		coincidencias[2]=numeros;
		coincidencias[3]=otros;
	}
	static char introducirCaracter(Scanner in) {
		String laLetra=in.nextLine();
		do {
			System.out.println("Introduce un carcater a buscar en la cadena: ");
			laLetra=in.nextLine();
		}while(laLetra.length()!=1);
		char caracter=laLetra.charAt(0);	
		return caracter;
	}
	static void visualizarCoincidencias(int[] coincidencias) {
		System.out.println("Coincidencias totales: "+coincidencias[0]);
		System.out.println("Coincidencias de letras: "+coincidencias[1]);
		System.out.println("Coincidencias de números: "+coincidencias[2]);
		System.out.println("Otras coincidencias : "+coincidencias[3]);
	}
	static boolean buscarCaracter(char caracter, String cadena) {
		for (int i=0;i<cadena.length();i++) {
			if(caracter==cadena.charAt(i))
				return true;
		}
		return false;
	}
	public static void main(String []args) {
		Scanner in = new Scanner(System.in);
		String cadena="";
		String cadenaReves="";
		int[] coincidencias = new int[4];
		char caracter=' ';
		boolean esta=false;
		cadena=crearCadena(in);
		cadenaReves=invertirCadena(in,cadena);
		visualizar(cadena, cadenaReves);
		contarCoincidencias(cadena, cadenaReves,coincidencias);
		visualizarCoincidencias(coincidencias);
		caracter=introducirCaracter(in);
		esta=buscarCaracter(caracter, cadena);
		if(esta) {
			System.out.println("El caracter está en la cadena");
		}
		else
			System.out.println("El caracter no está en la cadena");
	}
	
}
