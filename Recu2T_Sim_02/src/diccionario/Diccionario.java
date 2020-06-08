package diccionario;

import java.util.Arrays;

public class Diccionario implements DiccionarioInterface {
	
	private final static int MAX_ENTRADAS = 500;
	private Entrada[] entradas;
	private static int numEntradas = 0;
	private static int numConsultas = 0;

	
	public Diccionario() {
		super();
		this.entradas = new Entrada[MAX_ENTRADAS];
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(entradas);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diccionario other = (Diccionario) obj;
		if (!Arrays.equals(entradas, other.entradas))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Diccionario [entradas=" + Arrays.toString(entradas) + "]";
	}
	
	
	
	
	// ------------ METODOS ------------------
	/**
	 * Men�. Ejercicio 1
	 * M�todo que insertar una entrada en el diccionario
	 * @param e (Entrada)
	 * @throws Exception el diccionario est� lleno
	 * @throws Exception La entrada ya existe
	 */
	public void nuevaEntrada(Entrada e) throws Exception {
		
		// Si se ha alcanzado el n�mero m�ximo de entradas...
		if (MAX_ENTRADAS - numEntradas == 0) {
			// ... Saltar� la excepci�n:
			throw new Exception("ERROR. No se pueden introducir m�s entradas, el diccionario est� lleno.");
		}
		
		// Si la entrada no existe en el diccionario...
		if (!entradaExiste(e)) {
			// ... la insertarmos en el diccionario
			entradas[numEntradas] = e;
		
		// si la entrada ya existe en el diccionario...
		} else {
			// ... Saltar� la excepci�n:
			throw new Exception("ERROR. La entrada ya existe.");
		}
		
		// incrementamos el n�mero de entradas existentes en el diccionario
		numEntradas++;
	}
	

