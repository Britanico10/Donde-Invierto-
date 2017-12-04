package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.repositorio.Repositorio;

public class BalanceServicio {
	
	Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());

	public List<Balance> getBalances(long idEmpresa) {
		return repositorio.balances().getBalances(idEmpresa);
	}

	public List<Balance> eliminarBalance(long id) {
		return repositorio.balances().eliminarBalance(id);
	}

	public List<Balance> agregarBalance(int capitalPropio, int deuda, int ebitda, int fCashFlow, int fds,
			int ingNetoOpCont, int ingNetoOpDiscont, int periodo, long idEmpresa) {
		Balance balance = new Balance(periodo, ebitda, fds, fCashFlow, ingNetoOpCont, ingNetoOpDiscont, deuda, capitalPropio, idEmpresa);
		repositorio.balances().persistir(balance);
		return getBalances(idEmpresa);
	}

	public List<Balance> modificarBalance(long id, int capitalPropio, int deuda, int ebitda, int fCashFlow, int fds,
			int ingNetoOpCont, int ingNetoOpDiscont, int periodo, long idEmpresa) {
		repositorio.balances().modificarBalance(id, capitalPropio, deuda, ebitda, fCashFlow, fds, ingNetoOpCont, ingNetoOpDiscont, periodo, idEmpresa);
		return getBalances(idEmpresa);
	}
	
	

}
