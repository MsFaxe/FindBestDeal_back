package com.kodilla.games.domain.order.dao;

import com.kodilla.games.domain.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderDao extends CrudRepository<Order, Long> {
    @Override
    List<Order> findAll();
}
