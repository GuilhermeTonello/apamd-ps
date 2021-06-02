package apamd.ps.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import apamd.ps.janelas.Janela;
import apamd.ps.janelas.JanelaLista;
import apamd.ps.service.MissaoService;

public class DeletarActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JanelaLista janelaLista = (JanelaLista) Janela.getNavegacao().getComponentAt(1);
		JTable tabela = janelaLista.getTabela();
		int linha = tabela.getSelectedRow();
		if (linha >= 0) {
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja mesmo deletar essa missão?", "Deletar", JOptionPane.YES_NO_OPTION);
			if (escolha == JOptionPane.YES_OPTION) {
				MissaoService missaoService = new MissaoService();
				missaoService.deletarPorId(Integer.valueOf(String.valueOf(tabela.getValueAt(linha, 0))));
				Janela.getNavegacao().setSelectedIndex(0);
				Janela.getNavegacao().setSelectedIndex(1);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

}
