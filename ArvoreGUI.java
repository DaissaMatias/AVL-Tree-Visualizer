package br.com.avl;

import javax.swing.*;
import java.awt.*;

public class ArvoreGUI extends JPanel {
	private No raiz;
	
	public ArvoreGUI(No raiz) {
		this.raiz = raiz;
		setBackground(Color.WHITE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		desenharLegenda((Graphics2D) g);
		desenharArvore((Graphics2D) g, raiz, getWidth() / 2, 60, getWidth() / 4, 0);
	}
	
	private void desenharArvore(Graphics2D g, No no, int x, int y, int espaco, int nivel) {
		if(no == null) return;
		
		//Paleta de cores por nível
		Color[] cores = {
				new Color(135, 206, 250),
				new Color(144, 238, 144),
				new Color(255, 182, 193),
				new Color(255, 165, 0),
				new Color(221, 160, 221),
		};
		
		Color corNo = cores[Math.min(nivel, cores.length - 1)];
		
		//Desenha circulo com cor do nivel
		int raio = 25;
		g.setColor(corNo);
		g.fillOval(x - raio, y - raio, 2 * raio, 2 * raio);
		
		g.setColor(Color.BLACK);//borda
		g.setStroke(new BasicStroke(2));
		g.drawOval(x - raio, y - raio, 2 * raio,2 * raio);
		
		//Texto centralizado
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 14));
		String texto = String.valueOf(no.valor);
		FontMetrics fm = g.getFontMetrics();
		int larguraTexto = fm.stringWidth(texto);
		int alturaTexto = fm.getAscent();
		g.drawString(texto, x - larguraTexto / 2, y + alturaTexto / 4);
		
		//Desenha conexões
		if(no.esq != null) {
			g.setColor(Color.GRAY);
			int x1 = x - 15, y1 = y + 20;
			int x2 = x - espaco, y2 = y + 80;
			int ctrlX = (x1 + x2) / 2;
			int ctrlY = y1 + 40;
			
			java.awt.geom.QuadCurve2D curvaEsq = new java.awt.geom.QuadCurve2D.Float(
					x1, y1, ctrlX, ctrlY, x2, y2
			);
			g.draw(curvaEsq);
			
			desenharArvore(g, no.esq, x2, y2, espaco / 2, nivel + 1);
		}
		
		if(no.dir != null) {
			g.setColor(Color.GRAY);
			int x1 = x + 15, y1 = y + 20;
			int x2 = x + espaco, y2 = y + 80;
			int ctrlX = (x1 + x2) / 2;
			int ctrlY = y1 + 40;
			
			java.awt.geom.QuadCurve2D curvaDir = new java.awt.geom.QuadCurve2D.Float(
					x1, y1, ctrlX, ctrlY, x2, y2
			);
			g.draw(curvaDir);
			
			desenharArvore(g, no.dir, x2, y2, espaco / 2, nivel + 1);
		}
	}
	
	private void desenharLegenda(Graphics2D g) {
		String[] niveis = {"Raiz", "Filhos", "Netos", "Bisnetos", "Demais níveis"};
		Color[] cores = {
				new Color(135, 206, 250),
				new Color(144, 238, 144),
				new Color(255, 182, 193),
				new Color(255, 165, 0),
				new Color(221, 160, 221),
		};
		
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		int x = 20, y = 40;
		
		for(int i = 0; i < niveis.length; i++) {
			g.setColor(cores[i]);
			g.fillRect(x, y + i * 25, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRect(x, y + i * 25, 20, 20);
			g.drawString(niveis[i], x + 30, y + i * 25 + 15);
		}
	}
	
	public static void mostrar(No raiz) {
		JFrame frame = new JFrame("Árvore AVL");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
		frame.add(new ArvoreGUI(raiz));
		frame.setVisible(true);
	}
}
