package apamd.ps.janelas;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import apamd.ps.events.NavegacaoChangeListenerImpl;

public class Janela extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static JTabbedPane navegacao;
	
	public Janela() {
		super("APAMD - PS");
		init();
	}
	
	private void init() {
		
		navegacao = new JTabbedPane();
		
		navegacao.addTab("Cadastro", new JanelaCadastro());
		navegacao.addTab("Lista", new JanelaLista());
		
		navegacao.addChangeListener(new NavegacaoChangeListenerImpl());
		
		add(navegacao);
		
		ImageIcon icon = new ImageIcon("src" + File.separator + "resources" + File.separator + "icon.png");
		setIconImage(icon.getImage());
		
		setSize(700, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static JTabbedPane getNavegacao() {
		return navegacao;
	}
	
}
