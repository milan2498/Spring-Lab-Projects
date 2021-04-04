package com.trg.boot.trainee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainee")
public class Trainee {
	@Id
	@Column(name="tid")
	private int tid;
	private String tname;
	private String tdomain;
	private String tloc;
	public Trainee() {
		
	}
	public Trainee(int tid, String tname, String tdomain, String tloc) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tdomain = tdomain;
		this.tloc = tloc;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTdomain() {
		return tdomain;
	}
	public void setTdomain(String tdomain) {
		this.tdomain = tdomain;
	}
	public String getTloc() {
		return tloc;
	}
	public void setTloc(String tloc) {
		this.tloc = tloc;
	}
	@Override
	public String toString() {
		return "Trainee [tid=" + tid + ", tname=" + tname + ", tdomain=" + tdomain + ", tloc=" + tloc + "]";
	}
	
}
