using System;
using System.Collections;
using System.Collections.Generic;
using static Syllable;

namespace java
{
    class Program
    {
        static void Main(string[] args)
        {
            Syllable syllable = new Syllable();
            List<KeyValuePair<string, string>> palavras = new List<KeyValuePair<string, string>>();

            // DITONGOS E TRITONGOS:
            palavras.Add(new KeyValuePair <string, string> ("aumento", "au-men-to"));
            palavras.Add(new KeyValuePair <string, string> ("pinheiro", "pi-nhei-ro"));
            palavras.Add(new KeyValuePair <string, string> ("água", "á-gua"));
            palavras.Add(new KeyValuePair <string, string> ("outros", "ou-tros"));
            palavras.Add(new KeyValuePair <string, string> ("coisas", "coi-sas"));
            palavras.Add(new KeyValuePair <string, string> ("iguais", "i-guais"));
            palavras.Add(new KeyValuePair <string, string> ("Paraguai", "Pa-ra-guai"));
            palavras.Add(new KeyValuePair <string, string> ("quaisquer", "quais-quer"));
            palavras.Add(new KeyValuePair <string, string> ("saguões", "sa-guões"));

            //DÍGRAFOS LH, CH, NH, GU, QU:
            palavras.Add(new KeyValuePair <string, string> ("maravilha", "ma-ra-vi-lha"));
            palavras.Add(new KeyValuePair <string, string> ("chuva", "chu-va"));
            palavras.Add(new KeyValuePair <string, string> ("carinho", "ca-ri-nho"));
            palavras.Add(new KeyValuePair <string, string> ("guindaste", "guin-das-te"));
            palavras.Add(new KeyValuePair <string, string> ("quente", "quen-te"));

            // ENCONTROS CONSONANTAIS PUROS (BL, CL, GL, PL, FL, BR, CR, DR, GR, PR, TR, FR, VR)
            palavras.Add(new KeyValuePair <string, string> ("bloco", "blo-co"));
            palavras.Add(new KeyValuePair <string, string> ("claridade", "cla-ri-da-de"));
            palavras.Add(new KeyValuePair <string, string> ("glóbulo", "gló-bu-lo"));
            palavras.Add(new KeyValuePair <string, string> ("planeta", "pla-ne-ta"));
            palavras.Add(new KeyValuePair <string, string> ("flamingo", "fla-min-go"));
            palavras.Add(new KeyValuePair <string, string> ("Brasil", "Bra-sil"));
            palavras.Add(new KeyValuePair <string, string> ("cravo", "cra-vo"));
            palavras.Add(new KeyValuePair <string, string> ("dragão", "dra-gão"));
            palavras.Add(new KeyValuePair <string, string> ("gravidade", "gra-vi-da-de"));
            palavras.Add(new KeyValuePair <string, string> ("praticamente", "pra-ti-ca-men-te"));
            palavras.Add(new KeyValuePair <string, string> ("trevas", "tre-vas"));
            palavras.Add(new KeyValuePair <string, string> ("francês", "fran-cês"));
            palavras.Add(new KeyValuePair <string, string> ("livre", "li-vre"));

            // GRUPOS CONSONANTAIS INICIAIS (PS, MN, PN, GN,...):
            palavras.Add(new KeyValuePair <string, string>("psicólogo", "psi-có-lo-go"));
            palavras.Add(new KeyValuePair <string, string>("mnésico", "mné-si-co"));
            palavras.Add(new KeyValuePair <string, string>("pneumático", "pneu-má-ti-co"));
            palavras.Add(new KeyValuePair <string, string>("gnóstico", "gnós-ti-co"));

            //HIATOS:
            palavras.Add(new KeyValuePair <string, string>("moeda", "mo-e-da"));
            palavras.Add(new KeyValuePair <string, string>("saída", "sa-í-da"));
            palavras.Add(new KeyValuePair <string, string>("saúde", "sa-ú-de"));
            palavras.Add(new KeyValuePair <string, string>("poesia", "po-e-sia"));
            palavras.Add(new KeyValuePair <string, string>("navio", "na-vi-o"));
            palavras.Add(new KeyValuePair <string, string>("dia", "di-a"));

            //DÍGRAFOS RR, SS, SC, SÇ, XC, XS:
            palavras.Add(new KeyValuePair <string, string>("carro", "car-ro"));
            palavras.Add(new KeyValuePair <string, string>("pássaro", "pas-sá-ro"));
            palavras.Add(new KeyValuePair <string, string>("nascer", "nas-cer"));
            palavras.Add(new KeyValuePair <string, string>("nasço", "nas-ço"));
            palavras.Add(new KeyValuePair <string, string>("exceção", "ex-ce-ção"));
            palavras.Add(new KeyValuePair <string, string>("exsudativo", "ex-su-da-ti-vo"));

            //ENCONTROS CONSONANTAIS DISJUNTOS:
            palavras.Add(new KeyValuePair <string, string>("advogado", "ad-vo-ga-do"));
            palavras.Add(new KeyValuePair <string, string>("afta", "af-ta"));
            palavras.Add(new KeyValuePair <string, string>("alface", "al-fa-ce"));
            palavras.Add(new KeyValuePair <string, string>("força", "for-ça"));
            palavras.Add(new KeyValuePair <string, string>("magnético", "mag-né-ti-co"));
            palavras.Add(new KeyValuePair <string, string>("objeto", "ob-je-to"));
            palavras.Add(new KeyValuePair <string, string>("desmentir", "des-men-tir"));

            int countRightWords = 0;

            foreach(var palSep in palavras) {

                var palavra = palSep.Key;
                var split = syllable.word2syllables(palavra);
                var spliString = string.Join("-", split.ToArray());

                Console.WriteLine("--------------------------------------------------");
                Console.WriteLine("Palavra: " + palavra);
                Console.WriteLine("Separa automaticamente: " + spliString);
                Console.WriteLine("Separação correta: " + palSep.Value);
                Console.WriteLine("--------------------------------------------------\n");

                if (spliString.Equals(palSep.Value)) {
                    countRightWords ++;
                }
            }

            Console.WriteLine("Total de palavras: " + palavras.Count);
            Console.WriteLine("Total separações certas: " + countRightWords);
        }
    }
}
