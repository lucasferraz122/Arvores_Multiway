public class arvore_trie {
    private static final int tam_alfabeto = 26;
    private static final int tam_max_palvra = 200;

    private static class no {
        no[] filhos;
        boolean fimdapalavra;
        no() {
            filhos = new no[tam_alfabeto];
            fimdapalavra = false;
        }
    }

    private no raiz;

    public arvore_trie() {
        raiz = new no();
    }

    private int indice(char c) {
        return c - 'a';
    }

    private String limpartextos(String s) {
        if (s == null) return "";
        s = s.toLowerCase();
        char[] saida = new char[s.length()];
        int tamsaida = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'á' || c == 'à' || c == 'â' || c == 'ã' || c == 'ä' || c == 'å') c = 'a';
            else if (c == 'ç') c = 'c';
            else if (c == 'é' || c == 'ê' || c == 'è' || c == 'ë') c = 'e';
            else if (c == 'í' || c == 'ì' || c == 'î' || c == 'ï') c = 'i';
            else if (c == 'ó' || c == 'ô' || c == 'õ' || c == 'ò' || c == 'ö') c = 'o';
            else if (c == 'ú' || c == 'ù' || c == 'û' || c == 'ü') c = 'u';
            if (c >= 'a' && c <= 'z') {
                saida[tamsaida++] = c;
            }
        }
        return new String(saida, 0, tamsaida);
    }

    public void inserir(String palavra) {
        palavra = limpartextos(palavra);
        no atual = raiz;
        for (int i = 0; i < palavra.length(); i++) {
            int pos = indice(palavra.charAt(i));
            if (atual.filhos[pos] == null) {
                atual.filhos[pos] = new no();
            }
            atual = atual.filhos[pos];
        }
        atual.fimdapalavra = true;
    }

    public boolean buscar(String palavra) {
        palavra = limpartextos(palavra);
        no atual = raiz;
        for (int i = 0; i < palavra.length(); i++) {
            int pos = indice(palavra.charAt(i));
            if (atual.filhos[pos] == null) return false;
            atual = atual.filhos[pos];
        }
        return atual.fimdapalavra;
    }

    public boolean remover(String palavra) {
        palavra = limpartextos(palavra);
        return removerpasso(raiz, palavra, 0);
    }

    private boolean removerpasso(no atual, String palavra, int nivel) {
        if (atual == null) return false;
        if (nivel == palavra.length()) {
            if (!atual.fimdapalavra) return false;
            atual.fimdapalavra = false;
            return semfilho(atual);
        }
        int pos = indice(palavra.charAt(nivel));
        no filho = atual.filhos[pos];
        if (filho == null) return false;
        boolean apagarFilho = removerpasso(filho, palavra, nivel + 1);
        if (apagarFilho) {
            atual.filhos[pos] = null;
            return !atual.fimdapalavra && semfilho(atual);
        }
        return false;
    }

    private boolean semfilho(no n) {
        for (int i = 0; i < tam_alfabeto; i++) {
            if (n.filhos[i] != null) return false;
        }
        return true;
    }

    public void listartodas() {
        char[] buffer = new char[tam_max_palvra];
        mostrartodospassos(raiz, buffer, 0);
    }

    private void mostrartodospassos(no atual, char[] buffer, int nivel) {
        if (atual == null) return;
        if (atual.fimdapalavra) {
            System.out.println(new String(buffer, 0, nivel));
        }
        for (int i = 0; i < tam_alfabeto; i++) {
            if (atual.filhos[i] != null) {
                buffer[nivel] = (char) ('a' + i);
                mostrartodospassos(atual.filhos[i], buffer, nivel + 1);
            }
        }
    }

    public void listarcomprefixo(String prefixo) {
        prefixo = limpartextos(prefixo);
        no atual = raiz;
        for (int i = 0; i < prefixo.length(); i++) {
            int pos = indice(prefixo.charAt(i));
            if (atual.filhos[pos] == null) {
                System.out.println("(nenhuma palavra encontrada com o prefixo informado)");
                return;
            }
            atual = atual.filhos[pos];
        }
        char[] buffer = new char[tam_max_palvra];
        for (int i = 0; i < prefixo.length(); i++) buffer[i] = prefixo.charAt(i);
        listarapartirde(atual, buffer, prefixo.length());
    }

    private void listarapartirde(no atual, char[] buffer, int nivel) {
        if (atual == null) return;
        if (atual.fimdapalavra) {
            System.out.println(new String(buffer, 0, nivel));
        }
        for (int i = 0; i < tam_alfabeto; i++) {
            if (atual.filhos[i] != null) {
                buffer[nivel] = (char) ('a' + i);
                listarapartirde(atual.filhos[i], buffer, nivel + 1);
            }
        }
    }

    public static void main(String[] args) {
        arvore_trie arvore = new arvore_trie();

        arvore.inserir("casa");
        arvore.inserir("carro");
        arvore.inserir("cachorro");
        arvore.inserir("café");
        arvore.inserir("computação");
        arvore.inserir("programa");
        arvore.inserir("progresso");
        arvore.inserir("prova");

        System.out.println("buscar 'casa' -> " + arvore.buscar("casa"));
        System.out.println("buscar 'carro' -> " + arvore.buscar("carro"));
        System.out.println("buscar 'gato' -> " + arvore.buscar("gato"));

        System.out.println("\nlista completa de palavras:");
        arvore.listartodas();

        arvore.remover("carro");
        System.out.println("\nlista após remover 'carro':");
        arvore.listartodas();

        System.out.println("\npalavras com prefixo 'pro':");
        arvore.listarcomprefixo("pro");
    }
}

