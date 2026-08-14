package empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {
	private String nombre;
	private String direccion;
	private List<Empleado> empleados;
	private List<Departamento> departamentos;
	
	public Empresa(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.empleados = new ArrayList<Empleado>();
		this.departamentos = new ArrayList<Departamento>();
	}

	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<Empleado> getEmpleado() {
		return empleados;
	}


	public void setEmpleado(List<Empleado> empleado) {
		this.empleados = empleado;
	}


	public List<Departamento> getDepartamento() {
		return departamentos;
	}


	public void setDepartamento(List<Departamento> departamento) {
		this.departamentos = departamento;
	}


	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", direccion=" + direccion + ", empleados=" + empleados
				+ ", departamentos=" + departamentos + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(departamentos, direccion, empleados, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(departamentos, other.departamentos) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(empleados, other.empleados) && Objects.equals(nombre, other.nombre);
	}


	//Todos los empleados que pertenecen a un departamento dado
	public List<Empleado> empleadoPorDepartamento(Departamento departamento){
		//Esta lista tendra a todos los empleados que pertenescan a un departamento 
		List<Empleado> resultado = new ArrayList<Empleado>();
		//Recorro toda la lista de Empleado
		for(Empleado e: empleados) {
			if(e.getDepartamento().equals(departamento)){	//Veo si el empleado pertenece a ese departamento)
				resultado.add(e);	//Lo agrago ala lista con el resultado
			}
		}
		//Retorno la lista con el resultado
		return resultado;
	}
	
	
	//Dado un empleado, toda la jerarquía de supervisores
	public List<Empleado> jerarquiaSupervisores(Empleado empleado){
		//Esta lista tendra todos los supervisores de un empleado 
		List<Empleado> resultado = new ArrayList<Empleado>();
		//
		Empleado actual = empleado.getSupervisor();
		//Recorro todos los supervisores del empleado hasta que no tenga
		while(actual != null) {
			resultado.add(actual);
			//Avanzo al siguiente supervisor
			actual = actual.getSupervisor();
		}
		//Retorno la lista con el resultado
		return resultado;
	}
	
	//Dado un empleado, los empleados que tiene a su cargo en forma directa
	public List<Empleado> empleadosAcargo(Empleado empleado){
		//Esta lista tendra los empleados a cargo 
		List<Empleado> resultado = new ArrayList<Empleado>();
		//Recorro todos los empleados
		for(Empleado e: empleados) {
			//agrego a la lista solo los que estan a cargo de aquel empleado
			if(e.getSupervisor() != null && e.getSupervisor().equals(empleado)) {
				resultado.add(e);
			}
		}
		//Retorno la lista con el resultado
		return resultado;
	}
	
	//metodo que agrega el elemento ala lista
	public void cargarEmpleados(Empleado e) {
		empleados.add(e);
	}
	
	//metodo quie agraga el elemento ala lista
	public void cargarDepartamento(Departamento d) {
		departamentos.add(d);
	}
		
}
