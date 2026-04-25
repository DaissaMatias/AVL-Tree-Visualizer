# AVL Tree Visualizer

Projeto em Java que implementa uma **árvore AVL** e gera sua visualização tanto em **arquivos (PNG, SVG, PDF via Graphviz)** quanto em uma **interface gráfica com Swing**.

## ✨ Funcionalidades
- Inserção de valores em uma árvore AVL com balanceamento automático.
- Exportação para `.dot` e geração de imagens com **Graphviz**.
- Visualização direta em uma janela Java Swing, com nós coloridos e conexões curvas.
- Legenda de cores para identificar cada nível da árvore.

## 📸 Exemplo de saída
### Visualização com Swing
![Exemplo Swing](https://raw.githubusercontent.com/DaissaMatias/AVL-Tree-Visualizer/refs/heads/main/exemplo.JPG)

*(A árvore é desenhada em uma janela com cores diferentes por nível e conexões curvas.)*

### Arquivo gerado com Graphviz
O programa também gera automaticamente:
- `arvore.png`
- `arvore.svg`
- `arvore.pdf`

## 🚀 Como rodar
1. Clone este repositório:
   ```bash
   git clone https://github.com/seuUsuario/AVL-Tree-Visualizer.git
2. Abra no Eclipse ou outro IDE Java.
3. Compile e rode a classe Principal.java.
4. Veja a árvore na janela Swing e os arquivos gerados na pasta do projeto.

## 🛠️ Pré-requisitos
- Java 17+ (ou versão compatível).
- Graphviz instalado e acessível pelo comando dot.

## 🎯 Objetivo
Este projeto foi desenvolvido como parte da disciplina **Algoritmos e Estrutura de Dados**, ministrada pelo professor **Nataniel Paiva** na **Gran Faculdade**.  
O foco é **visualizar o funcionamento da árvore AVL** de forma clara e didática, destacando o aspecto visual da estrutura de dados.
