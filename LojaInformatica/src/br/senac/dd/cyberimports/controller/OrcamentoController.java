package br.senac.dd.cyberimports.controller;

import java.util.List;

import br.senac.dd.cyberimports.model.bo.OrcamentoBO;
import br.senac.dd.cyberimports.model.vo.OrcamentoVO;

public class OrcamentoController {
private OrcamentoBO bo = new OrcamentoBO();
    
    public String salvar(OrcamentoVO orcamento) {
    	orcamento.toString();
              
        String validacao = validarorcamento(orcamento);

        if(validacao.equals("")) {
            if(orcamento.getId() > 0) {
                //UPDATE
                if(bo.atualizar(orcamento)) {
                    validacao = "Funcionário atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcionário";
                }
            }else{
                //INSERT
                if(bo.inserir(orcamento)) {
                    validacao = "Funcionário salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar funcionário";
                }
            }
        }
        return validacao;
    }
        
        public String atualizar(OrcamentoVO orcamento) {
              
        String validacao = validarorcamento(orcamento);

        if(validacao.equals("")) {
            if(orcamento.getId() > 0) {
               
                if(bo.atualizar(orcamento)) {
                    validacao = "Funcionário atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcionário";
                }
            }
        }
        return validacao;
    }
        
        public List<OrcamentoVO> listarTodosorcamentos(){
		return bo.listarorcamentos();
	}
        
        

	private String validarorcamento(OrcamentoVO orcamento) {
		String validacao = "";

		if(orcamento == null) {
                    validacao = "orcamento está NULO!";
		        
		}
		return validacao;
	}
}
