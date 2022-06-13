

package com.swamy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "order_consumer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private double orderAmount;

	private String status;
}
