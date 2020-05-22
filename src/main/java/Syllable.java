import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Separaçãoo das Sílabas e Determinação da
 * Tonicidade no Português Brasileiro
 *
 * Denilson C. Silva, Daniela Braga e Fernando G. V. Resende Jr
 *
 */
public class Syllable {

		
		private LinkedHashSet<Character> vogal_set;
	    private LinkedHashSet<Character>  mute_set;

	private LinkedHashSet<String> nasal_set;
		private LinkedHashSet<String> liquida_set;
		private LinkedHashSet<String> fricativa_set;
		private LinkedHashSet<String> oclusiva_set;
		private LinkedHashSet<String> digrafo_set;
		private LinkedHashSet<String> digrafos_sep_set;
		private LinkedHashSet<String> semivogal_set;


	/**
	 * Init all the lists that helps to divide the syllables
	 *
	 */
	public Syllable() {
			super();
			this.vogal_set = createVowelSet();
			this.nasal_set = createNasalSet();
			this.liquida_set = createLiquidSet();
			this.fricativa_set = createFricativeSet();
			this.oclusiva_set = createOcclusiveSet();
			this.digrafo_set = createDigraphSet();
			this.digrafos_sep_set = createDigraphSepSet();
			this.semivogal_set = createSemiVogalSet();
			this.mute_set = createMuteSet();
		}

	/**
	 * Build the list of vogais agudas
	 *
	 * @return A hash set of vogais agudas
	 */
	private LinkedHashSet<Character> createVogalAgudoCircSet(){

			LinkedHashSet<Character> vogal_set = new LinkedHashSet<Character>();

			vogal_set.add('á');
			vogal_set.add('é');
			vogal_set.add('ó');
			vogal_set.add('í');
			vogal_set.add('ú');
			vogal_set.add('â');
			vogal_set.add('ê');
			vogal_set.add('î');
			vogal_set.add('ô');
			vogal_set.add('û');
			
			vogal_set.add('à');

			return vogal_set;
		}

	/**
	 *  Build the mute consonant set
	 */

	private LinkedHashSet<Character> createMuteSet(){
		LinkedHashSet<Character> mute_set = new LinkedHashSet<Character>();

		mute_set.add('b');
		mute_set.add('g');
		mute_set.add('p');
		mute_set.add('c');
		mute_set.add('d');
		mute_set.add('f');
		mute_set.add('t');

		return  mute_set;
	}

	/**
	 *Add the tilde vogal to the hash set
 	 * @return the vogal set with tildes
	 */
	private LinkedHashSet<Character> createVogalTilSet(){
		LinkedHashSet<Character> vogal_set = new LinkedHashSet<Character>();

		vogal_set.add('ã');
		vogal_set.add('õ');

		return vogal_set;
	}

	/**
	 * Creat a set with all the vowels
	 *
	 * @return the set
	 */
	private LinkedHashSet<Character> createVowelSet(){
		LinkedHashSet<Character> vogal_set = new LinkedHashSet<Character>();
			
		vogal_set.add('a');
		vogal_set.add('e');
		vogal_set.add('o');
		vogal_set.add('á');
		vogal_set.add('é');
		vogal_set.add('ó');
		vogal_set.add('í');
		vogal_set.add('ú');
		vogal_set.add('ã');
		vogal_set.add('õ');
		vogal_set.add('â');
		vogal_set.add('ê');
		vogal_set.add('ô');
		vogal_set.add('à');
		vogal_set.add('ü');
			
		return vogal_set;
	}

	/**
	 * Test if the i-th character in string w is a vowel
 	 * @param w a word
	 * @param i a position
	 * @return true if the character i is a vowel, false otherwise
	 */
	private boolean isVowel(String w, int i){
		int wlen = w.length();
			
		if (this.vogal_set.contains(w.charAt(i))){
			return true;
			}else{
				// verificando encontros vocalicos: ditongos com i e u 
				// colocam i e u como semivogais e nao como vogais
				if (w.charAt(i) == 'i' || w.charAt(i) == 'u'){
					if (i + 1 < wlen){
						if (w.charAt(i) == 'i' && w.charAt(i + 1) == 'a' && i+2>= wlen){
							return true;
						}
					    else if (this.vogal_set.contains(w.charAt(i + 1))){
							return false;
						}else{
							if (i - 1 >= 0){
								if (this.vogal_set.contains(w.charAt(i - 1))){
									return false;
								}else return true;
							}else{
								return true;
							}
						}
					}else{
						if (i - 1 >= 0){
							if (this.vogal_set.contains(w.charAt(i - 1))){
								return false;
							}else return true;
						}else{
							return true;
						}
						
					}
				}else return false;
			}
		}

