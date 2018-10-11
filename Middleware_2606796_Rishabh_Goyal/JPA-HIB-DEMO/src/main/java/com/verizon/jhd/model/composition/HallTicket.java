package com.verizon.jhd.model.composition;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="halltickets")
public class HallTicket {

	@Id
	private String hallticketnumber;
	private String candidate;
	private String examtitle;
	@Embedded
	private Identification identity;
	public HallTicket() {
		super();
	}
	public HallTicket(String hallticketnumber, String candidate, String examtitle, Identification identity) {
		super();
		this.hallticketnumber = hallticketnumber;
		this.candidate = candidate;
		this.examtitle = examtitle;
		this.identity = identity;
	}
	public String getHallticketnumber() {
		return hallticketnumber;
	}
	public void setHallticketnumber(String hallticketnumber) {
		this.hallticketnumber = hallticketnumber;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public String getExamtitle() {
		return examtitle;
	}
	public void setExamtitle(String examtitle) {
		this.examtitle = examtitle;
	}
	public Identification getIdentity() {
		return identity;
	}
	public void setIdentity(Identification identity) {
		this.identity = identity;
	}
	
	
}
