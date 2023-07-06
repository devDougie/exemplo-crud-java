package JdbcSwingMysql.View;

import java.util.List;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import JdbcSwingMysql.Dao.ProdutoDAO;
import JdbcSwingMysql.Dto.ProdutoDTO;

public class ProdutoTela {

	private JFrame frame;
	
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblQuantidade;
	private JLabel lblPreco;
	
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtQuantidade;
    private JTextField txtPreco;
    
    private JButton btnCadastrar;
    private JButton btnLocalizar;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private JButton btnLimpar;
    
    private JTable tabProdutos;
    
    private ProdutoDAO produtoDAO;

	
    // Criando a aplicação:
 	public ProdutoTela() {
 		initialize();
 		produtoDAO = new ProdutoDAO();
 		listarProdutos();
 	}
 	
 	// Iniciando os componentes do Frame:
 	private void initialize() {
 		frame = new JFrame();
 		//frame.setBounds(100, 100, 450, 300);
 		frame.setBounds(100, 100, 575, 385);
 		frame.setTitle("Cadastro de Produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false); // Impede o redimensionamento da janela;
        
        lblId = new JLabel("ID:");
        //lblId.setBounds(10, 10, 80, 25);
        lblId.setBounds(10, 11, 100, 14);
        frame.getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setEnabled(false);
        //txtId.setBounds(100, 10, 200, 25);
        txtId.setBounds(10, 28, 100, 20);
        frame.getContentPane().add(txtId);
        
        lblNome = new JLabel("Nome:");
        //lblNome.setBounds(10, 40, 80, 25);
        lblNome.setBounds(120, 11, 190, 14);
        frame.getContentPane().add(lblNome);

        txtNome = new JTextField();
        //txtNome.setBounds(100, 40, 200, 25);
        txtNome.setBounds(120, 28, 190, 20);
        frame.getContentPane().add(txtNome);

        lblQuantidade = new JLabel("Quantidade:");
        //lblQuantidade.setBounds(10, 70, 80, 25);
        lblQuantidade.setBounds(320, 11, 110, 14);
        frame.getContentPane().add(lblQuantidade);

        txtQuantidade = new JTextField();
        //txtQuantidade.setBounds(100, 70, 200, 25);
        txtQuantidade.setBounds(320, 28, 110, 20);
        frame.getContentPane().add(txtQuantidade);

        lblPreco = new JLabel("Preço Unitário:");
        //lblPreco.setBounds(10, 100, 80, 25);
        lblPreco.setBounds(440, 11, 110, 14);
        frame.getContentPane().add(lblPreco);

        txtPreco = new JTextField();
        //txtPreco.setBounds(100, 100, 200, 25);
        txtPreco.setBounds(440, 28, 110, 20);
        frame.getContentPane().add(txtPreco);
        
        
        btnCadastrar = new JButton("Cadastrar");
        //btnCadastrar.setBounds(10, 140, 100, 25);
        btnCadastrar.setBounds(10, 59, 100, 30);
        frame.getContentPane().add(btnCadastrar);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        btnLocalizar = new JButton("Localizar");
        //btnLocalizar.setBounds(120, 140, 100, 25);
        btnLocalizar.setBounds(120, 59, 100, 30);
        frame.getContentPane().add(btnLocalizar);
        btnLocalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                localizarProduto();
            }
        });

        btnAtualizar = new JButton("Atualizar");
        //btnAtualizar.setBounds(230, 140, 100, 25);
        btnAtualizar.setBounds(230, 59, 100, 30);
        frame.getContentPane().add(btnAtualizar);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarProduto();
            }
        });

        btnExcluir = new JButton("Excluir");
        //btnExcluir.setBounds(340, 140, 100, 25);
        btnExcluir.setBounds(450, 59, 100, 30);
        frame.getContentPane().add(btnExcluir);
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirProduto();
            }
        });

        btnLimpar = new JButton("Limpar");
        //btnLimpar.setBounds(230, 170, 100, 25);
        btnLimpar.setBounds(340, 59, 100, 30);
        frame.getContentPane().add(btnLimpar);
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        
        tabProdutos = new JTable();
        tabProdutos.setBounds(10, 95, 540, 240);
        frame.getContentPane().add(tabProdutos);
        JScrollPane scrollPane = new JScrollPane(tabProdutos);
        scrollPane.setBounds(10, 100, 540, 237);
        frame.getContentPane().add(scrollPane);
        
        // Carregar os dados de uma linha da tabela nos textfields correspondentes com evendo de 'MouseClick':
        tabProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowIndex = tabProdutos.getSelectedRow();
                
                if (rowIndex != -1) {
                    String id = tabProdutos.getValueAt(rowIndex, 0).toString();
                    String nome = tabProdutos.getValueAt(rowIndex, 1).toString();
                    String quantidade = tabProdutos.getValueAt(rowIndex, 2).toString();
                    String preco = tabProdutos.getValueAt(rowIndex, 3).toString();
                    
                    txtId.setText(id);
                    txtNome.setText(nome);
                    txtQuantidade.setText(quantidade);
                    txtPreco.setText(preco);
                }
            }
        });
 	}
 	
 	public void show() {
        frame.setVisible(true);
    }

    private void cadastrarProduto() {
    	if(txtNome.getText().isEmpty() || txtQuantidade.getText().isEmpty() || txtPreco.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos antes de cadastrar o produto.");
    	}else {
    		ProdutoDTO produto = new ProdutoDTO();
            produto.setNome(txtNome.getText());
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            produto.setPreco(Float.parseFloat(txtPreco.getText()));

            produtoDAO.Create(produto);
            limparCampos();
            listarProdutos();
    	}
    }

    private void localizarProduto() {
    	if(txtNome.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Por favor, preencha o campo 'Nome' antes de Localizar o produto.");
    	}else {
    		String nome = txtNome.getText();
            List<ProdutoDTO> produtos = produtoDAO.Search(nome);
            
            if (!produtos.isEmpty()) {
                ProdutoDTO produto = produtos.get(0);
                txtId.setText(String.valueOf(produto.getId()));
                txtNome.setText(produto.getNome());
                txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
                txtPreco.setText(String.valueOf(produto.getPreco()));
            } else {
                // Caso a lista de produtos esteja vazia, limpar os campos de texto;
                limparCampos();
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            }
            
            exibirProdutos(produtos);
    	}
    }

    private void atualizarProduto() {
    	if(txtNome.getText().isEmpty() || txtQuantidade.getText().isEmpty() || txtPreco.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Por favor, selecione na lista ou localize um produto antes de Atualizar o produto.");
    	}else {
    		ProdutoDTO produto = new ProdutoDTO();
            produto.setId(Integer.parseInt(txtId.getText()));
            produto.setNome(txtNome.getText());
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            produto.setPreco(Float.parseFloat(txtPreco.getText()));

            produtoDAO.Update(produto);
            limparCampos();
            listarProdutos();
    	} 
    }

    private void excluirProduto() {
    	if(txtId.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Por favor, selecione na lista ou localize um produto antes de Excluir o produto.");
    	}else {
    		ProdutoDTO produto = new ProdutoDTO();
            produto.setId(Integer.parseInt(txtId.getText()));

            produtoDAO.Delete(produto);
            limparCampos();
            listarProdutos();
    	}
    }

    private void listarProdutos() {
        List<ProdutoDTO> produtos = produtoDAO.Read();
        exibirProdutos(produtos);
    }

    private void exibirProdutos(List<ProdutoDTO> produtos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Quantidade");
        model.addColumn("Preço Unitário");

        for (ProdutoDTO produto : produtos) {
            Object[] row = new Object[4];
            row[0] = produto.getId();
            row[1] = produto.getNome();
            row[2] = produto.getQuantidade();
            row[3] = produto.getPreco();
            model.addRow(row);
        }

        tabProdutos.setModel(model);
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtQuantidade.setText("");
        txtPreco.setText("");
        listarProdutos();
    }
    
    // Iniciando a aplicação:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoTela window = new ProdutoTela();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null); // Posiciona a janela no centro;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
