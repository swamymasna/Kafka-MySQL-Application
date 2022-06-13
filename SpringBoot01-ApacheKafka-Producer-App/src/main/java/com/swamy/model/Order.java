

package com.swamy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Entity
@Table(name = "order_producer")
public class Order{
	
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  private double orderAmount;
  
  private String status;

}
