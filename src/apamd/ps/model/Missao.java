package apamd.ps.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Missao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private LocalDate dataTerra;
	
	private Integer numeroDiasMarte;
	
	private BigDecimal longitudeSolar;
	
	private Integer mesMarte;
	
	private Double temperaturaMinima;
	
	private Double temperaturaMaxima;
	
	private Double pressaoAtmosferica;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataTerra() {
		return dataTerra;
	}

	public void setDataTerra(LocalDate dataTerra) {
		this.dataTerra = dataTerra;
	}

	public Integer getNumeroDiasMarte() {
		return numeroDiasMarte;
	}

	public void setNumeroDiasMarte(Integer numeroDiasMarte) {
		this.numeroDiasMarte = numeroDiasMarte;
	}

	public BigDecimal getLongitudeSolar() {
		return longitudeSolar;
	}

	public void setLongitudeSolar(BigDecimal longitudeSolar) {
		this.longitudeSolar = longitudeSolar;
	}

	public Integer getMesMarte() {
		return mesMarte;
	}

	public void setMesMarte(Integer mesMarte) {
		this.mesMarte = mesMarte;
	}

	public Double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(Double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public Double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(Double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Double getPressaoAtmosferica() {
		return pressaoAtmosferica;
	}

	public void setPressaoAtmosferica(Double pressaoAtmosferica) {
		this.pressaoAtmosferica = pressaoAtmosferica;
	}

	@Override
	public String toString() {
		return "Missao [id=" + id + ", dataTerra=" + dataTerra + ", numeroDiasMarte=" + numeroDiasMarte
				+ ", longitudeSolar=" + longitudeSolar + ", mesMarte=" + mesMarte + ", temperaturaMinima="
				+ temperaturaMinima + ", temperaturaMaxima=" + temperaturaMaxima + ", pressaoAtmosferica="
				+ pressaoAtmosferica + "]";
	}
	
}