	/**
	 * Test if is semi vowel or vowel
 	 * @param c a character to test
	 * @return true if is vowe or semi vowel, false otherwise
	 */
	private boolean isVowelOrSemi(Character c){
		// is vogal or semivogal
		return this.vogal_set.contains(c) || isSemiVowel(Character.toString(c), 0);
	}

	/**
	 * Create semivowel set
	 * @return the semi vowel set
	 */
	private LinkedHashSet<String> createSemiVogalSet(){

		LinkedHashSet<String> semivogal_set = new LinkedHashSet<String>();
		semivogal_set.add("i");
		semivogal_set.add("u");
		return semivogal_set;
	}

	/**
	 * Test if the i-th character  in w is a semivowel
 	 * @param w a word
	 * @param i a position
	 * @return true if it is semivowel, false otherwise
	 */
	private boolean isSemiVowel(String w, int i){
			
		if (w.charAt(i) == 'i'){
			return true;
		}else{
			if (w.charAt(i) == 'u'){
				return true;
			}else{
				return false;
			}
		}
	}

	/**
	 * Create a digraph set .
 	 * @return a set of digraphs
	 */
	private LinkedHashSet<String> createDigraphSet(){
		LinkedHashSet<String> digrafo_set = new LinkedHashSet<String>();
			
		digrafo_set.add("lh");
		digrafo_set.add("nh");

		return digrafo_set;
	}

	/**
	 * Separte digraphs:that split "rr", "ss", "sc", "xc" e "xs"
	 * @return
	 */
	private LinkedHashSet<String> createDigraphSepSet() {
		LinkedHashSet<String> digrafo_sep_set = new LinkedHashSet<String>();

		digrafo_sep_set.add("rr");
		digrafo_sep_set.add("ss");
		digrafo_sep_set.add("sc");
		digrafo_sep_set.add("xc");
		digrafo_sep_set.add("xs");

		return digrafo_sep_set;
	}

	/**
	 * Test if a character is a digraph
	 *
	 * @param w a word
	 * @param i a position
	 * @return true if the i-th character is a digraph
	 */
	private boolean isDigraph(String w, int i){
		int wlen = w.length();
		if ( i+1 >= wlen)  return false;

		int wlensub = w.substring(i).length();

		for (String s : this.digrafo_set){

			if (wlensub >= 2 && w.substring(i, i+2).equals(s)){
				return true;
			}

		}

		return false;
	}

	/**
	 * Test if a character is a separated digraph
	 *
	 * @param w a word
	 * @param i a position
	 * @return true if the i-th character is a separated digraph
	 */
	private boolean isDigraphSep(String w, int i){
		int wlen = w.length();
		if ( i+1 >= wlen)  return false;
			
		int wlensub = w.substring(i).length();
					
		for (String s : this.digrafos_sep_set){

			if (wlensub >= 2 && w.substring(i, i+2).equals(s)){
				return true;
			}
				
		}
			
		return false;
	}

	/**
	 * Create occlusive set
	 *
 	 * @return occlusive set
	 */
	private LinkedHashSet<String> createOcclusiveSet(){
		LinkedHashSet<String> oclusivas_set = new LinkedHashSet<String>();
			
		oclusivas_set.add("p");
		oclusivas_set.add("t");
		oclusivas_set.add("b");
		oclusivas_set.add("d");
			
		oclusivas_set.add("ca");
		oclusivas_set.add("co");
		oclusivas_set.add("cu");
			
		oclusivas_set.add("ga");
		oclusivas_set.add("go");
		oclusivas_set.add("gu");
		oclusivas_set.add("gú");
			
		oclusivas_set.add("que");
		oclusivas_set.add("qui");

		oclusivas_set.add("gue");
		oclusivas_set.add("gui");
			
		return oclusivas_set;
	}

	/**
	 * Test if a character in the i-th position is occlusive
	 * @param w a word
	 * @param i a position
	 *
	 * @return true if it is occlusive, false otherwise
	 */
	private boolean isOcclusive(String w, int i){

		int wlensub = w.substring(i).length();

		for (String s : this.oclusiva_set){

			int slen = s.length();
			if (slen == 1){
				if (w.substring(i, i+1).equals(s)){
					return true;
				}
			}else{
				if (wlensub >=2 && slen == 2){
					if (w.substring(i, i+2).equals(s)){
						return true;
					}
				}else{
					if (wlensub >=3 && slen == 3){
						if (w.substring(i, i+3).equals(s)){
							return true;
						}
					}
				}
			}

		}

		return false;
	}

