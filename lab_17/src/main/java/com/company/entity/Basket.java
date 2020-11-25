package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "busket")
@NamedQuery(name = "getAllRows", query = "select b from Basket b")
public class Basket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private String path;

	public Basket() {
	}

	public Basket(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
