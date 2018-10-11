package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Items{
	
	@Id
	private Long id;
	
	@Column(name = "item_name")
	private String name;
	
	@Column(name = "item_count")
	private int count;
	
	private int port;
	
	public Items() {
		
	}
	
	public Items(Long id, String name, int count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
}