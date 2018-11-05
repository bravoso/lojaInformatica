package br.senac.dd.cyberimports.controller;

import java.util.List;

import br.senac.dd.cyberimports.model.bo.ClienteBO;
import br.senac.dd.cyberimports.model.vo.ClienteVO;

public class ClienteController {
	
private ClienteBO bo = new ClienteBO();
    
    public String salvar(ClienteVO funcionario) {
              
        String validacao = validarCliente(funcionario);

        if(validacao.equals("")) {
            if(funcionario.getId() > 0) {
                //UPDATE
                if(bo.atualizar(funcionario)) {
                    validacao = "Funcionário atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcionário";
                }
            }else{
                //INSERT
                if(bo.inserir(funcionario)) {
                    validacao = "Funcionário salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar funcionário";
                }
            }
        }
        return validacao;
    }
        
        public String atualizar(ClienteVO funcionario) {
              
        String validacao = validarCliente(funcionario);

        if(validacao.equals("")) {
            if(funcionario.getId() > 0) {
               
                if(bo.atualizar(funcionario)) {
                    validacao = "Funcionário atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcionário";
                }
            }
        }
        return validacao;
    }
        
        public List<ClienteVO> listarTodosClientes(){
		return bo.listarClientes();
	}
        
        

	private String validarCliente(ClienteVO cliente) {
		String validacao = "";

		if(cliente == null) {
                    validacao = "Cliente está NULO!";
		}else {
                    //Validar o preenchimento
                    if(cliente.getNome().trim().equals("")) {
                        validacao += "- Nome é obrigatório \n";
                    }
                    if(cliente.getCpf().trim().equals("")) {
                        validacao += "- CPF é obrigatório \n";
                    }
		}
		return validacao;
	}

}
