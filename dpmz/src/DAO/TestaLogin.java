package DAO;

import DTO.FuncionarioService;
import Model.Funcionario;

public class TestaLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuncionarioService funcionarioService = new FuncionarioService();
		
		
		
		for (Funcionario funcionario: funcionarioService.listarFuncionario()){
			System.out.println("Lista: "+ funcionario.getApelido());
		}
	}

}
