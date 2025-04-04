<!--- ![Image](https://github.com/user-attachments/assets/e4d53a63-2873-475c-96af-e0c716594326) --->

# 📦 Sistema de Gerenciamento de Produtos

<div align="center">
  <img src="https://github.com/user-attachments/assets/e4d53a63-2873-475c-96af-e0c716594326">
</div>

## 🚀 Sobre o Projeto
Este é um aplicativo desktop simples para gerenciamento de produtos, desenvolvido em **Java (SDK 17)** com **JDBC** e interface gráfica baseada em **Swing**. A aplicação permite realizar operações básicas de CRUD (Criar, Ler, Atualizar e Deletar) em um banco de dados MySQL.

🔹 **Tecnologias utilizadas:**
✅ **Eclipse** – IDE para desenvolvimento Java.  
✅ **Java JDK 17** – Programação orientada a objetos e manipulação de dados.  
✅ **JDBC (Java Database Connectivity)** – Comunicação com o banco de dados MySQL.  
✅ **Swing** – Interface gráfica amigável e interativa.  
✅ **MySQL** – Armazenamento e gerenciamento de produtos.  
✅ **XAMPP** – Ambiente de desenvolvimento para o banco de dados.

---

## 🛠️ Funcionalidades
✔️ **Cadastrar Produtos** – Insira novos produtos no banco de dados com nome, quantidade e preço.  
✔️ **Listar Produtos** – Exiba todos os produtos cadastrados em uma tabela interativa.  
✔️ **Buscar Produtos** – Pesquise produtos pelo nome de forma dinâmica.  
✔️ **Atualizar Produtos** – Modifique os detalhes de qualquer produto existente.  
✔️ **Excluir Produtos** – Remova produtos permanentemente com um clique.  

---

## 📂 Estrutura do Projeto

📁 **src/JdbcSwingMysql**
- 📂 **Util** – Contém a classe `ConexaoUtil` para conexão com o banco de dados.
- 📂 **Dto** – Contém a classe `ProdutoDTO`, responsável pelo modelo de dados dos produtos.
- 📂 **Dao** – Contém a classe `ProdutoDAO`, que implementa as operações no banco de dados.
- 📂 **View** – Contém a classe `ProdutoTela`, que gerencia a interface gráfica da aplicação.
