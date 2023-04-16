package com.efc.domain;

import java.io.Serializable;

import jakarta.persistence.Id;

public class AbstractEntity<ID extends Serializable> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private ID id;
	
}
