package br.com.avl;

public class Principal {
	public static void main(String[] args) {
		AVL avl = new AVL();
		
		int[] valores = {20,5,9,22,1,10,30,28,4,17,19,2,11};
		for(int v : valores) {
			avl.raiz = avl.inserir(avl.raiz, v);
		}
		
		avl.exportarDOTImagem(avl.raiz, "arvore.dot", "arvore.png", "png");
		/*avl.exportarDOTImagem(avl.raiz, "arvore.dot", "arvore.svg", "svg");*/
		/*avl.exportarDOTImagem(avl.raiz, "arvore.dot", "arvore.pdf", "pdf");*/
		
		ArvoreGUI.mostrar(avl.raiz);
	}
}
