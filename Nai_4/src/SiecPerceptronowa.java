

import java.util.ArrayList;



public class SiecPerceptronowa {
	static ArrayList<Perceptron> perceptrony=new ArrayList<>();
	
	static void stworzPerceptrony(){
		String[] jezyki= Zbieracz.zbiorTreningowy.keySet().toArray(new String[Zbieracz.zbiorTreningowy.size()]);
		
		for(int i=0;i<jezyki.length;i++){
			perceptrony.add(new Perceptron(jezyki[i]));
		}
		
	}
	static void nastrojPerceptrony(int dlugosc){
		String[] jezyki= Zbieracz.zbiorTreningowy.keySet().toArray(new String[Zbieracz.zbiorTreningowy.size()]);
		for(int i=0;i<dlugosc;i++){		
			for(int p=0;p<perceptrony.size();p++){				
			    for(int j=0;j<jezyki.length;j++){
			    	for(int c=0;c<Zbieracz.zbiorTreningowy.get(jezyki[j]).size();c++){
			    	if(perceptrony.get(p).przeznaczenie.equals(jezyki[j])){
			    	nastrojPerceptron(perceptrony.get(p) ,Zbieracz.zbiorTreningowy.get(jezyki[j]).get(c),1);
			    	}else{
			    		nastrojPerceptron(perceptrony.get(p) ,Zbieracz.zbiorTreningowy.get(jezyki[j]).get(c),0);	
			    	}
			    }
			    }			
			}		
		}			
	}
	
	static void nastrojPerceptron(Perceptron perceptron ,double[] wektor,int odpdecyzja){
		int decyzja;	
		decyzja=perceptron.przetworzsygnal(wektor);		
		perceptron.reagujnabodziec(wektor,odpdecyzja,decyzja);
		
	}
	static String kwalifkikacjaJezyka(double[] X){
		double[] koncowy=new double[perceptrony.size()];

		for(int p=0;p<perceptrony.size();p++){
			double[] W=perceptrony.get(p).wagaiprog;
			double WX=0;
			for(int k=0;k<X.length;k++){
				WX+=W[k]*X[k];
			}
			koncowy[p]=WX;
	
		}
		for(int k=0;k<koncowy.length;k++){
			if(koncowy[k]>=0){
				return "zakwalifikowany jako " + perceptrony.get(k).przeznaczenie;
			}
			
		}
	
		
		return null;
	}
	static String kwalifikacjaJezykow(){
		String[] jezyki= Zbieracz.zbiorTestowy.keySet().toArray(new String[Zbieracz.zbiorTestowy.size()]);
		String odp="";
		for(int j=0;j<jezyki.length;j++){
			for(int c=0;c<Zbieracz.zbiorTestowy.get(jezyki[j]).size();c++){
			odp+="plik " + kwalifkikacjaJezyka(Zbieracz.zbiorTestowy.get(jezyki[j]).get(c)) + "\n";	
			}			
		}		
		return odp;	
	}
	

	
}