	/**
	 * Create the fricative set
	 *
	 * @return a set
	 */
	private LinkedHashSet<String> createFricativeSet(){
		LinkedHashSet<String> fricativas_set = new LinkedHashSet<String>();

		fricativas_set.add("f");
		fricativas_set.add("v");
		fricativas_set.add("s");
		fricativas_set.add("ç");
		fricativas_set.add("z");
		fricativas_set.add("j");
		fricativas_set.add("x");

		fricativas_set.add("ce");
		fricativas_set.add("ci");
		fricativas_set.add("ss");
		fricativas_set.add("ce");
		fricativas_set.add("ch");
		fricativas_set.add("ge");
		fricativas_set.add("gi");

		return fricativas_set;
	}

	/**
	 * Test if the character at i-th position is fricative
	 *
	 * @param w a word
	 * @param i a character
	 * @return true if it is fricative, false otherwise
	 */
	private boolean isFricative(String w, int i){

		int wlen = w.length();
		for (String s : this.fricativa_set){

			if (s.length() == 1){
				if (w.substring(i, i+1).equals(s)){
					return true;
				}
			}else{
				if ( i + 1 < wlen){
					if (w.substring(i, i+2).equals(s)){
						return true;
					}
				}
			}

		}

		return false;
	}

	/**
	 * Test if the character at i-th position is mute
	 *
	 * @param w a word
	 * @param i a character
	 * @return true if it is mute, false otherwise
	 * */
	private boolean isMuteConsonant(String w, int i){

		int wlen = w.length();
		// the position i is the end of the word
		if (i + 1 >= wlen) return false;
		if (this.mute_set.contains(w.charAt(i))){
		    if (this.vogal_set.contains(w.charAt(i + 1))) return false;
		    // What about the following w.charAt(i + 1) == 't'?
		    if (w.charAt(i + 1) == 'l' || w.charAt(i + 1) == 'r' || isVowel(w, i + 1) || isSemiVowel(w, i + 1))
					 return false;
		    return true;
		}
		return false;
	}

	/**
	 * Create a liquid consonant set
	 *
	 * @return a set
	 */
	private LinkedHashSet<String> createLiquidSet(){
		LinkedHashSet<String> liquida_set = new LinkedHashSet<String>();
		// except lh
		liquida_set.add("l");
		liquida_set.add("r");
		liquida_set.add("rr");

		return liquida_set;
	}

	/**
	 * test if the i-th character is a liquid consonant
	 * @param w a word
	 * @param i a position
	 * @return true if the character is liquid consonant, false otherwise
	 */
	private boolean isLiquid(String w, int i){

		int wlen = w.length();

		if (w.charAt(i) == 'l'){
			if (i < wlen - 1 && w.charAt(i+1) == 'h')
				return false;
			else return true;
		}else{
			if (w.charAt(i) == 'r'){
				return true;
			}else return false;
		}
	}

	/**
	 * Create the set of nasal consonant
	 * @return the set
	 */
	private LinkedHashSet<String> createNasalSet(){
		LinkedHashSet<String> nasal_set = new LinkedHashSet<String>();

		nasal_set.add("m");
		nasal_set.add("n");
		return nasal_set;
	}

	/**
	 * check if the i-th character of a word w is a nasal consonant
	 * @param w a word
	 * @param i a position
	 * @return true if it is nasal character, false otherwise
	 */
	private boolean isNasal(String w, int i){
		return  this.nasal_set.contains(w.substring(i, i+1));
	}

	/**
	 * Test if the i-th character is a consonant
	 * @param w a word
	 * @param i a position
	 * @return true if it is consonant, false otherwise
	 */
	private boolean isConsonant(String w, int i){

		if (isDigraph(w, i)){
			return true;
		}
		if (isOcclusive(w, i)){
			return true;
		}
		if (isFricative(w, i)){
			return true;
		}
		if (isLiquid(w, i)){
			return true;
		}
		if (isNasal(w, i)){
			return true;
		}
		if (w.charAt(i) == 'g')
			return true;
		if (w.charAt(i) == 'c')
			return true;
		return false;

	}

