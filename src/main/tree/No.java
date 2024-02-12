package tree;

public class No {

    private int valor;
    private No filhoEsq;
    private No filhoDir;

    public No(int valor) {
        this.valor = valor;
        this.filhoEsq = null;
        this.filhoEsq = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getFilhoEsq() {
        return filhoEsq;
    }

    public void setFilhoEsq(No filhoEsq) {
        this.filhoEsq = filhoEsq;
    }

    public No getFilhoDir() {
        return filhoDir;
    }

    public void setFilhoDir(No filhoDir) {
        this.filhoDir = filhoDir;
    }

}
