package br.senac.dd.cyberimports.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.senac.dd.cyberimports.model.dao.ServicoDAO;
import br.senac.dd.cyberimports.model.vo.ServicoVO;

public class ServicoBO {
private ServicoDAO dao = new ServicoDAO();
    
	public boolean inserir(ServicoVO servico) {
            int idGerado = dao.inserir(servico);
            return idGerado > 0;
	}
	public ServicoVO buscarServicoPorId(String textoId) {
            ServicoVO servicoBuscado = dao.obterPorId(Integer.parseInt(textoId));
            return servicoBuscado;
	}
        
        public List<ServicoVO> listarServicos() {
		ArrayList<ServicoVO> servicos = dao.listarTodos();
		return servicos;
	}
        
	public boolean atualizar(ServicoVO servico) {
            boolean sucesso = dao.atualizar(servico);
            return sucesso;
	}
}