package schronisko;

import java.io.*;

public class App {

	public static void main(String[] args) throws IOException{
		int n = 20, empty = 0, iloscZwierzakow, wybor;
		String klatka[] = new String[n];
		System.out.print("W schronisku mo�e pomie�ci� si� max. 20 zwierz�t\n");
		BufferedReader bl = new BufferedReader (new InputStreamReader(System.in));
		
		do {
			System.out.println("\nCo chcesz zrobi�?");
			System.out.println("0. Wyj�cie");
			System.out.println("1. Doda� zwierzaka do schroniska");
			System.out.println("2. Wy�wietl ile klatek jest pustych");
			System.out.println("3. Wypisa� jakie zwierzaki znajduj� si� w schronisku");
			System.out.println("4. Klatki zaj�te");
			System.out.println("5. Zerowanie pozycji z klatki");
			wybor = Integer.parseInt(bl.readLine());
			
			switch (wybor) { //Integer.parseInt(bl.readLine()) umo�liwia wpisanie cyfr - parsuje je. "bl.readLine" - wpisuje String
			case 0:
				System.out.println("\n�egnaj.");
				break;
			case 1:
				BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
				System.out.print("Ile zwierzak�w chcesz doda�? ");
				iloscZwierzakow = Integer.parseInt(br.readLine());
				
				for (int j = 0; j < iloscZwierzakow; j++) {
					System.out.println("Podaj numer klatki i nazw� zwierzaka: ");
					klatka[Integer.parseInt(br.readLine())] = br.readLine();
					for (int i = 0; i < n; i++) {
						if (klatka[i] != null) {
							System.out.println("W klatce nr " + i + " jest: " + klatka[i]);
						}
					}
					System.out.println();
				}
				break;
			case 2:
				empty = 0;
				for (int i = 0; i < n; i++) {
					if (klatka[i] == null) {
						empty = empty + 1;
					}
				}
				System.out.println("\nLiczba klatek pustych: " + empty);
				break;
				
			case 3:
				for (int i = 0; i < n; i++) {
					if (klatka[i] != null) {
						System.out.println("W klatce nr " + i + " jest: " + klatka[i]);
					} else {
						System.out.println("Klatka nr " + i + " jest pusta");
					}
				}
				break;
				
			case 4:
				System.out.print("Klatki o nr ");
				for (int i = 0; i < n; i++) {
					if (klatka[i] != null) {
						System.out.print(i + ", ");
					}
				}
				System.out.print("s� wykorzystane.\n");
				break;
				
			case 5:
				System.out.println("Jak� pozycj� wyzerowa�?");
				BufferedReader be =  new BufferedReader(new InputStreamReader(System.in));
				int i = Integer.parseInt(be.readLine());
				if (klatka[i] == null) {
					System.out.println("W klatce nie ma �adnego zwierz�tka");
				} else {
					klatka[i] = null;
					System.out.println("Klatka " + i + " zosta�a wyzerowana.");
				}
				break;
	
			default:
				System.out.println("Nieznane polecenie.");
				break;
			}
		} while (wybor != 0);
	}
}
