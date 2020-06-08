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
	 * Menú. Ejercicio 1
	 * Método que insertar una entrada en el diccionario
	 * @param e (Entrada)
	 * @throws Exception el diccionario está lleno
	 * @throws Exception La entrada ya existe
	 */
	public void nuevaEntrada(Entrada e) throws Exception {
		
		// Si se ha alcanzado el número máximo de entradas...
		if (MAX_ENTRADAS - numEntradas == 0) {
			// ... Saltará la excepción:
			throw new Exception("ERROR. No se pueden introducir más entradas, el diccionario está lleno.");
		}
		
		// Si la entrada no existe en el diccionario...
		if (!entradaExiste(e)) {
			// ... la insertarmos en el diccionario
			entradas[numEntradas] = e;
		
		// si la entrada ya existe en el diccionario...
		} else {
			// ... Saltará la excepción:
			throw new Exception("ERROR. La entrada ya existe.");
		}
		
		// incrementamos el número de entradas existentes en el diccionario
		numEntradas++;
	}
	

	/**
	 * Método que comprueba si la palabra española o inglesa ya existen en el diccionario.
	 * Método de apoyo para nuevaEntrada()
	 * @param e (Entrada)
	 * @return boolean (True si la palabra española o inglesa existen)
	 */
	public boolean entradaExiste(Entrada e) {
		boolean palabraExiste = false;
		
		// Recorremos el diccionario desde el principio hasta el número de entradas existentes...
		// ... y si la palabra que buscamos no ha sido encontrada
		for (int i = 0; i < numEntradas && !palabraExiste; i++) {
			
			// si la palabra española existe...
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
	 * Menú. Ejercicio 2
	 * Método que solicita una palabra y devuelve la traducción 
	 * @param idioma (int)
	 * @param palabraTraducir (String)
	 * @return palabraTraducida (String)
	 * @throws Exception idioma seleccionado incorrecto
	 */
	public String consultarDiccionario(int idioma, String palabraTraducir) throws Exception {
		StringBuilder aux = new StringBuilder();
		
		// si el idioma es español (1) o inglés (2)...
		if (idioma == 1 || idioma == 2) {
			
			// si la palabra a traducir está en español...
			if (idioma == 1) {	
				
				// ...traducimos y guardamos la palabra inglesa
				aux.append(traducirPalabraEspanola(palabraTraducir));	
				
			// Si la palabra a traducir está en inglés...
			} else {
				
				// ...traducimos y guardamos la palabra española
				aux.append(traducirPalabraInglesa(palabraTraducir));				
			}
			
		// si la palabra no es inglesa ni española...
		} else {
			
			// ... Saltará la excepción:
			throw new Exception("ERROR. El idioma seleccionado no es correcto.");
		}
		
		numConsultas++;
		
		return aux.toString();
	}
	
	
	/**
	 * Método que comprueba si la palabra española existe, si es así devuelve la traducción (palabra inglesa).
	 * Método de apoyo para consultarDiccionario()
	 * @param palabraEspanola (String)
	 * @return palabraInglesa (String)
	 * @throws Exception La palabra española a traducir no existe
	 */
	public String traducirPalabraEspanola(String palabraEspanola) throws Exception {
		StringBuilder aux = new StringBuilder();
		boolean palabraExiste = false;
		
		// Recorremos el diccionario desde el principio hasta el número de entradas existentes...
		// ... y si la palabra que buscamos no ha sido encontrada
		for (int i = 0; i < numEntradas && !palabraExiste; i++) {
			
			// Si la palabra española que pasamos por parámetro coincide con la palabra de la entrada del diccionario...
			if (entradas[i].getSpanishWord().equalsIgnoreCase(palabraEspanola)) {
				
				// ... indicamos que hemos encontrado la palabra, para dejar de buscar...
				palabraExiste = true;
				
				// ... y guardamos la palabra inglesa
				aux.append(entradas[i].getEnglishWord());
			}
			
		}
		
		// Si después de recorrer todo el diccionario, la palabra no existe...
		if (!palabraExiste) {
			
			// ... Saltará la excepción:
			throw new Exception("ERROR. La palabra española a traducir (" + palabraEspanola + ") no existe.");
		}
		
		return aux.toString();
	}
	
	
	/**
	 * Método que comprueba si la palabra ingles existe, si es así devuelve la traducción (palabra española).
	 * Método de apoyo para consultarDiccionario()
	 * @param palabraInglesa (String)
	 * @return palabraEspanola (String)
	 * @throws Exception Exception La palabra inglesa a traducir no existe
	 */
	public String traducirPalabraInglesa(String palabraInglesa) throws Exception {
		StringBuilder aux = new StringBuilder();
		boolean palabraExiste = false;
		
		// Recorremos el diccionario desde el principio hasta el número de entradas existentes...
		// ... y si la palabra que buscamos no ha sido encontrada
		for (int i = 0; i < numEntradas && !palabraExiste; i++) {
			
			// Si la palabra inglesa que pasamos por parámetro coincide con la palabra de la entrada del diccionario...
			if (entradas[i].getEnglishWord().equalsIgnoreCase(palabraInglesa)) {
				
				// ... indicamos que hemos encontrado la palabra, para dejar de buscar...
				palabraExiste = true;
				
				// ... y guardamos la palabra española
				aux.append(entradas[i].getSpanishWord());
			}
			
		}
		
		// Si después de recorrer todo el diccionario, la palabra no existe...
		if (!palabraExiste) {
			
			// ... Saltará la excepción:
			throw new Exception("ERROR. La palabra inglesa a traducir (" + palabraInglesa + ") no existe.");
		}
		
		return aux.toString();
	}
	
	
	/**
	 * Menú. Ejercicio 3
	 * Método que devuelve el listado de palabras que empiezan por la letra introducida
	 * @param letra (char)
	 * @return String
	 * @throws Exception No hay palabras que empiecen por la letra introducida
	 */
	public String entradasEmpiezanPorLetra(char letra) throws Exception {
		StringBuilder aux = new StringBuilder();
		int contadorPalabras = 0;
		
		// Se convierte la letra a minúscula
		// De esta forma, si el usuario introduce una letra mayúscula, no habrá problemas
		letra = Character.toLowerCase(letra);
				
		
		// Recorremos el diccionario desde el principio hasta el número de entradas existentes
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
	 * Menú. Ejercicio 4
	 * Método que devuelve el número de consultas realizadas
	 * @return número de consultas (int)
	 * @throws Exception No se han realizado consultas
	 */
	public int numeroConsultas() throws Exception {
		
		if (numConsultas == 0) {
			throw new Exception("ERROR. Todavía no se han realizado consultas.");
		}
		
		return numConsultas;
	}

	
	/**
	 * Menú. Ejercicio 5
	 * Método que muestra el diccionario en orden alfabético por las palabras en español.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioEspanol() throws Exception {
		StringBuilder aux = new StringBuilder();
		
		// si no existen entradas en el diccionario, se muestra el error.
		if (numEntradas == 0) {
			throw new Exception("ERROR. No hay palabras registradas en el diccionario.");
		}
				
		// Se crea un array vacío, con tantos elementos como número de entradas hay en el diccionario
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
	 * Menú. Ejercicio 6
	 * Método que muestra el diccionario en orden alfabético por las palabras en inglés.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioIngles() throws Exception {
		StringBuilder aux = new StringBuilder();
		
		// si no existen entradas en el diccionario, se muestra el error.
		if (numEntradas == 0) {
			throw new Exception("ERROR. No hay palabras registradas en el diccionario.");
		}
				
		// Se crea un array vacío, con tantos elementos como número de entradas hay en el diccionario
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
	 * Método que muestra el diccionario completo
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