	/**
	 * Application of first part of rule 12
	 * @param w a word
	 * @param nucleo a position
	 * @return true if the rules applies, false otherwise
	 */
	private boolean rule12Part1(String w, int nucleo){

		int wlen = w.length();
		// testar a primeira condicao da regra 12
		// i eh o inicio da silaba
		if (isConsonant(w, nucleo  - 1)){
			if (nucleo + 1 < wlen && (isLiquid(w, nucleo + 1) || isNasal(w, nucleo + 1)
					|| w.charAt(nucleo + 1) == 'c'|| w.charAt(nucleo + 1) == 'x') && nucleo + 3 < wlen
					&& (isVowel(w, nucleo + 3) || w.charAt(nucleo + 3) == 'h' || w.charAt(nucleo + 3) == 'l'
					|| w.charAt(nucleo + 3) == 'r')){
				return true;

			}
		}else{
			if (nucleo - 2 >= 0 && (w.charAt(nucleo - 1) == 'u' || w.charAt(nucleo - 1) == 'ü')
					&& (w.charAt(nucleo - 2) == 'q' || w.charAt(nucleo - 2) == 'g')){
				if (nucleo + 1 < wlen && (isLiquid(w, nucleo + 1) || isNasal(w, nucleo + 1)
						|| w.charAt(nucleo + 1) == 'c' || w.charAt(nucleo + 1) == 'x')
						&& nucleo + 3 < wlen && (isVowel(w, nucleo + 3) || w.charAt(nucleo + 3) == 'h'
						|| w.charAt(nucleo + 3) == 'l' || w.charAt(nucleo + 3) == 'r')){
					return true;

				}
			}
		}

		return false;

	}

	/**
	 * Test if there is a q or g before an U in position i
	 * @param w a word
	 * @param i a position
	 * @return true if there is a q before an U
	 */
	private boolean qOrGBeforeU(String w, int i){
		// testar se existe qu em uma palavra na posicao i

		if (w.charAt(i) == 'u'){
			if ( i - 1 >= 0){
				if (w.charAt(i - 1) == 'q' || w.charAt(i - 1) == 'g') return true;
				else return false;
			} else return false;
		}else return false;
	}

	/**
	 * given a stressed grapheme, find the a vowel from i-th position
	 * @param w a word
	 * @param i a position
	 * @param stressed_graph the stressed phoneme
	 * @return the position of the vowel if it exists, -1 otherwise
	 */
	private int findVowel(String w, int i, int stressed_graph){
		int k;
		int wlen = w.length();
		for(k = i; k < wlen; k++){
			if (isVowel(w, k)){
				if (stressed_graph < k && stressed_graph>=i)
					return stressed_graph;
				else return k;
			}
		}
		return -1;
	}

	/**
	 * Find second to the last vowel in a word
	 *
	 * @param w a word
	 * @return a position if found the vowel, -1 otherwise
	 */
	private int findSecondLastVowel(String w){
		int wlen = w.length();
		int countVogal = 0;
		boolean achou = false;
		int k;

		for (k = wlen - 1; k >= 0; k--){
			if (isVowelOrSemi(w.charAt(k))){
				countVogal++;
			}
			if (countVogal == 2){
				achou = true;
				break;
			}
		}

		if (achou)
			return k;
		else return -1;
	}

