package br.senac.dd.cyberimports.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.senac.dd.cyberimports.model.dao.ClienteDAO;
import br.senac.dd.cyberimports.model.vo.ClienteVO;

public class ClienteBO {
	
private ClienteDAO dao = new ClienteDAO();
    
	public boolean inserir(ClienteVO cliente) {
            int idGerado = dao.inserir(cliente);
            return idGerado > 0;
	}
	public ClienteVO buscarClientePorId(String textoId) {
            ClienteVO clienteBuscado = dao.obterPorId(Integer.parseInt(textoId));
            return clienteBuscado;
	}
        
        public List<ClienteVO> listarClientes() {
		ArrayList<ClienteVO> clientes = dao.listarTodos();
		return clientes;
	}
        
	public boolean atualizar(ClienteVO cliente) {
            boolean sucesso = dao.atualizar(cliente);
            return sucesso;
	}

}
