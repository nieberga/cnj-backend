package edu.hm.cs.cnj.cnjbackend.service;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hm.cs.cnj.cnjbackend.persistence.Veranstaltung;
import edu.hm.cs.cnj.cnjbackend.persistence.VeranstaltungRepository;

@Service
@Transactional
public class VeranstaltungService {

	@Autowired
	private VeranstaltungRepository repository;
	
	@Autowired
	private VeranstaltungMapper mapper;

	public VeranstaltungDto erzeugeVeranstaltung(VeranstaltungDto veranstaltungDto) {
		Veranstaltung veranstaltung = mapper.createEntity(veranstaltungDto);
		
		// Vor dem Speichern sollte die fachliche Prüfung stattfinden!		
		repository.save(veranstaltung);
				
		return mapper.createDto(veranstaltung);
	}

	public VeranstaltungDto findeVeranstaltung(long id) {
		return mapper.createDto(repository.findOne(id));
	}

	public VeranstaltungDto aktualisiere(VeranstaltungDto veranstaltungDto) {
		Veranstaltung veranstaltung = repository.findOne(veranstaltungDto.getId());
		mapper.map(veranstaltungDto, veranstaltung);
		return mapper.createDto(veranstaltung);
	}

	public void loescheVeranstaltung(Long id) {
		repository.delete(id);
	}

	public Collection<VeranstaltungDto> findeVeranstaltungen(boolean vergangeneEventsAnzeigen) {
		if (vergangeneEventsAnzeigen) {
			return mapper.createDtoList(repository.findAll());
		} else {
			return mapper.createDtoList(repository.findByBeginnAfter(new Date()));
		}
	}
}