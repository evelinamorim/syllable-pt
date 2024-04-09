import org.junit.jupiter.api.Test;
import org.junit.Assert.*;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class SyllableTest {
    /**
     * All the cases tests were retrieved from the paper implemented
     *
     */
    @Test
    public void testRule1(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("aeronave");
        // The first split a-eronave, fits into rule 1
        String[] splitResult1 = {"a","e","ro","na","ve"};

        ArrayList<String> split2 = s.word2syllables("ainda");
        // The first split a-inda, fits into rule 1
        String[] splitResult2 = {"a","in","da"};

        assertArrayEquals(splitResult1,split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
    }

    @Test
    public void testRule2(){

        Syllable s = new Syllable();

        // V = o, b eh consoante, s eh consoante e t eh oclusiva,
        // entao executa caso 5: V ´e unida aos dois grafemas seguintes e
        // ´e separada do terceiro grafema -> o-bstar -> obs-tar
        ArrayList<String> split1 = s.word2syllables("obstar");
        String[] splitResult1 = {"obs","tar"};

        ArrayList<String> split2 = s.word2syllables("adstrito");
        String[] splitResult2 = {"ads","tri","to"};

        ArrayList<String> split3 = s.word2syllables("inscrição");
        String[] splitResult3 = {"ins","cri","ção"};

        ArrayList<String> split4 = s.word2syllables("extração");
        String[] splitResult4 = {"ex","tra","ção"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
    }

    @Test
    public void testRule3(){

        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("ambos");
        String[] splitResult1 = {"am","bos"};

        ArrayList<String> split2 = s.word2syllables("ante");
        String[] splitResult2 = {"an","te"};

        ArrayList<String> split3 = s.word2syllables("aspas");
        String[] splitResult3 = {"as","pas"};

        ArrayList<String> split4 = s.word2syllables("altura");
        String[] splitResult4 = {"al","tu","ra"};

        ArrayList<String> split5 = s.word2syllables("argúcia");
        String[] splitResult5 = {"ar","gú","ci","a"};

        ArrayList<String> split6 = s.word2syllables("europa");
        String[] splitResult6 = {"eu","ro","pa"};

        ArrayList<String> split7 = s.word2syllables("exceto");
        String[] splitResult7 = {"ex","ce","to"};

        ArrayList<String> split8 = s.word2syllables("insucesso");
        String[] splitResult8 = {"in","su","ces","so"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
        assertArrayEquals(splitResult5, split5.toArray());
        assertArrayEquals(splitResult6, split6.toArray());
        assertArrayEquals(splitResult7, split7.toArray());
        assertArrayEquals(splitResult8, split8.toArray());

    }

    @Test
    public void testRule4(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("astral");
        String[] splitResult1 = {"as","tral"};

        ArrayList<String> split2 = s.word2syllables("expor");
        String[] splitResult2 = {"ex","por"};

        ArrayList<String> split3 = s.word2syllables("eira");
        String[] splitResult3 = {"ei","ra"};

        ArrayList<String> split4 = s.word2syllables("aipo");
        String[] splitResult4 = {"ai","po"};

        ArrayList<String> split5 = s.word2syllables("optar");
        String[] splitResult5 = {"op","tar"};


        ArrayList<String> split6 = s.word2syllables("advogar");
        String[] splitResult6 = {"ad","vo","gar"};

        ArrayList<String> split7 = s.word2syllables("agnóstico");
        String[] splitResult7 = {"ag","nós","ti","co"};

        ArrayList<String> split8 = s.word2syllables("aflorar");
        String[] splitResult8 = {"a","flo","rar"};

        ArrayList<String> split9 = s.word2syllables("afta");
        String[] splitResult9 = {"af","ta"};

        ArrayList<String> split10 = s.word2syllables("abdominal");
        String[] splitResult10 = {"ab","do","mi","nal"};

        // por ser ditongo crescente (ia), pode ser ser
        // separada também como: dia-gra-ma
        ArrayList<String> split11 = s.word2syllables("diagrama");
        String[] splitResult11 = {"dia","gra","ma"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
        assertArrayEquals(splitResult5, split5.toArray());
        assertArrayEquals(splitResult6, split6.toArray());
        assertArrayEquals(splitResult7, split7.toArray());
        assertArrayEquals(splitResult8, split8.toArray());
        assertArrayEquals(splitResult9, split9.toArray());
        assertArrayEquals(splitResult10, split10.toArray());
        assertArrayEquals(splitResult11, split11.toArray());
    }

    @Test
    public void testRule5(){

        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("arrendar");
        String[] splitResult1 = {"a","rren","dar"}; // considerando rr como um fonema - artigo Rocha e Neto

        ArrayList<String> split2 = s.word2syllables("atlas");
        String[] splitResult2 = {"a","tlas"};

        ArrayList<String> split3 = s.word2syllables("alho");
        String[] splitResult3 = {"a","lho"};

        ArrayList<String> split4 = s.word2syllables("amor");
        String[] splitResult4 = {"a","mor"};

        ArrayList<String> split5 = s.word2syllables("aclamado");
        String[] splitResult5 = {"a","cla","ma","do"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
        assertArrayEquals(splitResult5, split5.toArray());
    }

    @Test
    public void testRule6(){

        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("calha");
        String[] splitResult1 = {"ca","lha"};

        ArrayList<String> split2 = s.word2syllables("cala");
        String[] splitResult2 = {"ca","la"};

        ArrayList<String> split3 = s.word2syllables("meta");
        String[] splitResult3 = {"me","ta"};

        ArrayList<String> split4 = s.word2syllables("cachoeira");
        String[] splitResult4 = {"ca","choei","ra"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());

    }

    @Test
    public void testRule7(){

        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("cairo");
        String[] splitResult1 = {"cai","ro"};

        ArrayList<String> split2 = s.word2syllables("raiva");
        String[] splitResult2 = {"rai","va"};

        ArrayList<String> split3 = s.word2syllables("causa");
        String[] splitResult3 = {"cau","sa"};

        ArrayList<String> split4 = s.word2syllables("queixar");
        String[] splitResult4 = {"quei","xar"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
    }

    @Test
    public void testRule8(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("claustro");
        String[] splitResult1 = {"claus","tro"};

        assertArrayEquals(splitResult1, split1.toArray());
    }

    @Test
    public void testRule9(){

        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("praia");
        String[] splitResult1 = {"prai","a"};

        ArrayList<String> split2 = s.word2syllables("meia");
        String[] splitResult2 = {"mei","a"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
    }

    @Test
    public void testRule10(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("piada");
        String[] splitResult1 = {"pi","a","da"};

        ArrayList<String> split2 = s.word2syllables("viagem");
        String[] splitResult2 = {"vi","a","gem"};

        ArrayList<String> split3 = s.word2syllables("suada");
        String[] splitResult3 = {"su","a","da"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
    }

    @Test
    public void testRule11(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("cairmos");
        String[] splitResult1 = {"cair","mos"};
        assertArrayEquals(splitResult1, split1.toArray());
    }

    @Test
    public void testRule12(){

        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("carta");
        String[] splitResult1 = {"car","ta"};

        ArrayList<String> split2 = s.word2syllables("maldade");
        String[] splitResult2 = {"mal","da","de"};

        ArrayList<String> split3 = s.word2syllables("contar");
        String[] splitResult3 = {"con","tar"};


        ArrayList<String> split4 = s.word2syllables("esquerda");
        String[] splitResult4 = {"es","quer","da"};

        ArrayList<String> split5 = s.word2syllables("aguardo");
        String[] splitResult5 = {"a","guar","do"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
        assertArrayEquals(splitResult5, split5.toArray());
    }

    @Test
    public void testRule13(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("varal");
        String[] splitResult1 = {"va","ral"};

        ArrayList<String> split2 = s.word2syllables("cais");
        String[] splitResult2 = {"cais"};

        ArrayList<String> split3 = s.word2syllables("dispensar");
        String[] splitResult3 = {"dis","pen","sar"};

        ArrayList<String> split4 = s.word2syllables("circunspecto");
        String[] splitResult4 = {"cir","cuns","pec","to"};

        ArrayList<String> split5 = s.word2syllables("quartzo");
        String[] splitResult5 = {"quart","zo"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
        assertArrayEquals(splitResult5, split5.toArray());
    }

    @Test
    public void testRule14(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("cooperação");
        String[] splitResult1 = {"co","o","pe","ra","ção"};

        ArrayList<String> split2 = s.word2syllables("bueiro");
        String[] splitResult2 = {"buei","ro"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
    }

    @Test
    public void testRule15(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("sublime");
        String[] splitResult1 = {"su","bli","me"};

        ArrayList<String> split2 = s.word2syllables("rapto");
        String[] splitResult2 = {"rap","to"};

        ArrayList<String> split3 = s.word2syllables("captar");
        String[] splitResult3 = {"cap","tar"};

        ArrayList<String> split4 = s.word2syllables("eletro");
        String[] splitResult4 = {"e","le","tro"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
        assertArrayEquals(splitResult4, split4.toArray());
    }

    @Test
    public void testRule16(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("polícia");
        String[] splitResult1 = {"po","lí","ci","a"};

        ArrayList<String> split2 = s.word2syllables("sócio");
        String[] splitResult2 = {"só","ci","o"}; // atualizado com a divisao CPLP

        ArrayList<String> split3 = s.word2syllables("democracia");
        String[] splitResult3 = {"de","mo","cra","ci","a"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
    }

    @Test
    public void testRule17(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("gamão");
        String[] splitResult1 = {"ga","mão"};

        ArrayList<String> split2 = s.word2syllables("limões");
        String[] splitResult2 = {"li","mões"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
    }

    @Test
    public void testRule18(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("burro");
        String[] splitResult1 = {"bur","ro"};

        ArrayList<String> split2 = s.word2syllables("besta");
        String[] splitResult2 = {"bes","ta"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
    }

    @Test
    public void testRule19(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("teólogo");
        String[] splitResult1 = {"te","ó","lo","go"};

        ArrayList<String> split2 = s.word2syllables("sanguíneo");
        String[] splitResult2 = {"san","guí","ne","o"}; // san-guí-neo também é válido

        ArrayList<String> split3 = s.word2syllables("semear");
        String[] splitResult3 = {"se","me","ar"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
        assertArrayEquals(splitResult3, split3.toArray());
    }

    @Test
    public void testRule20(){
        Syllable s = new Syllable();

        ArrayList<String> split1 = s.word2syllables("casto");
        String[] splitResult1 = {"cas","to"};

        ArrayList<String> split2 = s.word2syllables("descer");
        String[] splitResult2 = {"des","cer"};

        assertArrayEquals(splitResult1, split1.toArray());
        assertArrayEquals(splitResult2, split2.toArray());
    }

    @Test
    public void testProparoxitona(){
        Syllable s = new Syllable();

        ArrayList<String> split = s.word2syllables("própio");
        String[] splitResult = {"pró","pi","o"};

        assertArrayEquals(splitResult, split.toArray());
    }
}
