package com.example.learningserver.api.controller;

import com.example.learningserver.api.FeignApi;
import com.example.learningserver.api.dto.CardEntityDto;
import com.example.learningserver.api.mapper.ObjectMapper;
import com.example.learningserver.service.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/server/rest")
public class Controller implements FeignApi {
    @Autowired
    private CardService cardService;
    private static final ObjectMapper MAPPER = ObjectMapper.MAPPER;

    @PostMapping(value = "/insert-card")
    public void insertCard(@RequestBody CardEntityDto card){
        cardService.insertCard(MAPPER.map(card));
    }

    @GetMapping(value = "/get-card-by-pan")
    public CardEntityDto getCardByPan(@RequestParam("pan") String pan){
        return MAPPER.map(cardService.getCardByPan(pan));
    }

    @PostMapping(value = "/write-card-on-file")
    public void writeCardOnFile(@RequestParam String pan){
        cardService.writeCardOnFile(pan);
    }
}
