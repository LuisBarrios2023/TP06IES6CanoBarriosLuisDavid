package ar.edu.ies6.model;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Alumno {
	@Column
	//@NotBlank @Size(min = 1, max = 30)
	private String name;
	@Column
	private String lastName;
	@Column
	private String addressStreet;
	@Column
	private Integer addressNumber;	
	@Column
	private String addressCity;
	@Column
	private LocalDate fechaNac;
	@Id
	//@GenerateValue (strategy = GenerationType.AUTO)
	private String dni;
	@Column
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
