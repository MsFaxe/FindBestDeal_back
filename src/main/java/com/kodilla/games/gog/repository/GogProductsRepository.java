package com.kodilla.games.gog.repository;

import com.kodilla.games.gog.domain.GogProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GogProductsRepository extends CrudRepository<GogProduct, Long> {
    @Override
    List<GogProduct> findAll();

    @Override
    GogProduct save(GogProduct gogProduct);
}
