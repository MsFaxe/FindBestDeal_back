package com.kodilla.games.mapper;

import com.kodilla.games.gog.domain.GogApp;
import com.kodilla.games.gog.domain.GogPrice;
import com.kodilla.games.gog.domain.GogProduct;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogAppDto;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogPriceDto;
import com.kodilla.games.gog.domain.dto.single_gogGame.GogProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GogMapper {
    public GogPrice mapToPrice(GogPriceDto gogPriceDto) {
        return new GogPrice(gogPriceDto.getFinalAmount());
    }

    public GogProduct mapToGogProduct(GogProductDto gogProductDto) {
        return new GogProduct(
                gogProductDto.getId(),
                gogProductDto.getTitle(),
                mapToPrice(gogProductDto.getPrice()).toString()
        );
    }

    public List<GogProduct> mapToProductList(List<GogProductDto> gogProductDtos) {
        return gogProductDtos.stream()
                .map(this::mapToGogProduct)
                .collect(Collectors.toList());
    }

    public GogApp mapToGogApp(GogAppDto gogAppDto) {
        return new GogApp(
                mapToProductList(gogAppDto.getProducts())
        );
    }
}
