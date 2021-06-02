package apamd.ps.components;

import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import apamd.ps.service.MissaoService;

public class Tabela extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	public Tabela() {
		addColumn("ID");
		addColumn("DATA TERRA");
		addColumn("DIAS EM MARTE");
		addColumn("LONGITUDE SOLAR");
		addColumn("MÊS EM MARTE");
		addColumn("TEMPERATURA MÍNIMA");
		addColumn("TEMPERATURA MÁXIMA");
		addColumn("PRESSÃO ATMOSFÉRICA");
		
		MissaoService missaoService = new MissaoService();
		missaoService.procurarTodos().forEach(missao -> {
			addRow(new Object[] {
					missao.getId(),
					missao.getDataTerra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					missao.getNumeroDiasMarte(),
					missao.getLongitudeSolar(),
					missao.getMesMarte(),
					missao.getTemperaturaMinima(),
					missao.getTemperaturaMaxima(),
					missao.getPressaoAtmosferica()
			});
		});
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
