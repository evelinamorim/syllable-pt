# syllable-pt (en)

Split  words in Portuguese in syllables, based on the following papers and some improvements made by myself.

* Silva, D., Braga, D., & Resende Jr, F. G. (2008). Separaçao das sılabas e determinaçao da tonicidade no Português Brasileiro. 
XXVI Simpósio Brasileiro de Telecomunicações, 1-5.

* Rocha, W., & Neto, N. (2013). Implementação de um Separador Silábico Gratuito Baseado em Regras Linguísticas para o Português 
Brasileiro (The Implementation of a Free Syllabification Algorithm Based on Linguistic Rules for Brazilian Portuguese). 
In Proceedings of the 9th Brazilian Symposium in Information and Human Language Technology. 

As it is a rule based library, eventually some words could not be separated correctly. Any issues reported will be evaluated in 
order to add new rules to the system.

## Usage

As the system is composed by only one class, I recommend to clone the repository with the following command:

*git clone https://github.com/evelinamorim/syllable-pt.git* 

And then, add the class to your Java project. The following code exemplifies the usage:

```java

 Syllable s = new Syllable();
 ArrayList<String> split1 = s.word2syllables("carta");
 ```
 
 The test class also provides further examples.

# syllable-pt (pt)

Esse sistema separa sílabas de palavras em português e é baseado nos seguintes artigos e em algumas melhorias feitas por mim.

* Silva, D., Braga, D., & Resende Jr, F. G. (2008). Separaçao das sılabas e determinaçao da tonicidade no Português Brasileiro. 
XXVI Simpósio Brasileiro de Telecomunicações, 1-5.

* Rocha, W., & Neto, N. (2013). Implementação de um Separador Silábico Gratuito Baseado em Regras Linguísticas para o Português 
Brasileiro (The Implementation of a Free Syllabification Algorithm Based on Linguistic Rules for Brazilian Portuguese). 
In Proceedings of the 9th Brazilian Symposium in Information and Human Language Technology. 

Por ser um sistema baseado em regras, eventualmente algumas palavras podem não separar de forma correta. Qualquer *issue* reportada 
será avaliada para que novas regras possam ser adicionadas.


## Como usar

Como o sistema é composto por apenas uma classe, recomendo clonar o repositório com o seguinte comando.

*git clone https://github.com/evelinamorim/syllable-pt.git* 

E então adicionar a única classe ao seu projeto Java. O seguinte código exemplifica o uso:

```java

 Syllable s = new Syllable();
 ArrayList<String> split1 = s.word2syllables("carta");
 ```

A classe de teste fornece mais exemplos.

