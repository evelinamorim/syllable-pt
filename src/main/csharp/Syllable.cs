using System;
using System.Collections;
using System.Collections.Generic;

/**
 * Separaçãoo das Sílabas e Determinação da
 * Tonicidade no Português Brasileiro
 *
 * Denilson C. Silva, Daniela Braga e Fernando G. V. Resende Jr
 *
 */
public class Syllable {

		
	private HashSet<char> vogal_set;
	private HashSet<char>  mute_set;

	private HashSet<string> nasal_set;
	private HashSet<string> liquida_set;
	private HashSet<string> fricativa_set;
	private HashSet<string> oclusiva_set;
	private HashSet<string> digrafo_set;
	private HashSet<string> digrafos_sep_set;
	private HashSet<string> semivogal_set;


	/**
	 * Init all the lists that helps to divide the syllables
	 *
	 */
	public Syllable() {
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
	private HashSet<char> createVogalAgudoCircSet(){

			HashSet<char> vogal_set = new HashSet<char>();

			vogal_set.Add('á');
			vogal_set.Add('é');
			vogal_set.Add('ó');
			vogal_set.Add('í');
			vogal_set.Add('ú');
			vogal_set.Add('â');
			vogal_set.Add('ê');
			vogal_set.Add('î');
			vogal_set.Add('ô');
			vogal_set.Add('û');
			vogal_set.Add('à');

			return vogal_set;
		}

	/**
	 *  Build the mute consonant set
	 */

	private HashSet<char> createMuteSet(){
		HashSet<char> mute_set = new HashSet<char>();

		mute_set.Add('b');
		mute_set.Add('g');
		mute_set.Add('p');
		mute_set.Add('c');
		mute_set.Add('d');
		mute_set.Add('f');
		mute_set.Add('t');

		return  mute_set;
	}

	/**
	 *Add the tilde vogal to the hash set
 	 * @return the vogal set with tildes
	 */
	private HashSet<char> createVogalTilSet(){
		HashSet<char> vogal_set = new HashSet<char>();

		vogal_set.Add('ã');
		vogal_set.Add('õ');

		return vogal_set;
	}

	/**
	 * Creat a set with all the vowels
	 *
	 * @return the set
	 */
	private HashSet<char> createVowelSet(){
		HashSet<char> vogal_set = new HashSet<char>();
			
		vogal_set.Add('a');
		vogal_set.Add('e');
		vogal_set.Add('o');
		vogal_set.Add('á');
		vogal_set.Add('é');
		vogal_set.Add('ó');
		vogal_set.Add('í');
		vogal_set.Add('ú');
		vogal_set.Add('ã');
		vogal_set.Add('õ');
		vogal_set.Add('â');
		vogal_set.Add('ê');
		vogal_set.Add('ô');
		vogal_set.Add('à');
		vogal_set.Add('ü');
			
		return vogal_set;
	}

	/**
	 * Test if the i-th character in string w is a vowel
 	 * @param w a word
	 * @param i a position
	 * @return true if the character i is a vowel, false otherwise
	 */
	private bool isVowel(string w, int i){
		int wlen = w.Length;
			
		if (this.vogal_set.Contains(w[i])){
			return true;
			}else{
				// verificando encontros vocalicos: ditongos com i e u 
				// colocam i e u como semivogais e nao como vogais
				if (w[i] == 'i' || w[i] == 'u'){
					if (i + 1 < wlen){
						if (w[i] == 'i' && w[i + 1] == 'a' && i+2>= wlen){
							return true;
						}
					    else if (this.vogal_set.Contains(w[i + 1])){
							return false;
						}else{
							if (i - 1 >= 0){
								if (this.vogal_set.Contains(w[i - 1])){
									return false;
								}else return true;
							}else{
								return true;
							}
						}
					}else{
						if (i - 1 >= 0){
							if (this.vogal_set.Contains(w[i - 1])){
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
	private bool isVowelOrSemi(char c){
		// is vogal or semivogal
		return this.vogal_set.Contains(c) || isSemiVowel(c.ToString(), 0);
	}

	/**
	 * Create semivowel set
	 * @return the semi vowel set
	 */
	private HashSet<string> createSemiVogalSet(){

		HashSet<string> semivogal_set = new HashSet<string>();
		semivogal_set.Add("i");
		semivogal_set.Add("u");
		return semivogal_set;
	}

	/**
	 * Test if the i-th character  in w is a semivowel
 	 * @param w a word
	 * @param i a position
	 * @return true if it is semivowel, false otherwise
	 */
	private bool isSemiVowel(string w, int i){
			
		if (w[i] == 'i'){
			return true;
		}else{
			if (w[i] == 'u'){
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
	private HashSet<string> createDigraphSet(){
		HashSet<string> digrafo_set = new HashSet<string>();
			
		digrafo_set.Add("lh");
		digrafo_set.Add("nh");

		return digrafo_set;
	}

	/**
	 * Separte digraphs:that split "rr", "ss", "sc", "xc" e "xs"
	 * @return
	 */
	private HashSet<string> createDigraphSepSet() {
		HashSet<string> digrafo_sep_set = new HashSet<string>();

		digrafo_sep_set.Add("rr");
		digrafo_sep_set.Add("ss");
		digrafo_sep_set.Add("sc");
		digrafo_sep_set.Add("xc");
		digrafo_sep_set.Add("xs");

		return digrafo_sep_set;
	}

	/**
	 * Test if a character is a digraph
	 *
	 * @param w a word
	 * @param i a position
	 * @return true if the i-th character is a digraph
	 */
	private bool isDigraph(string w, int i){
		int wlen = w.Length;
		if ( i+1 >= wlen)  return false;

		var subw = w.Substring(i);
		int wlensub = subw.Length;

		foreach (var s in this.digrafo_set)
		{
			var subw2 = w.Substring(i, 2);
			if (wlensub >= 2 && subw2.Equals(s)){
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
	private bool isDigraphSep(string w, int i){
		int wlen = w.Length;
		if ( i+1 >= wlen)  return false;
			
		int wlensub = w.Substring(i).Length;
					
		foreach (var s in this.digrafos_sep_set)
		{
			if (wlensub >= 2 && w.Substring(i, 2).Equals(s)){
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
	private HashSet<string> createOcclusiveSet(){
		HashSet<string> oclusivas_set = new HashSet<string>();
			
		oclusivas_set.Add("p");
		oclusivas_set.Add("t");
		oclusivas_set.Add("b");
		oclusivas_set.Add("d");
			
		oclusivas_set.Add("ca");
		oclusivas_set.Add("co");
		oclusivas_set.Add("cu");
			
		oclusivas_set.Add("ga");
		oclusivas_set.Add("go");
		oclusivas_set.Add("gu");
		oclusivas_set.Add("gú");
			
		oclusivas_set.Add("que");
		oclusivas_set.Add("qui");

		oclusivas_set.Add("gue");
		oclusivas_set.Add("gui");
			
		return oclusivas_set;
	}

	/**
	 * Test if a character in the i-th position is occlusive
	 * @param w a word
	 * @param i a position
	 *
	 * @return true if it is occlusive, false otherwise
	 */
	private bool isOcclusive(string w, int i){

		int wlensub = w.Substring(i).Length;

		foreach (var s in this.oclusiva_set)
		{
			int slen = s.Length;
			if (slen == 1){
				if (w.Substring(i, 1).Equals(s)){
					return true;
				}
			}else{
				if (wlensub >=2 && slen == 2){
					if (w.Substring(i, 2).Equals(s)){
						return true;
					}
				}else{
					if (wlensub >=3 && slen == 3){
						if (w.Substring(i, 3).Equals(s)){
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
	private HashSet<string> createFricativeSet(){
		HashSet<string> fricativas_set = new HashSet<string>();

		fricativas_set.Add("f");
		fricativas_set.Add("v");
		fricativas_set.Add("s");
		fricativas_set.Add("ç");
		fricativas_set.Add("z");
		fricativas_set.Add("j");
		fricativas_set.Add("x");

		fricativas_set.Add("ce");
		fricativas_set.Add("ci");
		fricativas_set.Add("ss");
		fricativas_set.Add("ce");
		fricativas_set.Add("ch");
		fricativas_set.Add("ge");
		fricativas_set.Add("gi");

		return fricativas_set;
	}

	/**
	 * Test if the character at i-th position is fricative
	 *
	 * @param w a word
	 * @param i a character
	 * @return true if it is fricative, false otherwise
	 */
	private bool isFricative(string w, int i){

		int wlen = w.Length;

		foreach (var s in this.fricativa_set)
		{
			if (s.Length == 1){
				if (w.Substring(i, 1).Equals(s)){
					return true;
				}
			}else{
				if ( i + 1 < wlen){
					if (w.Substring(i, 2).Equals(s)){
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
	private bool isMuteConsonant(string w, int i){

		int wlen = w.Length;
		// the position i is the end of the word
		if (i + 1 >= wlen) return false;
		if (this.mute_set.Contains(w[i])){
		    if (this.vogal_set.Contains(w[i + 1])) return false;
		    // What about the following w[i + 1) == 't'?
		    if (w[i + 1] == 'l' || w[i + 1] == 'r' || isVowel(w, i + 1) || isSemiVowel(w, i + 1))
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
	private HashSet<string> createLiquidSet(){
		HashSet<string> liquida_set = new HashSet<string>();
		// except lh
		liquida_set.Add("l");
		liquida_set.Add("r");
		liquida_set.Add("rr");

		return liquida_set;
	}

	/**
	 * test if the i-th character is a liquid consonant
	 * @param w a word
	 * @param i a position
	 * @return true if the character is liquid consonant, false otherwise
	 */
	private bool isLiquid(string w, int i){

		int wlen = w.Length;

		if (w[i] == 'l'){
			if (i < wlen - 1 && w[i+1] == 'h')
				return false;
			else return true;
		}else{
			if (w[i] == 'r'){
				return true;
			}else return false;
		}
	}

	/**
	 * Create the set of nasal consonant
	 * @return the set
	 */
	private HashSet<string> createNasalSet(){
		HashSet<string> nasal_set = new HashSet<string>();

		nasal_set.Add("m");
		nasal_set.Add("n");
		return nasal_set;
	}

	/**
	 * check if the i-th character of a word w is a nasal consonant
	 * @param w a word
	 * @param i a position
	 * @return true if it is nasal character, false otherwise
	 */
	private bool isNasal(string w, int i){
		return  this.nasal_set.Contains(w.Substring(i, 1));
	}

	/**
	 * Test if the i-th character is a consonant
	 * @param w a word
	 * @param i a position
	 * @return true if it is consonant, false otherwise
	 */
	private bool isConsonant(string w, int i){

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
		if (w[i] == 'g'){
			return true;
		}
		if (w[i] == 'c'){
			return true;
		}
		return false;
	}

	/**
	 * Application of first part of rule 12
	 * @param w a word
	 * @param nucleo a position
	 * @return true if the rules applies, false otherwise
	 */
	private bool rule12Part1(string w, int nucleo){

		int wlen = w.Length;
		// testar a primeira condicao da regra 12
		// i eh o inicio da silaba
		if (isConsonant(w, nucleo  - 1)){
			if (nucleo + 1 < wlen && (isLiquid(w, nucleo + 1) || isNasal(w, nucleo + 1)
					|| w[nucleo + 1] == 'c'|| w[nucleo + 1] == 'x') && nucleo + 3 < wlen
					&& (isVowel(w, nucleo + 3) || w[nucleo + 3] == 'h' || w[nucleo + 3] == 'l'
					|| w[nucleo + 3] == 'r')){
				return true;

			}
		}else{
			if (nucleo - 2 >= 0 && (w[nucleo - 1] == 'u' || w[nucleo - 1] == 'ü')
					&& (w[nucleo - 2] == 'q' || w[nucleo - 2] == 'g')){
				if (nucleo + 1 < wlen && (isLiquid(w, nucleo + 1) || isNasal(w, nucleo + 1)
						|| w[nucleo + 1] == 'c' || w[nucleo + 1] == 'x')
						&& nucleo + 3 < wlen && (isVowel(w, nucleo + 3) || w[nucleo + 3] == 'h'
						|| w[nucleo + 3] == 'l' || w[nucleo + 3] == 'r')){
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
	private bool qOrGBeforeU(string w, int i){
		// testar se existe qu em uma palavra na posicao i

		if (w[i] == 'u'){
			if ( i - 1 >= 0){
				if (w[i - 1] == 'q' || w[i - 1] == 'g') return true;
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
	private int findVowel(string w, int i, int stressed_graph){
		int k;
		int wlen = w.Length;
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
	private int findSecondLastVowel(string w){
		int wlen = w.Length;
		int countVogal = 0;
		bool achou = false;
		int k;

		for (k = wlen - 1; k >= 0; k--){
			if (isVowelOrSemi(w[k])){
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
	private int stressedSyllable(string w){
		int stressedlevel = 100;
		int stressedpos = 0;
		int lenw = w.Length;
		HashSet<char> agudoCirc = createVogalAgudoCircSet();
		HashSet<char> tilSet = createVogalTilSet();

		int posPenultVogal = findSecondLastVowel(w);


		for (int i = lenw - 1; i >=0 ; i--){

			if (i == lenw - 1){

				// regra 19
				if (posPenultVogal != -1 && stressedlevel > 19){
					stressedlevel = 19;
					stressedpos = posPenultVogal;
				}

				// regra 18
				if (lenw >= 4 && w[i] == 'm' && w[i - 1] == 'e'
						&& w[i - 2] == 'u' && w[i - 3] == 'q' && stressedlevel > 18){
					stressedlevel = 18;
					stressedpos = i - 1;
				}

				// regra 17
				if (posPenultVogal != -1 && stressedlevel > 17){
					if (w[posPenultVogal] == 'i' || w[posPenultVogal] == 'u'){
						if (posPenultVogal - 1>= 0 && isVowelOrSemi(w[posPenultVogal - 1]) && posPenultVogal + 1 < lenw
								&& !isVowelOrSemi(w[posPenultVogal + 1])){

							if ((posPenultVogal - 2) >= 0){
								if (w[posPenultVogal - 2] != 'q' && w[posPenultVogal - 2] != 'g'){
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
				if (lenw > 4 && (w[i] == 'a' || w[i] == 'e'
						|| w[i] == 'o') && isConsonant(w, i - 1) && w[i - 2] == 'n'
						&& (w[i - 3] == 'i' || w[i - 3] == 'u') && isVowelOrSemi(w[i - 4])
						&& stressedlevel > 16){
					stressedpos = i - 3;
					stressedlevel = 16;
				}

				// regra 15
				if (lenw >= 6 && w[i] == 's' && isVowel(w, i - 1)
						&& isVowel(w, i - 4) && (w[i - 3] == 'i' || w[i - 3] == 'u')
						&& !isVowel(w, i - 2) && w[i - 5] != 'q' && w[i - 5] != 'g'
						&& stressedlevel > 15){
					stressedpos = i - 4;
					stressedlevel = 15;
				}

				//regra 14

				if (lenw >= 5 && isVowel(w, i) && isVowel(w, i - 3)
						&& (w[i - 2] == 'i' || w[i - 2] == 'u') && !isVowel(w, i - 1)
						&& w[i - 4] != 'q' && w[i - 4] != 'g' && stressedlevel > 14){

					stressedpos  = i - 3;
					stressedlevel = 14;
				}

				//regra 13
				if (lenw >= 3 && isVowel(w, i) && (w[i - 1] == 'i'
						|| w[i - 1] == 'u') && isVowel(w, i - 2)
						&& stressedlevel > 13){

					stressedpos  = i - 2;
					stressedlevel = 13;
				}


				//regra 12
				if (lenw >= 5 && w[i] == 's' && w[i - 1] == 'e'
						&& w[i - 2] == 'u' && (w[i - 3] == 'q' || w[i - 3] == 'g')
						&& stressedlevel > 12){

					if (isVowelOrSemi(w[i - 4])){
						stressedpos  = i - 4;
					}else{
						stressedpos  = i - 5;
					}
					stressedlevel = 12;
				}

				// regra 11
				if (lenw >= 4 && w[i] == 'e' && w[i - 1] == 'u'
						&& (w[i - 2] == 'q' || w[i - 2] == 'g') && stressedlevel > 11){

					if (isVowelOrSemi(w[i - 3])){
						stressedpos  = i - 3;
					}else{
						stressedpos  = i - 4;
					}
					stressedlevel = 11;
				}

				//regra 10
				if (lenw > 5 && i >=5 && w[i] == 'e' && w[i - 1] == 'u' && w[i - 2] == 'q'
						&& w[i - 3] == 'r' && w[i - 4] == 'o' && w[i - 5] == 'p'
						&& stressedlevel > 10){
					stressedlevel = 10;
					stressedpos = i;
				}

				// regra 9
				if (i - 2 >= 0 && w[i] == 's' && (w[i - 1] == 'i' || w[i - 1] == 'u')
						&& !isVowel(w, i-2) && stressedlevel > 9){
					stressedlevel = 9;
					stressedpos = i - 1;
				}

				// regra 8
				if (i - 1 >= 0 && i - 2 >= 0 &&  w[i] == 's' && (w[i - 1] == 'i' || w[i - 1] == 'u')
						&& isVowelOrSemi(w[i-2]) && stressedlevel > 8){
					stressedlevel = 8;
					stressedpos = i - 2;
				}

				// regra 7
				if ((w[i] == 'i' || w[i] == 'u') && stressedlevel > 7){
					if (i-1>= 0 && isVowelOrSemi(w[i-1]) && w[i-1] != 'u'){
						stressedpos = i - 1;
					}else{
						stressedpos = i;
					}

					stressedlevel = 7;

				}

				// regra 6
				if (i-3>=0 && w[i] == 's' && w[i-1] == 'i'
						&& (w[i-2] == 'u' || w[i-2] == 'ü')
						&& (w[i-3] == 'q' || w[i-3] == 'g')
						&& stressedlevel > 6){
					stressedlevel = 6;
					stressedpos = i - 1;
				}

				// regra 5
				if (i-2>= 0 && w[i] == 'i' && (w[i-1] == 'u' || w[i-1] == 'ü')
						&& (w[i-2] == 'q' || w[i-2] == 'g')
						&& stressedlevel > 5){
					stressedlevel = 5;
					stressedpos = i;

				}

				// regra 4
				if (i-2>= 0 && w[i] == 's' && w[i-1] == 'n'
						&& (w[i-2] == 'i' || w[i-2] == 'o' || w[i-2] == 'u')
						&& stressedlevel > 4){
					stressedlevel = 4;
					stressedpos = i - 2;

				}

				// regra 3
				if (i-1>= 0 && w[i] == 'm' && (w[i-1] == 'i'
						|| w[i-1] == 'o' || w[i-1] == 'u')
						&& stressedlevel > 3){
					stressedlevel = 3;
					stressedpos = i - 1;
				}

				// regra 2
				if ((w[i] == 'r' || w[i] == 'l'
						|| w[i] == 'z' || w[i] == 'x' || w[i] == 'n')
						&& stressedlevel > 2){
					stressedlevel = 2;
					stressedpos = i - 1;

				}
			}

			// regra 1
			if (agudoCirc.Contains(w[i])){
				stressedlevel = 0;
				stressedpos = i;
			}else{
				//regra 1 ainda: mas com o til
				if (tilSet.Contains(w[i]) && stressedlevel > 1){
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
	private string getSyllable(string w, int begin, int end) {
         string s = "";
         for (int k = begin; k <= end; k++) {
         	s = s + w[k];
		 }
         return s;
	}

	/**
	 * Given a word, returns an array with its syllables
	 *
	 * @param w a word
	 * @return ArrayList with strings, each one is a syllable of w
	 */
	public ArrayList word2syllables(string w){

		ArrayList s = new ArrayList();
		int wlen = w.Length;



		string syll = "";
		int stressed_graph = stressedSyllable(w); // stressed grapheme in word w
		int begin, end; // where the syllable starts and where it ends

		for (int i = 0; i < wlen ;){
			// a vogal eh o nucleo da silaba
			int nucleo = findVowel(w, i, stressed_graph);

			if (this.vogal_set.Contains(w[i]) || w[i] == 'i' || w[i] == 'u'){

				// regra para os ditongos decrescentes
				if (i + 1 < wlen && (w[i] == 'a' || w[i] == 'e' || w[i] == 'o')
						&& (w[i+1] == 'i' || w[i+1] == 'u')){

					begin = i;
					end = i;

					if (stressed_graph != (i+1)){
                        end = i + 1;
					}

				}else if (w[i] != 'ã' && w[i] != 'õ'
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
						|| w[i+1] == 's' || w[i+1] == 'r'
						|| w[i+1] == 'l' || w[i+1] == 'x')
						//&& isConsonant(w, i+2) && w[i+2) != 's'
						&& isConsonant(w, i + 2)
						&& w[i+2] != 'h' && w[i+2] != 'r'){
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
				s.Add(syll);
				syll = "";

			}else{

				if (nucleo - 1 >= 0){

					if (nucleo + 3 < wlen && isConsonant(w, nucleo - 1) && (isDigraph(w, nucleo + 1)
							|| (w[nucleo + 1] == 'c' && w[nucleo + 2] == 'h'))
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
							&& w[nucleo + 2] == 's' && isOcclusive(w, nucleo + 3)){
						// regra 8
						begin = i;
						end = nucleo + 2;

					}else if (nucleo + 3 < wlen && isConsonant(w, nucleo - 1) && isSemiVowel(w, nucleo + 1)
							&& w[nucleo + 2] == 'r' && isConsonant(w, nucleo + 3)){
						// regra 11
						begin = i;
						end = nucleo + 2;

					} else if ((isConsonant(w, nucleo - 1) || isSemiVowel(w, nucleo - 1))
							&& nucleo + 2 < wlen && isSemiVowel(w, nucleo + 1) && isConsonant(w, nucleo + 2)
							&& ((nucleo + 2 == wlen - 1 && w[nucleo + 2] != 'm' && w[nucleo + 2] != 'n'
							&& w[nucleo + 2] != 'r' && w[nucleo + 2] != 's') || (nucleo + 2 != wlen - 1))){
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

						if (w[nucleo + 2] == 'h' || w[nucleo + 2] == 'l'
								|| w[nucleo + 2] == 'r' || w[nucleo + 1] == 'c'
								|| (isNasal(w, nucleo + 1) && isVowel(w, nucleo + 2))){
							// com modificacao para os casos: sócio, canal..
							// regra 12
							// caso seja rr, entao nao faça mais nenhuma modificacao quanto a uniao ao
							// proximo grafema
							if (!isMuteConsonant(w, nucleo + 1) && w[nucleo + 1] != w[nucleo + 2]){
								end = nucleo ; // V nao sera mais unido ao grafema seguinte
							}

						}

					}else if (nucleo + 1 < wlen && isConsonant(w, nucleo - 1) && (isLiquid(w, nucleo + 1)
							|| isNasal(w, nucleo + 1) || w[nucleo + 1] == 'i')){
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
					}else if ((w[nucleo] == 'ã' || w[nucleo] == 'õ') && nucleo - 1 >= 0
							&& isConsonant(w, nucleo - 1) && nucleo + 1 < wlen && (w[nucleo + 1] == 'o'
							|| w[nucleo + 1] == 'e')){
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
								w[nucleo + 3] == 'r' &&
								isVowel(w, nucleo + 4)){
							end = nucleo + 2;
						}

					}else if (nucleo + 3 < wlen && (isOcclusive(w, nucleo + 1) || w[nucleo + 1] == 'f'
							|| w[nucleo + 1] == 'v' || w[nucleo + 1] == 'g') && (isOcclusive(w, nucleo + 2)
							|| isLiquid(w, nucleo + 2)) && isVowel(w, nucleo + 3)){
						// regra 15
						// modificacao conforma artigo de Rocha e Neto
						begin = i;
						end = nucleo;
						if (isMuteConsonant(w, nucleo + 1)){
							end = nucleo + 1;
						}

					}else if ( nucleo - 1 >= 0 && w[nucleo] == 'i' && isConsonant(w, nucleo - 1)
							&& nucleo + 1 < wlen && (w[nucleo + 1] == 'a' || w[nucleo + 1] == 'o')
							&& nucleo + 2 >= wlen){
						// TODO: rever essa regra (a ação dela) // regra 16
						begin = i;
						end = nucleo;

					}else if (nucleo - 1 >= 0 && (isConsonant(w, nucleo - 1) || qOrGBeforeU(w, nucleo - 1))
							&& nucleo + 2 < wlen && isConsonant(w, nucleo + 1) && isConsonant(w, nucleo + 2)){

						begin = i;
						end = nucleo + 2;
						if (w[nucleo + 1] == w[nucleo + 2] ||
								(w[nucleo + 1] == 's' && w[nucleo + 2] != 's')){
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
					s.Add(syll);
					syll = "";
				}
			}

			i = i + 1;
			//break;
		}

		return s;
	}



}
