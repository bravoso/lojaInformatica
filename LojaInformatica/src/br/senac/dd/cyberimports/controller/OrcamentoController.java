package br.senac.dd.cyberimports.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

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
                    validacao = "Funcion�rio atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcion�rio";
                }
            }else{
                //INSERT
                if(bo.inserir(orcamento)) {
                    validacao = "Funcion�rio salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar funcion�rio";
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
                    validacao = "Funcion�rio atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcion�rio";
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
                    validacao = "orcamento est� NULO!";
		        
		}
		return validacao;
	}
	
	OrcamentoVO orcamentos = new OrcamentoVO();
	
	public void gerarPlanilhaOrcamentos(List<OrcamentoVO> orcamentos, String caminho) {
		String[] colunasDaPlanilha = {"ID","Status Or�amento", "Vendedor","Cliente","Valor"};
		
		HSSFWorkbook planilha = new HSSFWorkbook();
		
		// cria aba da planilha
		
		HSSFSheet abaPlanilha = planilha.createSheet("Or�amentos");
		
		HSSFRow headerRow = abaPlanilha.createRow(0);
		
		// cria cabe�alho a partir de um array de columns
		
		for (int i = 0; i < colunasDaPlanilha.length; i++) {
			Cell cell = ((org.apache.poi.ss.usermodel.Row) headerRow).createCell(i);
			cell.setCellValue(colunasDaPlanilha[i]);	
		}
		
		// cria as linhas da tabela
		
		int rowNum = 1;
		for (OrcamentoVO orc : orcamentos) {
			HSSFRow novaLinha = abaPlanilha.createRow(rowNum++);
			
			novaLinha.createCell(0).setCellValue(orc.getId());
			novaLinha.createCell(0).setCellValue(orc.getStatus_orcamento());
			novaLinha.createCell(0).setCellValue(orc.getVendedor());
			novaLinha.createCell(0).setCellValue(orc.getCliente());
			novaLinha.createCell(0).setCellValue(orc.getValor());
		}
		
		// ajusta o tamanho de acordo com o conte�do
		
		for (int i = 0; i < colunasDaPlanilha.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}
		
		// escreve o caminho em disco conforme caminho informado
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(caminho + ".xls");
			planilha.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
					planilha.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
}
