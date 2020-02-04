
public class Perceptron {
	 double[] wagaiprog;
	 double zmiennauczenia;
	 String przeznaczenie;
	
	Perceptron(String przeznaczenie){
		int rozmiar=27;
		wagaiprog=new double[rozmiar];
		for(int i=0;i<rozmiar;i++){
			wagaiprog[i]=(int)(Math.random() * (11 - 1 ));	
		}
		zmiennauczenia=0.2;		
		this.przeznaczenie=przeznaczenie;
	}
	
	int przetworzsygnal(double[] X){
		double[] W=wagaiprog;
		int WX=0;		
		for(int k=0;k<wagaiprog.length;k++){
			WX+=W[k]*X[k];		
		}
		if(WX>=0) {
		return 1;
		}else
		return 0;
	}
	
	 void reagujnabodziec(double [] X,int odpdecyzja,int decyzja){
		double[] nowawagaiprog=new double[X.length];
		int rodzajbodzca=odpdecyzja-decyzja;
		
		for(int k=0;k<X.length;k++){
			nowawagaiprog[k]=X[k]*rodzajbodzca*zmiennauczenia;
		}
		for(int k=0;k<nowawagaiprog.length;k++){
			nowawagaiprog[k]=nowawagaiprog[k]+wagaiprog[k];
		}		
		wagaiprog=nowawagaiprog;		
	}
}

