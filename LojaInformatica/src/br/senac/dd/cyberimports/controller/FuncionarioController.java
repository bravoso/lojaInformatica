package br.senac.dd.cyberimports.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.senac.dd.cyberimports.model.bo.FuncionarioBO;
import br.senac.dd.cyberimports.model.vo.FuncionarioVO;

public class FuncionarioController {
private FuncionarioBO bo = new FuncionarioBO();
    
    public String salvar(FuncionarioVO funcionario) {
    	funcionario.toString();
              
        String validacao = validarfuncionario(funcionario);

        if(validacao.equals("")) {
            if(funcionario.getId() > 0) {
                //UPDATE
                if(bo.atualizar(funcionario)) {
                    validacao = "Funcion�rio atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcion�rio";
                }
            }else{
                //INSERT
                if(bo.inserir(funcionario)) {
                    validacao = "Funcion�rio salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar funcion�rio";
                }
            }
        }
        return validacao;
    }
        
        public String atualizar(FuncionarioVO funcionario) {
              
        String validacao = validarfuncionario(funcionario);

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
        
        public List<FuncionarioVO> listarTodosfuncionarios(){
		return bo.listarFuncionarios();
	}
        
        

	private String validarfuncionario(FuncionarioVO funcionario) {
		String validacao = "";

		if(funcionario == null) {
                    validacao = "funcionario est� NULO!";
		}else {
                    //Validar o preenchimento
                    if(funcionario.getNome().trim().equals("")) {
                        validacao += "- Nome � obrigat�rio \n";
                    }
                    if(funcionario.getCpf().trim().equals("")) {
                        validacao += "- CPF � obrigat�rio \n";
                    }
                    if(String.valueOf(funcionario.getSalario()).trim().equals("")) {
                    	validacao += "- Telefone � obrigat�rio \n";
                    }
		}
		return validacao;
	}
}
