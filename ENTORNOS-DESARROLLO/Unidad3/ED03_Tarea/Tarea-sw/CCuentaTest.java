import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CCuentaTest {
	CCuenta miCuenta = new CCuenta();

// 1. Análisis de Caja Blanca - Método Ingresar
	@ParameterizedTest
	@CsvSource({"-10,1","-3,2","10,0"})
	@DisplayName("Caja Blanca - Ingresar")
	void testIngreso(double cant,int resul) {
		assertEquals(resul,miCuenta.ingresar(cant));
	}

// 2. Análisis de Caja Negra - Método Retirar
	@ParameterizedTest
	@CsvSource({"-10,1","-3,2","10,0"})
	@DisplayName("Caja Negra - Retirar")
	void testRetirar(double cant) {
		miCuenta.retirar(cant);
	}
}