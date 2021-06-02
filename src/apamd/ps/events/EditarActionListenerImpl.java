package apamd.ps.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import apamd.ps.janelas.Janela;
import apamd.ps.janelas.JanelaCadastro;
import apamd.ps.janelas.JanelaLista;

public class EditarActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JanelaLista janelaLista = (JanelaLista) Janela.getNavegacao().getComponentAt(1);
		JTable tabela = janelaLista.getTabela();
		int linha = tabela.getSelectedRow();
		if (linha >= 0) {
			Janela.getNavegacao().setSelectedIndex(0);
			JanelaCadastro janelaCadastro = (JanelaCadastro) Janela.getNavegacao().getComponentAt(0);
			janelaCadastro.getCampoId().setText(String.valueOf(tabela.getValueAt(linha, 0)));
			janelaCadastro.getCampoDataTerra().setText(String.valueOf(tabela.getValueAt(linha, 1)));
			janelaCadastro.getCampoNumeroDiasMarte().setText(String.valueOf(tabela.getValueAt(linha, 2)));
			janelaCadastro.getCampoLongitudeSolar().setText(String.valueOf(tabela.getValueAt(linha, 3)));
			janelaCadastro.getCampoMesMarte().setText(String.valueOf(tabela.getValueAt(linha, 4)));
			janelaCadastro.getCampoTemperaturaMinima().setText(String.valueOf(tabela.getValueAt(linha, 5)));
			janelaCadastro.getCampoTemperaturaMaxima().setText(String.valueOf(tabela.getValueAt(linha, 6)));
			janelaCadastro.getCampoPressaoAtmosferica().setText(String.valueOf(tabela.getValueAt(linha, 7)));
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

}
