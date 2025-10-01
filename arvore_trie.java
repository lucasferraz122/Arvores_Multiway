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
}
