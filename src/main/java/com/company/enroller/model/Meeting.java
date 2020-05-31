package com.company.enroller.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "meeting")
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private String date;

	//@JsonIgnore
	@ManyToMany(mappedBy = "meetings", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	Set<Participant> participants = new HashSet<Participant>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}
	
	public void removeParticipant(Participant participant) {
		this.participants.remove(participant);
	}
	
	public Collection<Participant> getParticipants() {
		return participants;
	}

}