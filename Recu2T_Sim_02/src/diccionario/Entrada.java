package diccionario;

public class Entrada implements EntradaInterface {

	private String spanishWord;
	private String englishWord;
	
	
	
	public Entrada(String spanishWord, String englishWord) {
		super();
		this.spanishWord = spanishWord;
		this.englishWord = englishWord;
	}
	
	
	
	public String getSpanishWord() {
		return spanishWord;
	}
	public void setSpanishWord(String spanishWord) {
		this.spanishWord = spanishWord;
	}
	public String getEnglishWord() {
		return englishWord;
	}
	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((englishWord == null) ? 0 : englishWord.hashCode());
		result = prime * result + ((spanishWord == null) ? 0 : spanishWord.hashCode());
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
		Entrada other = (Entrada) obj;
		if (englishWord == null) {
			if (other.englishWord != null)
				return false;
		} else if (!englishWord.equals(other.englishWord))
			return false;
		if (spanishWord == null) {
			if (other.spanishWord != null)
				return false;
		} else if (!spanishWord.equals(other.spanishWord))
			return false;
		return true;
	}


	/**
	 * Método que muestra las entradas, primero palabras en español y después palabras en inglés.
	 * Sustituye al método toString de la clase Entrada.
	 * @return String
	 */
	public String entradasSpaToEng() {
		return "Spanish: " + spanishWord + " --> English: " + englishWord;
	}
	
	
	/**
	 * Método que muestra las entradas, primero palabras en inglés y después palabras en español.
	 * Sustituye al método toString de la clase Entrada.
	 * @return String
	 */
	public String entradasEngToSpa() {
		return "English: " + englishWord + " --> Spanish: " + spanishWord;
	}
	

}

//@Override
//public String toString() {
//	return "spanishWord=" + spanishWord + ", englishWord=" + englishWord;
//}
