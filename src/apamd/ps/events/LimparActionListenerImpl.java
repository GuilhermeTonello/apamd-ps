package apamd.ps.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import apamd.ps.janelas.Janela;
import apamd.ps.janelas.JanelaCadastro;

public class LimparActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja mesmo limpar os campos?", "Limpar", JOptionPane.YES_NO_OPTION);
		if (escolha == JOptionPane.YES_OPTION) {
			JanelaCadastro janelaCadastro = (JanelaCadastro) Janela.getNavegacao().getComponentAt(0);
			for (Method metodo : janelaCadastro.getClass().getDeclaredMethods()) {
				if (metodo.getName().startsWith("getCampo")) {
					try {
						JTextField campo = (JTextField) metodo.invoke(janelaCadastro);
						campo.setText("");
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}

}
