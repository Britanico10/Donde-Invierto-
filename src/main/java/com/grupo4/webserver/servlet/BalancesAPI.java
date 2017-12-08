package com.grupo4.webserver.servlet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.inversiones.entidades.Balance;
import com.grupo4.inversiones.servicios.Servicios;
import com.grupo4.webserver.utils.AuthUtils;

@RestController
@RequestMapping("/api/balances")
public class BalancesAPI {
		Servicios servicios = Servicios.getInstance();
		
		@RequestMapping(method = GET)
		public List<Balance> retornarBalances(@RequestParam(value = "idEmpresa", defaultValue = "", required = false) long idEmpresa,
											  @RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{

			long userId = AuthUtils.validarToken(token);
			if (userId == -1L) {
				throw new Exception("Token inválido, vuelva a iniciar sesión.");
			}
			
			return servicios.getBalanceServicio().getBalances(idEmpresa);
		}
		
		@RequestMapping(method = DELETE)
		public List<Balance> eliminarBalance(@RequestParam(value = "id", defaultValue = "", required = false) long id,
											 @RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{
			
			long userId = AuthUtils.validarToken(token);
			if (userId == -1L) {
				throw new Exception("Token inválido, vuelva a iniciar sesión.");
			}
			
			List<Balance> res = servicios.getBalanceServicio().eliminarBalance(id);
			
			if(res == null) throw new Exception("Balance no válido.");
			return res;
		}
		
		@ExceptionHandler(Exception.class)
		void handleBadRequests(HttpServletResponse response) throws IOException {
		    response.sendError(HttpStatus.BAD_REQUEST.value(), "Balance o token no válidos.");
		}
		
		@RequestMapping(method = POST)
		public List<Balance> agregarBalance(@RequestParam(value = "capitalPropio", defaultValue = "", required = false) int capitalPropio,
											@RequestParam(value = "deuda", defaultValue = "", required = false) int deuda,
											@RequestParam(value = "ebitda", defaultValue = "", required = false) int ebitda,
											@RequestParam(value = "fCashFlow", defaultValue = "", required = false) int fCashFlow,
											@RequestParam(value = "fds", defaultValue = "", required = false) int fds,
											@RequestParam(value = "ingNetoOpCont", defaultValue = "", required = false) int ingNetoOpCont,
											@RequestParam(value = "ingNetoOpDiscont", defaultValue = "", required = false) int ingNetoOpDiscont,
											@RequestParam(value = "periodo", defaultValue = "", required = false) int periodo,
											@RequestParam(value = "idEmpresa", defaultValue = "", required = false) long idEmpresa,
				 							@RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{

			long userId = AuthUtils.validarToken(token);
			if (userId == -1L) {
				throw new Exception("Token inválido, vuelva a iniciar sesión.");
			}
			
			return servicios.getBalanceServicio().agregarBalance(capitalPropio,deuda,ebitda,fCashFlow,fds,ingNetoOpCont,ingNetoOpDiscont,periodo,idEmpresa);
		}
		
		@RequestMapping(method = PUT)
		public List<Balance> modificarBalance(@RequestParam(value = "id", defaultValue = "", required = false) long id,
									  		  @RequestParam(value = "capitalPropio", defaultValue = "-1", required = false) int capitalPropio,
											  @RequestParam(value = "deuda", defaultValue = "-1", required = false) int deuda,
											  @RequestParam(value = "ebitda", defaultValue = "-1", required = false) int ebitda,
											  @RequestParam(value = "fCashFlow", defaultValue = "-1", required = false) int fCashFlow,
											  @RequestParam(value = "fds", defaultValue = "-1", required = false) int fds,
											  @RequestParam(value = "ingNetoOpCont", defaultValue = "-1", required = false) int ingNetoOpCont,
											  @RequestParam(value = "ingNetoOpDiscont", defaultValue = "-1", required = false) int ingNetoOpDiscont,
											  @RequestParam(value = "periodo", defaultValue = "-1", required = false) int periodo,
											  @RequestParam(value = "idEmpresa", defaultValue = "-1", required = false) long idEmpresa,
				 							  @RequestParam(value = "token", defaultValue = "", required = false) String token) throws Exception{

			long userId = AuthUtils.validarToken(token);
			if (userId == -1L) {
				throw new Exception("Token inválido, vuelva a iniciar sesión.");
			}
			
			return servicios.getBalanceServicio().modificarBalance(id,capitalPropio,deuda,ebitda,fCashFlow,fds,ingNetoOpCont,ingNetoOpDiscont,periodo,idEmpresa);
		}
		
}
