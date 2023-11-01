package ar.edu.ies6.model;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private String name;
	private String lastName;		
	private String addressStreet;
	private Integer addressNumber;		
	private String addressCity;
	private LocalDate fechaNac;
	private String dni;
	private Boolean estado;
	
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public Integer getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public Integer calcularEdad() {
		int edad = 0;
		
		LocalDate fechaAct = LocalDate.now();
		Period periodo = Period.between(fechaNac, fechaAct);
		edad =periodo.getYears();
		
		return edad;
	}
	
}
