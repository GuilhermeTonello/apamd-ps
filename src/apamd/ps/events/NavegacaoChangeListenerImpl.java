package apamd.ps.events;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import apamd.ps.janelas.JanelaLista;

public class NavegacaoChangeListenerImpl implements ChangeListener {
	
	private JTabbedPane navegacao;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		navegacao = (JTabbedPane) e.getSource();
		if (navegacao.getSelectedIndex() == 1) {
			navegacao.setComponentAt(1, new JanelaLista());
		}
	}

}
