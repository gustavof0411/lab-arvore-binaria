package tree;

import estrut.Tree;

public class BinarySearchTree implements Tree {

    private No no;

    @Override
    public boolean buscaElemento(int valor) {
        if (no.getValor() == valor) {
            return true;
        } else if (valor < no.getValor()) {
            if (no.getFilhoEsq() != null) {
                if (no.getFilhoEsq().getValor() == valor) {
                    return true;
                } else {
                    BinarySearchTree proxEsq = new BinarySearchTree();
                    proxEsq.setNo(no.getFilhoEsq());
                    return proxEsq.buscaElemento(valor);
                }
            }
        } else if (valor > no.getValor()) {
            if (no.getFilhoDir() != null) {
                if (no.getFilhoDir().getValor() == valor) {
                    return true;
                } else {
                    BinarySearchTree proxDir = new BinarySearchTree();
                    proxDir.setNo(no.getFilhoDir());
                    return proxDir.buscaElemento(valor);
                }
            }
        }
        return false;
    }

    @Override
    public int minimo() {
        No atual = no;
        while (atual.getFilhoEsq() != null) {
            atual = atual.getFilhoEsq();
        }
        return atual.getValor();
    }

    @Override
    public int maximo() {
        No atual = no;
        while (atual.getFilhoDir() != null) {
            atual = atual.getFilhoDir();
        }

        return atual.getValor();
    }

    @Override
    public void insereElemento(int valor) {
        if (no == null) {
            no = new No(valor);
        } else if ((valor < no.getValor() || valor == no.getValor())) {
            if (no.getFilhoEsq() == null) {
                no.setFilhoEsq(new No(valor));
            } else {
                BinarySearchTree proxEsq = new BinarySearchTree();
                proxEsq.setNo(no.getFilhoEsq());
                proxEsq.insereElemento(valor);
            }
        } else {
            if (no.getFilhoDir() == null) {
                no.setFilhoDir(new No(valor));
            } else {
                BinarySearchTree proxDir = new BinarySearchTree();
                proxDir.setNo(no.getFilhoDir());
                proxDir.insereElemento(valor);
            }
        }
    }

    @Override
    public void remove(int valor) {
        No pai = null;
        No atual = no;
        boolean encontrado = false;

        while (atual != null) {
            if (valor == atual.getValor()) {
                encontrado = true;
                break;
            } else {
                pai = atual;
                if (valor < atual.getValor()) {
                    atual = atual.getFilhoEsq();
                } else {
                    atual = atual.getFilhoDir();
                }
            }
        }
        if (!encontrado) {
            return;
        }

        if (atual.getFilhoEsq() == null && atual.getFilhoDir() == null) {
            if (atual != no) {
                if (pai.getFilhoEsq() == atual) {
                    pai.setFilhoEsq(null);
                } else {
                    pai.setFilhoDir(null);
                }
            } else {
                no = null;
            }
            return;
        }
        if (atual.getFilhoEsq() == null || atual.getFilhoDir() == null) {
            No filho;
            if (atual.getFilhoEsq() != null) {
                filho = atual.getFilhoEsq();
            } else {
                filho = atual.getFilhoDir();
            }
            if (atual != no) {
                if (pai.getFilhoEsq() == atual) {
                    pai.setFilhoEsq(filho);
                } else {
                    pai.setFilhoDir(filho);
                }
            } else {
                no = filho;
            }
            return;
        }
        No sucessorPai = atual;
        No sucessor = atual.getFilhoDir();
        while (sucessor.getFilhoEsq() != null) {
            sucessorPai = sucessor;
            sucessor = sucessor.getFilhoEsq();
        }
        if (sucessorPai != atual) {
            sucessorPai.setFilhoEsq(sucessor.getFilhoDir());
            sucessor.setFilhoDir(atual.getFilhoDir());
        }
        sucessor.setFilhoEsq(atual.getFilhoEsq());
        if (atual == no) {
            no = sucessor;
        } else {
            if (pai.getFilhoEsq() == atual) {
                pai.setFilhoEsq(sucessor);
            } else {
                pai.setFilhoDir(sucessor);
            }
        }
    }

    @Override
    public int[] preOrdem() {
        int[] ordem = new int[quantidadeNos()];
        int indice = 0;

        if (no != null) {
            ordem[indice] = no.getValor();
            indice++;
            if (no.getFilhoEsq() != null) {
                BinarySearchTree proxEsq = new BinarySearchTree();
                proxEsq.setNo(no.getFilhoEsq());
                int[] ordemEsq = proxEsq.preOrdem();
                for (int valor : ordemEsq) {
                    ordem[indice] = valor;
                    indice++;
                }
            }
            if (no.getFilhoDir() != null) {
                BinarySearchTree proxDir = new BinarySearchTree();
                proxDir.setNo(no.getFilhoDir());
                int[] ordemDir = proxDir.preOrdem();
                for (int valor : ordemDir) {
                    ordem[indice] = valor;
                    indice++;
                }
            }
        }

        return ordem;
    }

    @Override
    public int[] emOrdem() {
        int[] ordem = new int[quantidadeNos()];
        int indice = 0;

        if (no != null) {
            if (no.getFilhoEsq() != null) {
                BinarySearchTree proxEsq = new BinarySearchTree();
                proxEsq.setNo(no.getFilhoEsq());
                int[] ordemEsq = proxEsq.emOrdem();
                for (int valor : ordemEsq) {
                    ordem[indice] = valor;
                    indice++;
                }
            }

            ordem[indice] = no.getValor();
            indice++;

            if (no.getFilhoDir() != null) {
                BinarySearchTree proxDir = new BinarySearchTree();
                proxDir.setNo(no.getFilhoDir());
                int[] ordemDir = proxDir.emOrdem();
                for (int valor : ordemDir) {
                    ordem[indice] = valor;
                    indice++;
                }
            }
        }

        return ordem;
    }

    @Override
    public int[] posOrdem() {
        int[] ordem = new int[quantidadeNos()];
        int indice = 0;

        if (no != null) {
            if (no.getFilhoEsq() != null) {
                BinarySearchTree proxEsq = new BinarySearchTree();
                proxEsq.setNo(no.getFilhoEsq());
                int[] ordemEsq = proxEsq.posOrdem();
                for (int valor : ordemEsq) {
                    ordem[indice] = valor;
                    indice++;
                }
            }

            if (no.getFilhoDir() != null) {
                BinarySearchTree proxDir = new BinarySearchTree();
                proxDir.setNo(no.getFilhoDir());
                int[] ordemDir = proxDir.posOrdem();
                for (int valor : ordemDir) {
                    ordem[indice] = valor;
                    indice++;
                }
            }

            ordem[indice] = no.getValor();
            indice++;
        }

        return ordem;
    }

    public int quantidadeNos() {
        int quantidadeEsq = 0;
        int quantidadeDir = 0;
        int quantidadeAtual = 0;

        if (no == null) {
            return 0;
        } else {
            quantidadeAtual = 1;
        }

        if (no.getFilhoEsq() != null) {
            BinarySearchTree verificaEsq = new BinarySearchTree();
            verificaEsq.setNo(no.getFilhoEsq());
            quantidadeEsq = verificaEsq.quantidadeNos();
        }
        if (no.getFilhoDir() != null) {
            BinarySearchTree verificaDir = new BinarySearchTree();
            verificaDir.setNo(no.getFilhoDir());
            quantidadeDir = verificaDir.quantidadeNos();
        }
        return quantidadeEsq + quantidadeDir + quantidadeAtual;
    }

    public No getNo() {
        return no;
    }

    public void setNo(No no) {
        this.no = no;
    }

}