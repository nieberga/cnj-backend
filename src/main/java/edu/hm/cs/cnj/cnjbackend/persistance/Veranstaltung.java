package edu.hm.cs.cnj.cnjbackend.persistance;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Veranstaltung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 140, unique = true)
	@Length(min = 8)
	@NotNull
	private String titel;
	@Column(length = 1000)
	@NotNull
	private String beschreibung;
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date beginn;

	public Veranstaltung(String titel, String beschreibung, Date beginn) {
		super();
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.beginn = beginn;
	}

	public Veranstaltung() {
		// JPA benoetigt Default-Konstruktor
	}

	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy = "veranstaltung", cascade = CascadeType.ALL)
	private Set<Teilnahme> einladungen = new HashSet<>();

	public void add(Teilnahme teilnahme) {
		einladungen.add(teilnahme);
		teilnahme.setVeranstaltung(this);
	}
}