	/**
	 * Following some Portuguese rules to find the stressed syllable in a word
	 *
	 * @param w a word
	 * @return the position of the stressed syllable
	 */
	private int stressedSyllable(String w){
		int stressedlevel = 100;
		int stressedpos = 0;
		int lenw = w.length();
		LinkedHashSet<Character> agudoCirc = createVogalAgudoCircSet();
		LinkedHashSet<Character> tilSet = createVogalTilSet();

		int posPenultVogal = findSecondLastVowel(w);


		for (int i = lenw - 1; i >=0 ; i--){

			if (i == lenw - 1){

				// regra 19
				if (posPenultVogal != -1 && stressedlevel > 19){
					stressedlevel = 19;
					stressedpos = posPenultVogal;
				}

				// regra 18
				if (lenw >= 4 && w.charAt(i) == 'm' && w.charAt(i - 1) == 'e'
						&& w.charAt(i - 2) == 'u' && w.charAt(i - 3) == 'q' && stressedlevel > 18){
					stressedlevel = 18;
					stressedpos = i - 1;
				}

				// regra 17
				if (posPenultVogal != -1 && stressedlevel > 17){
					if (w.charAt(posPenultVogal) == 'i' || w.charAt(posPenultVogal) == 'u'){
						if (posPenultVogal - 1>= 0 && isVowelOrSemi(w.charAt(posPenultVogal - 1)) && posPenultVogal + 1 < lenw
								&& !isVowelOrSemi(w.charAt(posPenultVogal + 1))){

							if ((posPenultVogal - 2) >= 0){
								if (w.charAt(posPenultVogal - 2) != 'q' && w.charAt(posPenultVogal - 2) != 'g'){
									stressedlevel = 17;
									stressedpos = posPenultVogal - 1;
								}
							}else{
								stressedlevel = 17;
								stressedpos = posPenultVogal - 1;
							}
						}
					}
				}

				// regra 16
				if (lenw > 4 && (w.charAt(i) == 'a' || w.charAt(i) == 'e'
						|| w.charAt(i) == 'o') && isConsonant(w, i - 1) && w.charAt(i - 2) == 'n'
						&& (w.charAt(i - 3) == 'i' || w.charAt(i - 3) == 'u') && isVowelOrSemi(w.charAt(i - 4))
						&& stressedlevel > 16){
					stressedpos = i - 3;
					stressedlevel = 16;
				}

				// regra 15
				if (lenw >= 6 && w.charAt(i) == 's' && isVowel(w, i - 1)
						&& isVowel(w, i - 4) && (w.charAt(i - 3) == 'i' || w.charAt(i - 3) == 'u')
						&& !isVowel(w, i - 2) && w.charAt(i - 5) != 'q' && w.charAt(i - 5) != 'g'
						&& stressedlevel > 15){
					stressedpos = i - 4;
					stressedlevel = 15;
				}

				//regra 14

				if (lenw >= 5 && isVowel(w, i) && isVowel(w, i - 3)
						&& (w.charAt(i - 2) == 'i' || w.charAt(i - 2) == 'u') && !isVowel(w, i - 1)
						&& w.charAt(i - 4) != 'q' && w.charAt(i - 4) != 'g' && stressedlevel > 14){

					stressedpos  = i - 3;
					stressedlevel = 14;
				}

				//regra 13
				if (lenw >= 3 && isVowel(w, i) && (w.charAt(i - 1) == 'i'
						|| w.charAt(i - 1) == 'u') && isVowel(w, i - 2)
						&& stressedlevel > 13){

					stressedpos  = i - 2;
					stressedlevel = 13;
				}


				//regra 12
				if (lenw >= 5 && w.charAt(i) == 's' && w.charAt(i - 1) == 'e'
						&& w.charAt(i - 2) == 'u' && (w.charAt(i - 3) == 'q' || w.charAt(i - 3) == 'g')
						&& stressedlevel > 12){

					if (isVowelOrSemi(w.charAt(i - 4))){
						stressedpos  = i - 4;
					}else{
						stressedpos  = i - 5;
					}
					stressedlevel = 12;
				}

				// regra 11
				if (lenw >= 4 && w.charAt(i) == 'e' && w.charAt(i - 1) == 'u'
						&& (w.charAt(i - 2) == 'q' || w.charAt(i - 2) == 'g') && stressedlevel > 11){

					if (isVowelOrSemi(w.charAt(i - 3))){
						stressedpos  = i - 3;
					}else{
						stressedpos  = i - 4;
					}
					stressedlevel = 11;
				}

				//regra 10
				if (lenw > 5 && i >=5 && w.charAt(i) == 'e' && w.charAt(i - 1) == 'u' && w.charAt(i - 2) == 'q'
						&& w.charAt(i - 3) == 'r' && w.charAt(i - 4) == 'o' && w.charAt(i - 5) == 'p'
						&& stressedlevel > 10){
					stressedlevel = 10;
					stressedpos = i;
				}

				// regra 9
				if (i - 2 >= 0 && w.charAt(i) == 's' && (w.charAt(i - 1) == 'i' || w.charAt(i - 1) == 'u')
						&& !isVowel(w, i-2) && stressedlevel > 9){
					stressedlevel = 9;
					stressedpos = i - 1;
				}

				// regra 8
				if (i - 1 >= 0 && i - 2 >= 0 &&  w.charAt(i) == 's' && (w.charAt(i - 1) == 'i' || w.charAt(i - 1) == 'u')
						&& isVowelOrSemi(w.charAt(i-2)) && stressedlevel > 8){
					stressedlevel = 8;
					stressedpos = i - 2;
				}

				// regra 7
				if ((w.charAt(i) == 'i' || w.charAt(i) == 'u') && stressedlevel > 7){
					if (i-1>= 0 && isVowelOrSemi(w.charAt(i-1)) && w.charAt(i-1) != 'u'){
						stressedpos = i - 1;
					}else{
						stressedpos = i;
					}

					stressedlevel = 7;

				}

				// regra 6
				if (i-3>=0 && w.charAt(i) == 's' && w.charAt(i-1) == 'i'
						&& (w.charAt(i-2) == 'u' || w.charAt(i-2) == 'ü')
						&& (w.charAt(i-3) == 'q' || w.charAt(i-3) == 'g')
						&& stressedlevel > 6){
					stressedlevel = 6;
					stressedpos = i - 1;
				}

				// regra 5
				if (i-2>= 0 && w.charAt(i) == 'i' && (w.charAt(i-1) == 'u' || w.charAt(i-1) == 'ü')
						&& (w.charAt(i-2) == 'q' || w.charAt(i-2) == 'g')
						&& stressedlevel > 5){
					stressedlevel = 5;
					stressedpos = i;

				}

				// regra 4
				if (i-2>= 0 && w.charAt(i) == 's' && w.charAt(i-1) == 'n'
						&& (w.charAt(i-2) == 'i' || w.charAt(i-2) == 'o' || w.charAt(i-2) == 'u')
						&& stressedlevel > 4){
					stressedlevel = 4;
					stressedpos = i - 2;

				}

				// regra 3
				if (i-1>= 0 && w.charAt(i) == 'm' && (w.charAt(i-1) == 'i'
						|| w.charAt(i-1) == 'o' || w.charAt(i-1) == 'u')
						&& stressedlevel > 3){
					stressedlevel = 3;
					stressedpos = i - 1;
				}

				// regra 2
				if ((w.charAt(i) == 'r' || w.charAt(i) == 'l'
						|| w.charAt(i) == 'z' || w.charAt(i) == 'x' || w.charAt(i) == 'n')
						&& stressedlevel > 2){
					stressedlevel = 2;
					stressedpos = i - 1;

				}
			}

			// regra 1
			if (agudoCirc.contains(w.charAt(i))){
				stressedlevel = 0;
				stressedpos = i;
			}else{
				//regra 1 ainda: mas com o til
				if (tilSet.contains(w.charAt(i)) && stressedlevel > 1){
					stressedlevel = 1;
					stressedpos = i;
				}
			}
			//break;
		}

		return stressedpos;
	}

