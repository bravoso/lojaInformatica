package br.senac.dd.cyberimports.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.senac.dd.cyberimports.model.dao.ProdutoDAO;
import br.senac.dd.cyberimports.model.vo.ProdutoVO;

public class ProdutoBO {
	
private ProdutoDAO dao = new ProdutoDAO();
    
	public boolean inserir(ProdutoVO produto) {
            int idGerado = dao.inserir(produto);
            return idGerado > 0;
	}
	public ProdutoVO buscarProdutoPorId(String textoId) {
            ProdutoVO produtoBuscado = dao.obterPorId(Integer.parseInt(textoId));
            return produtoBuscado;
	}
        
        public List<ProdutoVO> listarProdutos() {
		ArrayList<ProdutoVO> produtos = dao.listarTodos();
		return produtos;
	}
        
	public boolean atualizar(ProdutoVO produto) {
            boolean sucesso = dao.atualizar(produto);
            return sucesso;
	}

}
