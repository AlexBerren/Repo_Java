package ejercicioPilas;

import java.util.Stack;



public class EjercicioPilas {
	
	public static void main(String[] args) {
		System.out.println(invertirPalabra("Hola"));
		
		String expresion = "2* [(5+x)-(y+z)])-3";
		String expresion2 = "(2* [(5+x)-(y+z)])-3";
		System.out.println(validarExpresion(expresion)?"CORRECTO":"INCORRECTO");
		System.out.println(validarExpresion(expresion2)?"CORRECTO":"INCORRECTO");
		
	}

	public static String invertirPalabra(String palabra) {
		
		Stack<Character> pilaCaracter= new Stack<Character>(); //creamos una pila
		for (int i = 0; i < palabra.length(); i++) {
			pilaCaracter.push(Character.valueOf(palabra.charAt(i)));//introducir caracteres de la palabra al la pila
		}
		
		char [] inversa = new char [pilaCaracter.size()];
		int i=0;
		while (!pilaCaracter.isEmpty()) {//mientras la pila no esta vacia 
			inversa[i]=pilaCaracter.pop();//metemos los caracteres en "inversa" al y se van almacenando al reves
			i++;
			
		}
		return new String(inversa);//metodo de la clase string que si le pasas un array de char te lo pasa a string
	}
	
	public static boolean validarExpresion(String expresion){
		
		Stack <Character> pila = new Stack<Character>();//creamos una pila
		char[] exprChar = expresion.toCharArray();
		for (int i = 0; i < exprChar.length; i++) {
			
			if (exprChar[i]== '(' || exprChar[i] == '{' || exprChar[i] == '[') { //introducir caracteres de la palabra al la pila si tiene ([{
				pila.push(Character.valueOf(exprChar[i]));
			}
			
			else if (exprChar[i]== ')') {
				if (!pila.isEmpty() && pila.peek()=='(') {				// mira el elmento que hay en la cima pero no lo saca
					pila.pop();						 //saca el ultimo elemento de la fila
				}
				else {
					return false;
				}
			}
			
			else if (exprChar[i]== '}'){
				if (!pila.isEmpty() && pila.peek()=='{') {				// mira el elmento que hay en la cima pero no lo saca
					pila.pop();						 //saca el ultimo elemento de la fila
				}
				else {
					return false;
				}
			}
			
			else if (exprChar[i]== ']'){
				if (!pila.isEmpty() && pila.peek()=='[') {				// mira el elmento que hay en la cima pero no lo saca
					pila.pop();						 //saca el ultimo elemento de la fila
				}
				else {
					return false;
				}
			}
			
		}
		
		
		return true;
	}
	
}
