package com.grupo4.webserver;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.grupo4.inversiones.tools.AplicarIndicadores;
<<<<<<< HEAD
=======
import com.grupo4.inversiones.tools.CargadorDeArchivos;
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba

@SpringBootApplication
@ServletComponentScan
public class WebserverApplication {

	public static void main(String[] args) throws IOException{
<<<<<<< HEAD
		AplicarIndicadores.precalculo();
=======
		//AplicarIndicadores.precalculo();
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
		SpringApplication.run(WebserverApplication.class, args);
	}
}
