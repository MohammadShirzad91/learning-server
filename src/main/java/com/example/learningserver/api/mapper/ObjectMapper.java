package com.example.learningserver.api.mapper;

import com.example.learningserver.api.dto.CardEntityDto;
import com.example.learningserver.service.data.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectMapper {
    ObjectMapper MAPPER = Mappers.getMapper(ObjectMapper.class);
    CardEntityDto map(CardEntity cardEntity);
    CardEntity map(CardEntityDto cardEntity);
}
