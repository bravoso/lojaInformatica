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
        JOptionPane.showMessageDialog(null, validacao, "Aten��o!", JOptionPane.OK_OPTION);

        if(validacao.equals("")) {
            if(cliente.getId() > 0) {
                //UPDATE
                if(bo.atualizar(cliente)) {
                    validacao = "Funcion�rio atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcion�rio";
                }
            }else{
                //INSERT
                if(bo.inserir(cliente)) {
                    validacao = "Funcion�rio salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar funcion�rio";
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
                    validacao = "Funcion�rio atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcion�rio";
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
                    validacao = "Cliente est� NULO!";
		}else {
                    //Validar o preenchimento
                    if(cliente.getNome().trim().equals("")) {
                        validacao += "- Nome � obrigat�rio \n";
                    }
                    if(cliente.getCpf().trim().equals("")) {
                        validacao += "- CPF � obrigat�rio \n";
                    }
                    if(cliente.getTelefone().trim().equals("")) {
                    	validacao += "- Telefone � obrigat�rio \n";
                    }
		}
		return validacao;
	}

}
