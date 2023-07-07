package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address extends Basenetity{
	@Column(length = 20)
	private String City;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String pincode;
	@OneToOne
	@MapsId
	private Student sid;	
}
