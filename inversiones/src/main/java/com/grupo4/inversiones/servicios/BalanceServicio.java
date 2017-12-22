package com.grupo4.inversiones.servicios;

import java.util.List;

import com.grupo4.inversiones.App;
import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.repositorio.Repositorio;

public class BalanceServicio {

	public List<Balance> getBalances(long idEmpresa) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		List<Balance> res = repositorio.balances().getBalances(idEmpresa);
		repositorio.cerrar();
		return res;
	}

	public List<Balance> eliminarBalance(long id) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		List<Balance> res = repositorio.balances().eliminarBalance(id);
		repositorio.cerrar();
		return res;
	}

	public List<Balance> agregarBalance(int capitalPropio, int deuda, int ebitda, int fCashFlow, int fds,
			int ingNetoOpCont, int ingNetoOpDiscont, int periodo, long idEmpresa) {
		Balance balance = new Balance(periodo, ebitda, fds, fCashFlow, ingNetoOpCont, ingNetoOpDiscont, deuda, capitalPropio, idEmpresa);
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.balances().persistir(balance);
		repositorio.cerrar();
		return getBalances(idEmpresa);
	}
	
	public void agregarBalanceSinRetorno(int capitalPropio, int deuda, int ebitda, int fCashFlow, int fds,
			int ingNetoOpCont, int ingNetoOpDiscont, int periodo, long idEmpresa) {
		Balance balance = new Balance(periodo, ebitda, fds, fCashFlow, ingNetoOpCont, ingNetoOpDiscont, deuda, capitalPropio, idEmpresa);
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.balances().persistir(balance);
		repositorio.cerrar();
	}

	public List<Balance> modificarBalance(long id, int capitalPropio, int deuda, int ebitda, int fCashFlow, int fds,
			int ingNetoOpCont, int ingNetoOpDiscont, int periodo, long idEmpresa) {
		Repositorio repositorio = new Repositorio(App.EM_FACTORY.createEntityManager());
		repositorio.balances().modificarBalance(id, capitalPropio, deuda, ebitda, fCashFlow, fds, ingNetoOpCont, ingNetoOpDiscont, periodo, idEmpresa);
		repositorio.cerrar();
		return getBalances(idEmpresa);
	}

}
