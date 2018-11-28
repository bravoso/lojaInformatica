package br.senac.dd.cyberimports.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.senac.dd.cyberimports.model.bo.ClienteBO;
import br.senac.dd.cyberimports.model.vo.ClienteVO;

public class ClienteController {
	
private ClienteBO bo = new ClienteBO();
    
    public String salvar(ClienteVO cliente) {
    	cliente.toString();
              
        String validacao = validarCliente(cliente);
        JOptionPane.showMessageDialog(null, validacao, "Atenção!", JOptionPane.OK_OPTION);

        if(validacao.equals("")) {
            if(cliente.getId() > 0) {
                //UPDATE
                if(bo.atualizar(cliente)) {
                    validacao = "Cliente atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar cliente";
                }
            }else{
                //INSERT
                if(bo.inserir(cliente)) {
                    validacao = "Cliente salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar cliente";
                }
            }
        }
        return validacao;
    }
        
        public String atualizar(ClienteVO cliente) {
              
        String validacao = validarCliente(cliente);

        if(validacao.equals("")) {
            if(cliente.getId() > 0) {
               
                if(bo.atualizar(cliente)) {
                    validacao = "Cliente atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar cliente";
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
                    if(cliente.getEndereço().trim().equals("")) {
                        validacao += "- Endereço é obrigatório \n";
                    }
                    if(cliente.getTelefone().trim().equals("")) {
                    	validacao += "- Telefone é obrigatório \n";
                    }
		}
		return validacao;
	}

}
