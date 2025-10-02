# Pontifícia Universidade Católica do Paraná  
**Curso de Ciência da Computação**  

**Trabalho Discente Efetivo – Árvores MultiWay**  

**Integrantes:**  
- Alan Filipe Reginato de França Santos  
- Lucas Ferraz dos Santos  
- Pedro Henrique Moraes  

Curitiba – 2025  

---

## Resumo

Este trabalho apresenta a implementação de uma estrutura de dados do tipo árvore multiway.  
Foi escolhida a estrutura **trie** (árvore de prefixos), pela simplicidade de implementação e relevância prática em situações de busca de palavras e autocompletar. Além da implementação em JAVA, este documento inclui uma breve pesquisa sobre diferentes árvores multiway, exemplos práticos de uso, bem como as justificativas das escolhas realizadas durante o desenvolvimento.

---

## Introdução

As árvores multiway são estruturas de dados que permitem que cada nó possua mais de dois filhos, diferenciando-se das árvores binárias. São amplamente utilizadas em sistemas de arquivos, bancos de dados, buscas textuais e indexação espacial.  
Neste trabalho foi escolhida a **trie**, também conhecida como árvore de prefixos, para atender às exigências da atividade: implementação em JAVA, sem uso de estruturas prontas e com operações básicas de inserção, busca e remoção.

---

## Fundamentação Teórica

Existem diferentes tipos de árvores multiway, cada uma voltada para aplicações específicas:

- **Árvore B**: Estrutura balanceada usada em bancos de dados e sistemas de arquivos, com operações em O(log n).  
- **Árvore B+**: Variante da B-tree onde os dados ficam apenas nas folhas, facilitando consultas ordenadas.  
- **Árvore B***: Melhora a taxa de ocupação dos nós por meio de redistribuição de chaves.  
- **Árvore 2-3**: Cada nó tem 2 ou 3 filhos, mantendo balanceamento perfeito.  
- **Árvore 2-3-4**: Extensão da 2-3, permitindo até 4 filhos por nó, base para árvores rubro-negras.  
- **Trie**: Árvore de prefixos, utilizada para buscas textuais e autocompletar, operações em O(k), sendo k o tamanho da palavra.  
- **Árvore Patrícia**: Versão comprimida da trie, que economiza memória eliminando nós com um único filho.  
- **Árvore R**: Voltada para indexação espacial, onde cada nó cobre uma região retangular mínima.  
- **Árvore R+**: Variação da R-tree que evita sobreposição, duplicando objetos quando necessário.  
- **Quadtree**: Estrutura que divide o espaço em quatro quadrantes, usada em imagens e simulações 2D.

---

## Desenvolvimento

A implementação foi realizada em **JAVA**, obedecendo às restrições de não utilizar estruturas prontas como `List` ou `ArrayList`, nem recursos como `StringBuilder` e exceções.  
Para representar os filhos da trie, foram utilizados arrays fixos de tamanho 26 (para o alfabeto de A a Z).  
Foram implementadas as funções de:

- Inserção  
- Busca  
- Remoção  
- Listagem de todas as palavras cadastradas  

Também foi criada uma função de **normalização** para lidar com acentos e caracteres especiais.

---

## Como Executar

1. **Baixar o arquivo**:
   - Faça o download do arquivo `arvore_trie.java` do repositório GitHub
     
2. **Abrir em uma IDE** (IntelliJ, Eclipse ou NetBeans):
   - Crie um novo projeto Java
   - Adicione o arquivo `arvore_trie.java` ao projeto
   - Execute o arquivo como aplicação Java
     
---

## Resultados

Os testes realizados incluíram a inserção de palavras como:

- `casa`  
- `carro`  
- `cachorro`  
- `café`  

As operações de busca retornaram `verdadeiro` para palavras existentes e `falso` para palavras não cadastradas, como `gato`.  
A remoção da palavra `carro` foi bem-sucedida, sem afetar palavras que compartilham prefixos, como `cachorro`.  
A função de listagem exibiu corretamente todas as palavras armazenadas.

---

## Conclusão

Este trabalho permitiu compreender a importância das árvores multiway em diferentes contextos, desde bancos de dados até sistemas de busca textual.  
A implementação da **trie** em JAVA demonstrou ser viável mesmo com as restrições propostas, mostrando-se uma estrutura eficiente e de fácil compreensão.  
A escolha pela trie foi motivada pela clareza e facilidade conceitual e pela aplicabilidade prática em problemas de busca por prefixo.

---

## Referências

- CORMEN, T. H. et al. **Algoritmos: Teoria e Prática**. 3. ed. Rio de Janeiro: Elsevier, 2012.  
- SEDGEWICK, R.; WAYNE, K. **Algorithms**. 4. ed. Boston: Addison-Wesley, 2011.  
- KNUTH, D. E. **The Art of Computer Programming, Volume 3: Sorting and Searching**. 2. ed. Addison-Wesley, 1998.

