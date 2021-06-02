package apamd.ps.service;

import apamd.ps.dao.GenericDao;
import apamd.ps.model.Missao;

public class MissaoService extends GenericDao<Missao, Integer> {
	
	public MissaoService() {
		super(Missao.class, "apamd-ps");
	}

}
