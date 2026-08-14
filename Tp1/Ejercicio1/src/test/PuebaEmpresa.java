package test;

import empresa.Departamento;
import empresa.Empleado;
import empresa.Empresa;

public class PuebaEmpresa {

	public static void main(String[] args) {
		Departamento gerencia = new Departamento(1, "Gerencia");
		Departamento produccion = new Departamento(2, "Produccion");
		Departamento ventas = new Departamento(3, "Ventas");

		//Gerencia
		Empleado gerente = new Empleado(1001,"jose", null, gerencia);
		Empleado secretaria = new Empleado(1002,"Laura", gerente, gerencia);
		
		//Produccion
		Empleado supervisorProduccion = new Empleado(2001,"leo",gerente ,produccion);	
		Empleado operadorProduccion = new Empleado(2001,"Luis",supervisorProduccion ,produccion);	

		//Ventas
		Empleado supervisorVentas = new Empleado(3001, "Renato", gerente, ventas);
		Empleado operadorVentas = new Empleado(3001, "wilder", supervisorVentas, ventas);
		
		Empresa empresa = new Empresa("Aluar", "avenida siempre grande 1080");
		
		//Cargo los departamentos
		empresa.cargarDepartamento(gerencia);
		empresa.cargarDepartamento(produccion);
		empresa.cargarDepartamento(ventas);
		
		//cargo los empleados
		empresa.cargarEmpleados(gerente);
		empresa.cargarEmpleados(secretaria);
		empresa.cargarEmpleados(supervisorProduccion);
		empresa.cargarEmpleados(operadorProduccion);
		empresa.cargarEmpleados(supervisorVentas);
		empresa.cargarEmpleados(operadorVentas);
		
		//Uso el metodo empleadosAcargo 
		System.out.println(empresa.empleadosAcargo(gerente));
		
		//Uso el metodo empleadoPorDepartamento
		System.out.println(empresa.empleadoPorDepartamento(gerencia));
		
		//Usu el metodo jerarquiaSupervisores
		System.out.print(empresa.jerarquiaSupervisores(secretaria));
		
	}
}	
