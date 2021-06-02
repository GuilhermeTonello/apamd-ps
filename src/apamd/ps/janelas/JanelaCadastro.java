package apamd.ps.janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import apamd.ps.events.LimparActionListenerImpl;
import apamd.ps.events.SalvarActionListenerImpl;

public class JanelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField campoId;
	private JTextField campoDataTerra;
	private JTextField campoNumeroDiasMarte;
	private JTextField campoLongitudeSolar;
	private JTextField campoMesMarte;
	private JTextField campoTemperaturaMinima;
	private JTextField campoTemperaturaMaxima;
	private JTextField campoPressaoAtmosferica;
	
	public JanelaCadastro() {
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		
		JPanel camposMissao = new JPanel(new GridLayout(16, 1));
		
		camposMissao.add(new JLabel("ID"));
		campoId = new JTextField();
		campoId.setEditable(false);
		camposMissao.add(campoId);
		
		camposMissao.add(new JLabel("Data Terra (dia/mês/ano)"));
		campoDataTerra = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		camposMissao.add(campoDataTerra);
		
		camposMissao.add(new JLabel("Números de dias em marte"));
		campoNumeroDiasMarte = new JTextField();
		camposMissao.add(campoNumeroDiasMarte);
		
		camposMissao.add(new JLabel("Longitude solar"));
		campoLongitudeSolar = new JTextField();
		camposMissao.add(campoLongitudeSolar);
		
		camposMissao.add(new JLabel("Mês em Marte"));
		campoMesMarte = new JTextField();
		camposMissao.add(campoMesMarte);
		
		camposMissao.add(new JLabel("Temperatura mínima (ºC)"));
		campoTemperaturaMinima = new JTextField();
		camposMissao.add(campoTemperaturaMinima);
		
		camposMissao.add(new JLabel("Temperatura máxima (ºC)"));
		campoTemperaturaMaxima = new JTextField();
		camposMissao.add(campoTemperaturaMaxima);
		
		camposMissao.add(new JLabel("Pressão atmosférica (Pa)"));
		campoPressaoAtmosferica = new JTextField();
		camposMissao.add(campoPressaoAtmosferica);
		
		JScrollPane scroll = new JScrollPane(camposMissao);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		add(scroll, BorderLayout.CENTER);
		
		JPanel botoes = new JPanel(new FlowLayout());
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new SalvarActionListenerImpl());
		botaoSalvar.setBackground(new Color(51, 153, 255));
		botoes.add(botaoSalvar);
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new LimparActionListenerImpl());
		botaoLimpar.setBackground(new Color(255, 102, 102));
		botoes.add(botaoLimpar);
		
		add(botoes, BorderLayout.SOUTH);
	}

	public JTextField getCampoId() {
		return campoId;
	}

	public JTextField getCampoDataTerra() {
		return campoDataTerra;
	}

	public JTextField getCampoNumeroDiasMarte() {
		return campoNumeroDiasMarte;
	}

	public JTextField getCampoLongitudeSolar() {
		return campoLongitudeSolar;
	}

	public JTextField getCampoMesMarte() {
		return campoMesMarte;
	}

	public JTextField getCampoTemperaturaMinima() {
		return campoTemperaturaMinima;
	}

	public JTextField getCampoTemperaturaMaxima() {
		return campoTemperaturaMaxima;
	}

	public JTextField getCampoPressaoAtmosferica() {
		return campoPressaoAtmosferica;
	}

}
