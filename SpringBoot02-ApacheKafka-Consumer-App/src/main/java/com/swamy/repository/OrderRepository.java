package com.swamy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swamy.model.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {

}
