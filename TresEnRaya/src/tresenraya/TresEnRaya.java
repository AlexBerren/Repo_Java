package tresenraya;
import java.util.Scanner;

import com.sun.jdi.Value;
public class TresEnRaya {

char[] posicion = new char[9];


	public TresEnRaya() {	
		char valor='1';
		for (int i = 0; i < posicion.length; i++) {
			this.posicion[i]=valor;
			valor++;
		}
	}
	public String toString() {
		return this.posicion[0]+"   "+this.posicion[1]+"   "+this.posicion[2]+
				"\n\n"+
				this.posicion[3]+"   "+this.posicion[4]+"   "+this.posicion[5]+
				"\n\n"+
				this.posicion[6]+"   "+this.posicion[7]+"   "+this.posicion[8]+
				"\n\n";
	}
	
	
	
	public boolean posicionarFicha(char posicion, char ficha) {
		
	switch(posicion) {
	case '1': if(this.posicion[0]=='1') {
			this.posicion[0] = ficha;
			return true;
	}
	else return false;
	case '2':if(this.posicion[1]=='2') {
		this.posicion[1] = ficha;
		return true;
}
else return false;
	case '3':if(this.posicion[2]=='3') {
		this.posicion[2] = ficha;
		return true;
}
else return false;
	case '4':if(this.posicion[3]=='4') {
		this.posicion[3] = ficha;
		return true;
}
else return false;
	case '5':if(this.posicion[4]=='5') {
		this.posicion[4] = ficha;
		return true;
}
else return false;
	case '6':if(this.posicion[5]=='6') {
		this.posicion[5] = ficha;
		return true;
}
else return false;
	case '7':if(this.posicion[6]=='7') {
		this.posicion[6] = ficha;
		return true;
}
else return false;
	case '8':if(this.posicion[7]=='8') {
		this.posicion[7] = ficha;
		return true;
}
else return false;
	case '9':if(this.posicion[8]=='9') {
		this.posicion[8] = ficha;
		return true;
}
else return false;
	default: return false;
	}
		
	}
	
public boolean levantarFicha(char posicion, char ficha) {
		
	switch(posicion) {
	case '1': if(this.posicion[0]==ficha) {
			this.posicion[0] = posicion;
			return true;
	}
	else return false;
	case '2':if(this.posicion[1]==ficha) {
		this.posicion[1] = posicion;
		return true;
}
else return false;
	case '3':if(this.posicion[2]==ficha) {
		this.posicion[2] = posicion;
		return true;
}
else return false;
	case '4':if(this.posicion[3]==ficha) {
		this.posicion[3] = posicion;
		return true;
}
else return false;
	case '5':if(this.posicion[4]==ficha) {
		this.posicion[4] = posicion;
		return true;
}
else return false;
	case '6':if(this.posicion[5]==ficha) {
		this.posicion[5] = posicion;
		return true;
}
else return false;
	case '7':if(this.posicion[6]==ficha) {
		this.posicion[6] = posicion;
		return true;
}
else return false;
	case '8':if(this.posicion[7]==ficha) {
		this.posicion[7] = posicion;
		return true;
}
else return false;
	case '9':if(this.posicion[8]==ficha) {
		this.posicion[8] = posicion;
		return true;
}
else return false;
	default: return false;
	}
}
	
	
	
	
	
	public boolean moverFicha(char posicionDesde, char posicionHasta, char ficha) {
	if (levantarFicha(posicionDesde,ficha)) {
		if (posicionarFicha(posicionHasta,ficha)) {
			return true;
			
		}
		else {
			posicionarFicha(posicionDesde,ficha);
		}
			return false;
		}
		
	
	else {
	return true;
	}
	}
	
	
	public boolean tresEnRaya() {
		if(this.posicion[0] == this.posicion[1] && this.posicion[1] == this.posicion[2] || 
		   this.posicion[3] == this.posicion[4] && this.posicion[4] == this.posicion[5] ||
		   this.posicion[6] == this.posicion[7] && this.posicion[7] == this.posicion[8] ||
		   this.posicion[0] == this.posicion[3] && this.posicion[3] == this.posicion[6] ||
		   this.posicion[1] == this.posicion[4] && this.posicion[4] == this.posicion[7] ||
		   this.posicion[2] == this.posicion[5] && this.posicion[5] == this.posicion[8] ||
		   this.posicion[0] == this.posicion[4] && this.posicion[4] == this.posicion[8] ||
		   this.posicion[2] == this.posicion[4] && this.posicion[4] == this.posicion[6]) {
			return true;
		}
		
		return false;
	
	
	
	
}
	
	
	
	
	public static void main (String[] args) {
		TresEnRaya tresRaya=new TresEnRaya();
		System.out.println("inicio partida");
		System.out.println(tresRaya);
		Scanner sc= new Scanner(System.in);
	
		
		char posicion= sc.next().charAt(0);
		System.out.println(tresRaya);
		System.out.println("Jugador 1 situa la ficha X" );
		while(!tresRaya.posicionarFicha(posicion, 'X')) {
			System.out.println("Posicion incorrecta. Vuelve a introducir");
			posicion= sc.next().charAt(0);
		}
		
		
		
		System.out.println(tresRaya);
		System.out.println("Jugador 2 situa la ficha O" );
		while(!tresRaya.posicionarFicha(posicion, 'O')) {
			
			posicion= sc.next().charAt(0);
		}
		
		
		
		
		System.out.println(tresRaya);
		System.out.println("Jugador 1 situa la ficha X" );
		while(!tresRaya.posicionarFicha(posicion, 'X')) {
			
			posicion= sc.next().charAt(0);
		}
		
		
		
		
		System.out.println(tresRaya);
		System.out.println("Jugador 2 situa la ficha O" );
		while(!tresRaya.posicionarFicha(posicion, 'O')) {
			
			posicion= sc.next().charAt(0);
		}
		
		
		
		
		
		System.out.println(tresRaya);
		System.out.println("Jugador 1 situa la ficha X" );
		while(!tresRaya.posicionarFicha(posicion, 'X')) {
			System.out.println("Posicion incorrecta. Vuelve a introducir");
			posicion= sc.next().charAt(0);
		}
		
		if(tresRaya.tresEnRaya()) {
			System.out.println("Jugador 1 ha ganado");
			return;
			
		}
		
		
		System.out.println(tresRaya);
		System.out.println("Jugador 2 situa la ficha O" );
		while(!tresRaya.posicionarFicha(posicion, 'O')) {
			System.out.println("Posicion incorrecta. Vuelve a introducir");
			posicion= sc.next().charAt(0);
		}
		
		
		
		if(tresRaya.tresEnRaya()) {
			System.out.println("Jugador 2 ha ganado");
			return;
			
		}
		int jugador=1;
		char posicionDesde;
		char posicionHasta;
		do {
			System.out.println("jugador"+jugador+"mueve ficha.");
			posicionDesde=sc.next().charAt(0);
			posicionHasta=sc.next().charAt(0);
			while(!tresRaya.moverFicha(posicionDesde,posicionHasta, jugador==1?'X':'O')) {
				System.out.println("Movimiento incorrecto. Introduce un nuevo movimiento");
				posicionDesde=sc.next().charAt(0);
				posicionHasta=sc.next().charAt(0);
			}
			if(tresRaya.tresEnRaya()) {
				System.out.println("Enhorabuena. Jugador"+jugador+"");
				return;
			}
			jugador=(jugador==1)?2:1;
	
		}while(true);
		
		

		
		
		
	}
	
}