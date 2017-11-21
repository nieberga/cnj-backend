package edu.hm.cs.cnj.cnjbackend.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

@Entity
public class Teilnahme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(length = 255)
	@NotNull
	private String name;
	@Min(0)
	@Max(20)
	private int begleiter;
	@Enumerated(EnumType.STRING)
	private TeilnahmeStatus status = TeilnahmeStatus.OFFEN;

	public Teilnahme() {
		// Default-Konstruktor fuer JPA
	}

	public Teilnahme(String name, int begleiter) {
		this.name = name;
		this.begleiter = begleiter;
	}

	public Long getId() {
		return id;
	}
	
	@ManyToOne
	@NotNull
	private Veranstaltung veranstaltung;
	void setVeranstaltung(Veranstaltung veranstaltung) {
	this.veranstaltung = veranstaltung;
	}

}
