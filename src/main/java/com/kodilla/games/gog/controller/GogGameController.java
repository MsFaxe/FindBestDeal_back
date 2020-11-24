package com.findbestdeal.backend.gog.controller;

import com.findbestdeal.backend.gog.domain.GogGame;
import com.findbestdeal.backend.gog.service.GogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gog")
public class GogGameController {

    private GogService gogService;

    public GogGameController(GogService gogService) {
        this.gogService = gogService;
    }

    @GetMapping("/list")
    public Iterable<GogGame> list() {
        return gogService.list();
    }
}
