package br.com.avl;

import java.io.FileWriter;
import java.io.IOException;

public class AVL {
	No raiz;
	
	private int altura(No no) {
		return (no == null) ? 0 : no.altura;
	}
	
	private int fatorBalanceamento(No no) {
		return (no == null) ? 0 : altura(no.esq) - altura(no.dir);
	}
	
	private void atualizarAltura(No no) {
		no.altura = Math.max(altura(no.esq), altura(no.dir)) + 1;
	}
	
	private No rotacaoDireita(No y) {
		No x = y.esq;
		No T2 = x.dir;
		
		x.dir = y;
		y.esq = T2;
		
		atualizarAltura(y);
		atualizarAltura(x);
		
		return x;
	}
	
	private No rotacaoEsquerda(No x) {
		No y = x.dir;
		No T2 = y.esq;
		
		y.esq = x;
		x.dir = T2;
		
		atualizarAltura(x);
		atualizarAltura(y);
		
		return y;
	}
	
	public No inserir(No no, int valor) {
		if(no == null) return new No(valor);
		
		if(valor < no.valor)
			no.esq = inserir(no.esq, valor);
		else if(valor > no.valor)
			no.dir = inserir(no.dir, valor);
		else
			return no;
		
		atualizarAltura(no);
		
		int balance = fatorBalanceamento(no);
		
		if(balance > 1 && valor < no.esq.valor)
			return rotacaoDireita(no);
		
		if(balance < -1 && valor > no.dir.valor)
			return rotacaoEsquerda(no);
		
		if(balance > 1 && valor > no.esq.valor) {
			no.esq = rotacaoEsquerda(no.esq);
			return rotacaoDireita(no);
		}
		
		if(balance < -1 && valor < no.dir.valor) {
			no.dir = rotacaoDireita(no.dir);
			return rotacaoEsquerda(no);
		}
		
		return no;
	}
	
	public void exportarDOTImagem(No raiz, String nomeArquivoDOT, String nomeArquivoSaida, String formato) {
		try(FileWriter writer = new FileWriter(nomeArquivoDOT)){
			writer.write("digraph AVL {\n");
			exportarDOTRecArquivo(raiz, writer);
			writer.write("}\n");
			System.out.println("Arquivo DOT gerado: " + nomeArquivoDOT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ProcessBuilder pb = new ProcessBuilder("dot", "-T" + formato, nomeArquivoDOT, "-o", nomeArquivoSaida);
			pb.inheritIO();
			Process p = pb.start();
			p.waitFor();
			System.out.println("Arquivo gerado: " + nomeArquivoSaida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private void exportarDOTRecArquivo(No no, FileWriter writer) throws IOException {
		if(no != null) {
			if(no.esq != null) {
				writer.write(no.valor + " -> " + no.esq.valor + ";\n");
				exportarDOTRecArquivo(no.esq, writer);
			}
			if(no.dir != null) {
				writer.write(no.valor + " -> " + no.dir.valor + ";\n");
				exportarDOTRecArquivo(no.dir, writer);
			}
		}
	}
}
