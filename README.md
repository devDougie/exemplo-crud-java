<!--- ![Image](https://github.com/user-attachments/assets/aa2958d5-10ac-421f-9530-5648011ef1f7) --->

# 📦 Sistema de Gerenciamento de Produtos

<div align="center">
  <img src="https://github.com/user-attachments/assets/aa2958d5-10ac-421f-9530-5648011ef1f7">
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
✔️ **Atualizar Produtos** – Modifique os detalhes de qualquer produto existente selecionando a partir da lista e alterando os campos.  
✔️ **Excluir Produtos** – Remova produtos permanentemente com um clique.  

---

## 📂 Estrutura do Projeto

📁 **src/JdbcSwingMysql**
- 📂 **Util** – Contém a classe `ConexaoUtil` para conexão com o banco de dados.
- 📂 **Dto** – Contém a classe `ProdutoDTO`, responsável pelo modelo de dados dos produtos.
- 📂 **Dao** – Contém a classe `ProdutoDAO`, que implementa as operações no banco de dados.
- 📂 **View** – Contém a classe `ProdutoTela`, que gerencia a interface gráfica da aplicação.

---

## 🧑‍💻 Como Executar
**1. Requisitos:**

Baixe o projeto do repositório do Github e antes de executar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java JDK 17 ou superior.
- XAMPP para ambiente local de servidor e banco de dados MySQL.
- Eclipse IDE para desenvolvimento Java.
- Driver JDBC para conexão com banco de dados MySQL (platform independent).


**2. Configuração do Banco de Dados:**

O projeto utiliza um banco de dados MySQL para armazenar os produtos. No repositório, você encontrará um arquivo SQL 
chamado 'produtos_db.sql', que contém o script para criação do banco de dados e da tabela de produtos.

**Passos para configurar o banco de dados:**
1. Abra o XAMPP e inicie o Apache e o MySQL.
2. Abra o phpMyAdmin no navegador (geralmente em http://localhost/phpmyadmin).
3. No phpMyAdmin, abra a guia 'Banco de dados' e crie um banco de dados com o nome 'produtos_db'.
4. Abra a guia 'Importar', selecione o arquivo 'produtos_db.sql' e depois clique no botão 'Importar'.

Após a importação, o banco de dados estará configurado com a tabela produtos necessária.


**3. Configuração da Conexão JDBC:**
1. Abra o Eclipse e importe a pasta do projeto 'cadastro-produtos' que está em "exemplo-crud-java/cadastro-produtos".
2. Clique com botão direito do mouse em JRE System Library, clique em 'Build Path' e depois em 'Configure Build Path'.
3. Na guia 'Libraries' selecione 'Modulepath' e depois clique em 'Add External JARs'.
4. Selecione o arquivo do driver do conector MySQL 'mysql-connector-j-8.0.31.jar' e clique em 'Apply and Close'.


**4. Compilação e Execução:**
1. No projeto aberto no Eclipse, abra o arquivo 'ProdutoTela.java' (localizado em "src/JdbcSwingMysql/View").
2. Clique com o botão direito do mouse no arquivo 'ProdutoTela.java' e selecione 'Run as' e depois 'Java Application' para executar a aplicação.
3. Agora você poderá testar as funcionalidades da aplicação do projeto.


**5. Interação com a Aplicação:**

A aplicação fornece uma interface gráfica simples com as seguintes funcionalidades:

1. Cadastrar Produto: Para cadastrar um produto é obrigatório o preenchimento dos campos 'nome', 'quantidade' e 'preço' e em seguida clicar no botão 'Cadastrar'.
2. Listar Produtos: A listagem dos produtos é automática e após qualquer operação de adição, alteração ou exclusão a lista será imediatamente atualizada.
3. Localizar Produto: A pequisa de um produto em específico pode ser feita digitando o nome dele no campo 'nome' e em seguida clicar no botão 'Localizar'.
4. Atualizar Produto: Para atualizar os dados de um produto existente, selecione ele a partir da lista com um clique e modifique algum dos campos e clique no botão 'Atualizar'.
5. Excluir Produto: Para remover um produto do banco de dados, selecione algum a partir da lista com um clique e clique no botão 'Excluir'.
6. Limpar campos: O botão 'Limpar' serve apenas para resetar os campos 'nome', 'quantidade' e 'preço'.