	/**
	 * M�todo que comprueba si la palabra espa�ola o inglesa ya existen en el diccionario.
	 * M�todo de apoyo para nuevaEntrada()
	 * @param e (Entrada)
	 * @return boolean (True si la palabra espa�ola o inglesa existen)
	 */
	public boolean entradaExiste(Entrada e) {
		boolean palabraExiste = false;
		
		// Recorremos el diccionario desde el principio hasta el n�mero de entradas existentes...
		// ... y si la palabra que buscamos no ha sido encontrada
		for (int i = 0; i < numEntradas && !palabraExiste; i++) {
			
			// si la palabra espa�ola existe...
			if (entradas[i].getSpanishWord().equalsIgnoreCase(e.getSpanishWord())) {
				// indicamos que se ha encontrado la palabra para no seguir buscando
				palabraExiste = true;
			}
			
			// si la palabra inglesa existe...
			if (entradas[i].getEnglishWord().equalsIgnoreCase(e.getEnglishWord())) {
				// indicamos que se ha encontrado la palabra para no seguir buscando
				palabraExiste = true;
			}
			
		}
		
		return palabraExiste;
	}
	
	
	/**
	 * Men�. Ejercicio 2
	 * M�todo que solicita una palabra y devuelve la traducci�n 
	 * @param idioma (int)
	 * @param palabraTraducir (String)
	 * @return palabraTraducida (String)
	 * @throws Exception idioma seleccionado incorrecto
	 */
	public String consultarDiccionario(int idioma, String palabraTraducir) throws Exception {
		StringBuilder aux = new StringBuilder();
		
		// si el idioma es espa�ol (1) o ingl�s (2)...
		if (idioma == 1 || idioma == 2) {
			
			// si la palabra a traducir est� en espa�ol...
			if (idioma == 1) {	
				
				// ...traducimos y guardamos la palabra inglesa
				aux.append(traducirPalabraEspanola(palabraTraducir));	
				
			// Si la palabra a traducir est� en ingl�s...
			} else {
				
				// ...traducimos y guardamos la palabra espa�ola
				aux.append(traducirPalabraInglesa(palabraTraducir));				
			}
			
		// si la palabra no es inglesa ni espa�ola...
		} else {
			
			// ... Saltar� la excepci�n:
			throw new Exception("ERROR. El idioma seleccionado no es correcto.");
		}
		
		numConsultas++;
		
		return aux.toString();
	}
	
	
	/**
	 * M�todo que comprueba si la palabra espa�ola existe, si es as� devuelve la traducci�n (palabra inglesa).
	 * M�todo de apoyo para consultarDiccionario()
	 * @param palabraEspanola (String)
	 * @return palabraInglesa (String)
	 * @throws Exception La palabra espa�ola a traducir no existe
	 */
	public String traducirPalabraEspanola(String palabraEspanola) throws Exception {
		StringBuilder aux = new StringBuilder();
		boolean palabraExiste = false;
		
		// Recorremos el diccionario desde el principio hasta el n�mero de entradas existentes...
		// ... y si la palabra que buscamos no ha sido encontrada
		for (int i = 0; i < numEntradas && !palabraExiste; i++) {
			
			// Si la palabra espa�ola que pasamos por par�metro coincide con la palabra de la entrada del diccionario...
			if (entradas[i].getSpanishWord().equalsIgnoreCase(palabraEspanola)) {
				
				// ... indicamos que hemos encontrado la palabra, para dejar de buscar...
				palabraExiste = true;
				
				// ... y guardamos la palabra inglesa
				aux.append(entradas[i].getEnglishWord());
			}
			
		}
		
		// Si despu�s de recorrer todo el diccionario, la palabra no existe...
		if (!palabraExiste) {
			
			// ... Saltar� la excepci�n:
			throw new Exception("ERROR. La palabra espa�ola a traducir (" + palabraEspanola + ") no existe.");
		}
		
		return aux.toString();
	}
	
	
	/**
	 * M�todo que comprueba si la palabra ingles existe, si es as� devuelve la traducci�n (palabra espa�ola).
	 * M�todo de apoyo para consultarDiccionario()
	 * @param palabraInglesa (String)
	 * @return palabraEspanola (String)
	 * @throws Exception Exception La palabra inglesa a traducir no existe
	 */
	public String traducirPalabraInglesa(String palabraInglesa) throws Exception {
		StringBuilder aux = new StringBuilder();
		boolean palabraExiste = false;
		
		// Recorremos el diccionario desde el principio hasta el n�mero de entradas existentes...
		// ... y si la palabra que buscamos no ha sido encontrada
		for (int i = 0; i < numEntradas && !palabraExiste; i++) {
			
			// Si la palabra inglesa que pasamos por par�metro coincide con la palabra de la entrada del diccionario...
			if (entradas[i].getEnglishWord().equalsIgnoreCase(palabraInglesa)) {
				
				// ... indicamos que hemos encontrado la palabra, para dejar de buscar...
				palabraExiste = true;
				
				// ... y guardamos la palabra espa�ola
				aux.append(entradas[i].getSpanishWord());
			}
			
		}
		
		// Si despu�s de recorrer todo el diccionario, la palabra no existe...
		if (!palabraExiste) {
			
			// ... Saltar� la excepci�n:
			throw new Exception("ERROR. La palabra inglesa a traducir (" + palabraInglesa + ") no existe.");
		}
		
		return aux.toString();
	}
	
	
	/**
	 * Men�. Ejercicio 3
	 * M�todo que devuelve el listado de palabras que empiezan por la letra introducida
	 * @param letra (char)
	 * @return String
	 * @throws Exception No hay palabras que empiecen por la letra introducida
	 */
	public String entradasEmpiezanPorLetra(char letra) throws Exception {
		StringBuilder aux = new StringBuilder();
		int contadorPalabras = 0;
		
		// Se convierte la letra a min�scula
		// De esta forma, si el usuario introduce una letra may�scula, no habr� problemas
		letra = Character.toLowerCase(letra);
				
		
		// Recorremos el diccionario desde el principio hasta el n�mero de entradas existentes
		for (int i = 0; i < numEntradas ; i++) {

			if (entradas[i].getSpanishWord().charAt(0) == letra) {
				aux.append(entradas[i].entradasSpaToEng() + "\n");
				contadorPalabras++;
			}

		}
		
		// si no existen palabras en el diccionario, se muestra el error
		if (contadorPalabras == 0) {
			throw new Exception("ERROR. No hay palabras que empiecen por la letra " + letra);
		}
		
		return aux.toString();
	}

	
	/**
	 * Men�. Ejercicio 4
	 * M�todo que devuelve el n�mero de consultas realizadas
	 * @return n�mero de consultas (int)
	 * @throws Exception No se han realizado consultas
	 */
	public int numeroConsultas() throws Exception {
		
		if (numConsultas == 0) {
			throw new Exception("ERROR. Todav�a no se han realizado consultas.");
		}
		
		return numConsultas;
	}

	
	/**
	 * Men�. Ejercicio 5
	 * M�todo que muestra el diccionario en orden alfab�tico por las palabras en espa�ol.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioEspanol() throws Exception {
		StringBuilder aux = new StringBuilder();
		
		// si no existen entradas en el diccionario, se muestra el error.
		if (numEntradas == 0) {
			throw new Exception("ERROR. No hay palabras registradas en el diccionario.");
		}
				
		// Se crea un array vac�o, con tantos elementos como n�mero de entradas hay en el diccionario
		Entrada[] entradasActuales = new Entrada[numEntradas];
		
		// Se copian los elementos del array original al nuevo
		for (int i = 0; i < numEntradas; i++) {
			entradasActuales[i] = entradas[i];
		}
		
		// Se ordena el array nuevo.
		Arrays.sort(entradasActuales, new ComparaPalabraEsp());
		
		// Se muestra el contenido del array nuevo
		for (int i = 0; i < entradasActuales.length; i++) {
			aux.append(entradasActuales[i].entradasSpaToEng() + "\n");
		}
		
		return aux.toString();
	}
	
	
	/**
	 * Men�. Ejercicio 6
	 * M�todo que muestra el diccionario en orden alfab�tico por las palabras en ingl�s.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioIngles() throws Exception {
		StringBuilder aux = new StringBuilder();
		
		// si no existen entradas en el diccionario, se muestra el error.
		if (numEntradas == 0) {
			throw new Exception("ERROR. No hay palabras registradas en el diccionario.");
		}
				
		// Se crea un array vac�o, con tantos elementos como n�mero de entradas hay en el diccionario
		Entrada[] entradasActuales = new Entrada[numEntradas];
		
		// Se copian los elementos del array original al nuevo
		for (int i = 0; i < numEntradas; i++) {
			entradasActuales[i] = entradas[i];
		}

		// Se ordena el array nuevo.
		Arrays.sort(entradasActuales, new ComparaPalabraIng());
		
		// Se muestra el contenido del array nuevo
		for (int i = 0; i < entradasActuales.length; i++) {
			aux.append(entradasActuales[i].entradasEngToSpa() + "\n");
		}

		return aux.toString();
	}

	// -------------------------------------------------------------------------------------------
	
	
	/**
	 * EXTRA.
	 * M�todo que muestra el diccionario completo
	 * @return String
	 */
	public String mostrarEntradas() {
		StringBuilder aux = new StringBuilder();
				
		for (int i = 0; i < numEntradas; i++) {
			aux.append(entradas[i].entradasSpaToEng() + "\n");
		}
		
		return aux.toString();
	}

	
//	public boolean palabraEspanolaExiste(String palabraEspanola) {
//	boolean palabraExiste = false;
//	
//	for (int i = 0; i < numEntradas && !palabraExiste; i++) {
//		
//		if (entradas[i].getSpanishWord().equalsIgnoreCase(palabraEspanola)) {
//			palabraExiste = true;
//		}
//		
//	}
//	
//	return palabraExiste;
//}

	
//	public boolean palabraInglesaExiste(String palabraInglesa) {
//		boolean palabraExiste = false;
//		
//		for (int i = 0; i < numEntradas && !palabraExiste; i++) {
//			
//			if (entradas[i].getEnglishWord().equalsIgnoreCase(palabraInglesa)) {
//				palabraExiste = true;
//			}
//			
//		}
//		
//		return palabraExiste;
//	}

	
}
