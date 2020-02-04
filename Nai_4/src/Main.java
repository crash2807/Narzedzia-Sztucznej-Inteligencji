import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Zbieracz.pozbierajJezyki("tren", Zbieracz.zbiorTreningowy);
		Zbieracz.pozbierajJezyki("test", Zbieracz.zbiorTestowy);
		SiecPerceptronowa.stworzPerceptrony();
		
		SiecPerceptronowa.nastrojPerceptrony(30);
		
		System.out.println(SiecPerceptronowa.kwalifikacjaJezykow());
		
		while(true) {
		System.out.println("Podaj ścieżke pliku: ");
		Scanner skaner=new Scanner(System.in);
		File plik=new File(skaner.nextLine());
		
		System.out.println(SiecPerceptronowa.kwalifkikacjaJezyka(zwrocWektor(plik)));		
		}
		
	}

	 static double[] zwrocWektor(File plik) {
		 double wektor[]=new double[27];
			try {
			String nazwa=plik.getName().replace(".txt","");
			
			Scanner skaner=new Scanner(plik,"Cp1252");
			int znak;
			while(skaner.hasNext()){
				String next=skaner.next();
				if(nazwa.equals("pol")){
				next=next.replaceAll("[óÓ]","u");
				next=next.replaceAll("[żŻ]","g");
				next=next.replaceAll("[Źź]","ze");
				next=next.replaceAll("[ćĆ]","te");
				next=next.replaceAll("[łŁ]","l");
				}
				if(nazwa.equals("cz")){
				next=next.replaceAll("[Čč]","ch");
				next=next.replaceAll("[Áá]","a");
				next=next.replaceAll("[Ďď]","j");
				next=next.replaceAll("[Ěě]","ye");
				next=next.replaceAll("[Éé]","e");
				next=next.replaceAll("[ÍíÝý]","ee");
				next=next.replaceAll("[Ňň]","ny");
				next=next.replaceAll("[Óó]","oa");
				next=next.replaceAll("[Řř]","rsh");
				next=next.replaceAll("[Šš]","sh");
				next=next.replaceAll("[Ťť]","t");
				next=next.replaceAll("[ÚúůŮ]","oo");
				next=next.replaceAll("[Žž]","ze");
				}
				for(int i=0;i<next.length();i++){
				char c= next.charAt(i);
				znak=c;
				if(znak>=65 && znak<=90){
					znak+=32;
				}
				if(znak>122 || znak<97){
					
					
				}else{
				
				
				znak=znak-97;
				
				wektor[znak]+=1;
				}
				}
					
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		wektor[26]=-1;

			
			return wektor;
		}

}
