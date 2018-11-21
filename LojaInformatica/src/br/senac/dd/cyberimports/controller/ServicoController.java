package br.senac.dd.cyberimports.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.senac.dd.cyberimports.model.bo.ServicoBO;
import br.senac.dd.cyberimports.model.vo.ServicoVO;

public class ServicoController {
	ServicoBO bo = new ServicoBO();
	
	
	public String salvar(ServicoVO servico) {

		String validacao = validarservico(servico);

		if (validacao.equals("")) {
			if (servico.getId() > 0) {
				// UPDATE
				if (bo.atualizar(servico)) {
					validacao = "servico atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar servico";
				}
			} else {
				// INSERT
				if (bo.inserir(servico)) {
					validacao = "servico salvo com sucesso!";
				} else {
					validacao = "Erro ao salvar servico";
				}
			}
		}
		return validacao;
	}

	public String atualizar(ServicoVO servico) {

		String validacao = validarservico(servico);

		if (validacao.equals("")) {
			if (servico.getId() > 0) {

				if (bo.atualizar(servico)) {
					validacao = "servico atualizado com sucesso!";
				} else {
					validacao = "Erro ao atualizar servico";
				}
			}
		}
		return validacao;
	}

	public List<ServicoVO> listarTodosservicos() {
		return bo.listarServicos();
	}

	private String validarservico(ServicoVO servico) {
		String validacao = "";

		if (servico == null) {
			validacao = "servico está NULO!";
		} else {
			// Validar o preenchimento
			if (servico.getNome().trim().equals("")) {
				validacao += "- Nome é obrigatório \n";
			}
		}
		return validacao;
	}
}
