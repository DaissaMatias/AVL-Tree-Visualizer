package br.com.avl;

public class No {
	int valor;
	int altura;
	No esq;
	No dir;
	
	public No(int valor) {
		this.valor = valor;
		this.altura = 1;
		this.esq = null;
		this.dir = null;
	}
}
