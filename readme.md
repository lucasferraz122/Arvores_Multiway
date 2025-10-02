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
