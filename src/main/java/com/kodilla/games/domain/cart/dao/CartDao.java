package com.kodilla.games.domain.cart.dao;

import com.kodilla.games.domain.cart.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CartDao extends CrudRepository<Cart, Long> {
}
