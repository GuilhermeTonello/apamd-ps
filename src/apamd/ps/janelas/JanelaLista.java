package apamd.ps.janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import apamd.ps.components.Tabela;
import apamd.ps.events.DeletarActionListenerImpl;
import apamd.ps.events.EditarActionListenerImpl;

public class JanelaLista extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTable tabela;
	
	public JanelaLista() {
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		
		JPanel painelTabela = new JPanel(new GridLayout(1, 1));
		tabela = new JTable(new Tabela());
		JScrollPane scroll = new JScrollPane(tabela);
		painelTabela.add(scroll);
		
		add(painelTabela, BorderLayout.CENTER);
		
		JPanel painelBotoes = new JPanel(new FlowLayout());
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new EditarActionListenerImpl());
		botaoEditar.setBackground(new Color(51, 153, 255));
		painelBotoes.add(botaoEditar);
		
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.addActionListener(new DeletarActionListenerImpl());
		botaoDeletar.setBackground(new Color(255, 102, 102));
		painelBotoes.add(botaoDeletar);
		
		add(painelBotoes, BorderLayout.SOUTH);
	}
	
	public JTable getTabela() {
		return tabela;
	}
	
}
