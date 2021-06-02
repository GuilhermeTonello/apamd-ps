package apamd.ps.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import apamd.ps.janelas.Janela;
import apamd.ps.janelas.JanelaCadastro;
import apamd.ps.model.Missao;
import apamd.ps.service.MissaoService;

public class SalvarActionListenerImpl implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja mesmo salvar essa missão?", "Salvar", JOptionPane.YES_NO_OPTION);
		if (escolha == JOptionPane.YES_OPTION) {
			JanelaCadastro janelaCadastro = (JanelaCadastro) Janela.getNavegacao().getComponentAt(0);
			for (Method metodo : janelaCadastro.getClass().getDeclaredMethods()) {
				if (metodo.getName().startsWith("getCampo") && !metodo.getName().equals("getCampoId")) {
					try {
						JTextField campo = (JTextField) metodo.invoke(janelaCadastro);
						if (campo.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
			Missao missao = new Missao();
			try {
				if (!janelaCadastro.getCampoId().getText().isBlank()) {
					missao.setId(Integer.valueOf(janelaCadastro.getCampoId().getText()));
				}
				missao.setDataTerra(LocalDate.parse(janelaCadastro.getCampoDataTerra().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				missao.setLongitudeSolar(BigDecimal.valueOf(Double.valueOf(janelaCadastro.getCampoLongitudeSolar().getText().replace(",", "."))));
				missao.setMesMarte(Integer.valueOf(janelaCadastro.getCampoMesMarte().getText()));
				missao.setNumeroDiasMarte(Integer.valueOf(janelaCadastro.getCampoNumeroDiasMarte().getText()));
				missao.setPressaoAtmosferica(Double.valueOf(janelaCadastro.getCampoPressaoAtmosferica().getText().replace(",", ".")));
				missao.setTemperaturaMaxima(Double.valueOf(janelaCadastro.getCampoTemperaturaMaxima().getText().replace(",", ".")));
				missao.setTemperaturaMinima(Double.valueOf(janelaCadastro.getCampoTemperaturaMinima().getText().replace(",", ".")));
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Utilize números nos campos ou a data no formato correto!", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			MissaoService missaoService = new MissaoService();
			if (missao.getId() == null) {
				missaoService.cadastrar(missao);
			} else {
				missaoService.atualizar(missao);
			}
			
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
