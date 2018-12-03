package br.senac.dd.cyberimports.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.senac.dd.cyberimports.model.dao.OrcamentoDAO;
import br.senac.dd.cyberimports.model.vo.OrcamentoVO;

public class OrcamentoBO {

	OrcamentoDAO dao = new OrcamentoDAO();
	
	public boolean inserir(OrcamentoVO orcamento) {
        int idGerado = dao.inserir(orcamento);
        return idGerado > 0;
}
public OrcamentoVO buscarorcamentoPorId(String textoId) {
        OrcamentoVO orcamentoBuscado = dao.obterPorId(Integer.parseInt(textoId));
        return orcamentoBuscado;
}
    
    public List<OrcamentoVO> listarorcamentos() {
	ArrayList<OrcamentoVO> orcamentos = dao.listarTodos();
	return orcamentos;
}
    
public boolean atualizar(OrcamentoVO orcamento) {
        boolean sucesso = dao.atualizar(orcamento);
        return sucesso;
}
	
}