	/**
	 * Get a syllable beginning in begin and ending in end
	 * @param w word to get the syllable
	 * @param begin where start the syllable
	 * @param end where end the syllable
	 * @return a syllable
	 */
	private String getSyllable(String w, int begin, int end) {
         String s = "";
         for (int k = begin; k <= end; k++) {
         	s = s + w.charAt(k);
		 }
         return s;
	}

	/**
	 * Given a word, returns an array with its syllables
	 *
	 * @param w a word
	 * @return ArrayList with strings, each one is a syllable of w
	 */
	public ArrayList<String> word2syllables(String w){

		ArrayList<String> s = new ArrayList<String>();
		int wlen = w.length();



		String syll = "";
		int stressed_graph = stressedSyllable(w); // stressed grapheme in word w
		int begin, end; // where the syllable starts and where it ends

		for (int i = 0; i < wlen ;){
			// a vogal eh o nucleo da silaba
			int nucleo = findVowel(w, i, stressed_graph);

			if (this.vogal_set.contains(w.charAt(i)) || w.charAt(i) == 'i' || w.charAt(i) == 'u'){

				// regra para os ditongos decrescentes
				if (i + 1 < wlen && (w.charAt(i) == 'a' || w.charAt(i) == 'e' || w.charAt(i) == 'o')
						&& (w.charAt(i+1) == 'i' || w.charAt(i+1) == 'u')){

					begin = i;
					end = i;

					if (stressed_graph != (i+1)){
                        end = i + 1;
					}

				}else if (w.charAt(i) != 'ã' && w.charAt(i) != 'õ'
						&& i+1 < wlen && isVowel(w, i+1)
						&& !isSemiVowel(w, i+1)){
					//regra 1
                    begin = i;
                    end = i;

				}else if (i+3 < wlen &&
						isConsonant(w, i+1) &&
						isConsonant(w, i + 2) &&
						(isOcclusive(w, i+3) || isLiquid(w, i+3) || isDigraphSep(w, i + 2))){
					// regra 2
					// modificada com o artigo do Rocha e Neto
					if (isOcclusive(w, i+3) || isDigraphSep(w, i + 2)) {
						begin = i;
						end = i + 2;
					} else {
						begin = i;
						end = i + 1;
					}

				}else if (i+2 < wlen && (isSemiVowel(w, i+1) || isNasal(w, i+1)
						|| w.charAt(i+1) == 's' || w.charAt(i+1) == 'r'
						|| w.charAt(i+1) == 'l' || w.charAt(i+1) == 'x')
						//&& isConsonant(w, i+2) && w.charAt(i+2) != 's'
						&& isConsonant(w, i + 2)
						&& w.charAt(i+2) != 'h' && w.charAt(i+2) != 'r'){
					// regra 3
                    begin = i;
                    end = i + 1;
				}else if (i+3 < wlen && isConsonant(w, i+1) && isConsonant(w, i+2) && isVowel(w, i+3)){
					//regra 4: modificada com o artigo do Rocha e Neto
                    begin = i;
                    end = i;
					if (isMuteConsonant(w, i + 1)) {
						end = i + 1;
					}

				}else if (i + 3 < wlen && isDigraph(w, i+1) && (isVowel(w, i + 3) || isLiquid(w, i + 3))) {
					// A regra 5 tem duas partes para quando a consoante for um digrafo
					// regra 5: alho
                    begin = i;
                    end = i;

				} else if (i+2 < wlen && isConsonant(w, i + 1) && (isVowel(w, i + 2) || isLiquid(w, i + 2))){
					// regra 5: arrendar
                    begin = i;
                    end = i;

				} else if (i + 1 < wlen && isOcclusive(w, i +1)){
					// regra 5 - 1: testando essa regra para aguardo
					begin = i;
					end = i;
				}
				else{
					begin = i; // comeco da silaba
					end = wlen - 1;
				}

				syll = getSyllable(w, begin, end);
				i = i + (end - begin);
				s.add(syll);
				syll = "";

			}else{

				if (nucleo - 1 >= 0){

					if (nucleo + 3 < wlen && isConsonant(w, nucleo - 1) && (isDigraph(w, nucleo + 1)
							|| (w.charAt(nucleo + 1) == 'c' && w.charAt(nucleo + 2) == 'h'))
							&& nucleo + 3 < wlen && isVowel(w, nucleo + 3) ){
						// regra 6
                        begin = i;
                        end = nucleo;

					}else if (nucleo + 1 < wlen && isConsonant(w, nucleo - 1) && nucleo + 2 < wlen
							&& isConsonant(w, nucleo + 1) && isVowel(w, nucleo + 2)) {
						// regra 6
                        begin = i;
                        end = nucleo;

					} else if (nucleo + 3 < wlen && isConsonant(w, nucleo - 1) && isSemiVowel(w, nucleo + 1)
							&& w.charAt(nucleo + 2) == 's' && isOcclusive(w, nucleo + 3)){
						// regra 8
						begin = i;
						end = nucleo + 2;

					}else if (nucleo + 3 < wlen && isConsonant(w, nucleo - 1) && isSemiVowel(w, nucleo + 1)
							&& w.charAt(nucleo + 2) == 'r' && isConsonant(w, nucleo + 3)){
						// regra 11
						begin = i;
						end = nucleo + 2;

					} else if ((isConsonant(w, nucleo - 1) || isSemiVowel(w, nucleo - 1))
							&& nucleo + 2 < wlen && isSemiVowel(w, nucleo + 1) && isConsonant(w, nucleo + 2)
							&& ((nucleo + 2 == wlen - 1 && w.charAt(nucleo + 2) != 'm' && w.charAt(nucleo + 2) != 'n'
							&& w.charAt(nucleo + 2) != 'r' && w.charAt(nucleo + 2) != 's') || (nucleo + 2 != wlen - 1))){
						// regra 7

						begin = i;
						end = nucleo + 1;

					}else if (nucleo + 1 < wlen && isConsonant(w, nucleo - 1) && isSemiVowel(w, nucleo + 1)
							&& (nucleo + 2 >= wlen || (nucleo + 2 < wlen && isVowel(w, nucleo + 2)))){
						// regra 9
						begin = i;
						end = nucleo + 1;

					}else if (nucleo + 2 < wlen && isSemiVowel(w, nucleo - 1) && isConsonant(w, nucleo + 1)
							&& isVowel(w, nucleo + 2)){
						// regra 10
						begin = i;
						end = nucleo - 1;
						// san-guí-neo, se a semivogal eh antecedida por g ou q, nao separar V
						if (nucleo - 2 >= 0 && qOrGBeforeU(w, nucleo - 1)) {
							// V eh unida ao grafema anterior e separada dos demais (caso 3)
							end = nucleo;
						}

					}else if (rule12Part1(w, nucleo)){
						begin = i;
						end = nucleo + 1; // segundo caso do artigo: eh unido ao grafema seguinte

						if (w.charAt(nucleo + 2) == 'h' || w.charAt(nucleo + 2) == 'l'
								|| w.charAt(nucleo + 2) == 'r' || w.charAt(nucleo + 1) == 'c'
								|| (isNasal(w, nucleo + 1) && isVowel(w, nucleo + 2))){
							// com modificacao para os casos: sócio, canal..
							// regra 12
							// caso seja rr, entao nao faça mais nenhuma modificacao quanto a uniao ao
							// proximo grafema
							if (!isMuteConsonant(w, nucleo + 1) && w.charAt(nucleo + 1) != w.charAt(nucleo + 2)){
								end = nucleo ; // V nao sera mais unido ao grafema seguinte
							}

						}

					}else if (nucleo + 1 < wlen && isConsonant(w, nucleo - 1) && (isLiquid(w, nucleo + 1)
							|| isNasal(w, nucleo + 1) || w.charAt(nucleo + 1) == 'i')){
						// regra 13
						begin = i;
						end = nucleo + 2;

						if (nucleo +2 >= wlen){
							// caso 6
							end = wlen - 1;
						} else{
							// caso : sanguineo
							if (nucleo + 3 < wlen && qOrGBeforeU(w, nucleo + 3)){
								end = nucleo + 1;
							}
						}
						//i = i + (end - begin) + 1;
					}else if ((w.charAt(nucleo) == 'ã' || w.charAt(nucleo) == 'õ') && nucleo - 1 >= 0
							&& isConsonant(w, nucleo - 1) && nucleo + 1 < wlen && (w.charAt(nucleo + 1) == 'o'
							|| w.charAt(nucleo + 1) == 'e')){
						// regra 17
						begin = i;
						end = wlen - 1;
						// i = i + (end - begin) + 1;

					}else if ((nucleo + 1 < wlen && isVowel(w, nucleo + 1) )
							|| (nucleo + 2 < wlen && isVowel(w, nucleo + 1) && isVowel(w, nucleo + 2))){
						// TODO: regra 14 (?) duvidas nessa regra (bueiro???)
						// cachoeira, padroeira, vogal seguido de ditongo
						// A sequencia de letras eir + vogal nao cumpre a regra de hiato
						begin = i;
						end = nucleo;
						if (nucleo + 4 < wlen &&
								isVowel(w,nucleo + 1) &&
								isSemiVowel(w, nucleo + 2) &&
								w.charAt(nucleo + 3) == 'r' &&
								isVowel(w, nucleo + 4)){
							end = nucleo + 2;
						}

					}else if (nucleo + 3 < wlen && (isOcclusive(w, nucleo + 1) || w.charAt(nucleo + 1) == 'f'
							|| w.charAt(nucleo + 1) == 'v' || w.charAt(nucleo + 1) == 'g') && (isOcclusive(w, nucleo + 2)
							|| isLiquid(w, nucleo + 2)) && isVowel(w, nucleo + 3)){
						// regra 15
						// modificacao conforma artigo de Rocha e Neto
						begin = i;
						end = nucleo;
						if (isMuteConsonant(w, nucleo + 1)){
							end = nucleo + 1;
						}

					}else if ( nucleo - 1 >= 0 && w.charAt(nucleo) == 'i' && isConsonant(w, nucleo - 1)
							&& nucleo + 1 < wlen && (w.charAt(nucleo + 1) == 'a' || w.charAt(nucleo + 1) == 'o')
							&& nucleo + 2 >= wlen){
						// TODO: rever essa regra (a ação dela) // regra 16
						begin = i;
						end = nucleo;

					}else if (nucleo - 1 >= 0 && (isConsonant(w, nucleo - 1) || qOrGBeforeU(w, nucleo - 1))
							&& nucleo + 2 < wlen && isConsonant(w, nucleo + 1) && isConsonant(w, nucleo + 2)){

						begin = i;
						end = nucleo + 2;
						if (w.charAt(nucleo + 1) == w.charAt(nucleo + 2) ||
								(w.charAt(nucleo + 1) == 's' && w.charAt(nucleo + 2) != 's')){
								//  caso 2
							end = nucleo + 1;
						}

					} else if (nucleo + 2 < wlen && isVowel(w, nucleo + 1) && isConsonant(w, nucleo + 2)){
						// regra 19
						begin = i;
						end = nucleo; // caso 1: V eh separada do grafema seguinte
                        if (nucleo + 3 < wlen && isVowel(w, nucleo + 3)){
							//  caso 2
							end = nucleo + 1;
						}

					}else{
						begin = i;
						end = wlen - 1;
					}

					syll = getSyllable(w, begin, end);
					i = i + (end - begin);
					s.add(syll);
					syll = "";
				}
			}

			i = i + 1;
			//break;
		}

		return s;
	}



}
