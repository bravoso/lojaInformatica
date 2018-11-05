package br.senac.dd.cyberimports.controller;

import java.util.List;

import br.senac.dd.cyberimports.model.bo.ProdutoBO;
import br.senac.dd.cyberimports.model.vo.ProdutoVO;

public class ProdutoController {
	
private ProdutoBO bo = new ProdutoBO();
    
    public String salvar(ProdutoVO produto) {
              
        String validacao = validarProduto(produto);

        if(validacao.equals("")) {
            if(produto.getId() > 0) {
                //UPDATE
                if(bo.atualizar(produto)) {
                    validacao = "Produto atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar produto";
                }
            }else{
                //INSERT
                if(bo.inserir(produto)) {
                    validacao = "Produto salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar produto";
                }
            }
        }
        return validacao;
    }
        
        public String atualizar(ProdutoVO produto) {
              
        String validacao = validarProduto(produto);

        if(validacao.equals("")) {
            if(produto.getId() > 0) {
               
                if(bo.atualizar(produto)) {
                    validacao = "Produto atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar produto";
                }
            }
        }
        return validacao;
    }
        
        public List<ProdutoVO> listarTodosProdutos(){
		return bo.listarProdutos();
	}
        
        

	private String validarProduto(ProdutoVO produto) {
		String validacao = "";

		if(produto == null) {
                    validacao = "Produto está NULO!";
		}else {
                    //Validar o preenchimento
                    if(produto.getNome().trim().equals("")) {
                        validacao += "- Nome é obrigatório \n";
                    }
		}
		return validacao;
	}


}
