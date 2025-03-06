package com.example.learningserver.api;

import com.example.learningserver.api.dto.CardEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "card-service", url = "http://localhost:8080/server/rest", primary = false)
public interface FeignApi {
    @PostMapping(value = "/insert-card")
    void insertCard(@RequestBody CardEntityDto card);
    @PostMapping(value = "/get-card-by-pan")
    CardEntityDto getCardByPan(@RequestParam String pan);
}
