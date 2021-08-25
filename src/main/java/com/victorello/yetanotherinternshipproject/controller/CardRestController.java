package com.victorello.yetanotherinternshipproject.controller;

import com.victorello.yetanotherinternshipproject.dao.CardDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.dto.CardDTO;
import com.victorello.yetanotherinternshipproject.mapper.CardDTOMapper;
import com.victorello.yetanotherinternshipproject.service.CardService;
import com.victorello.yetanotherinternshipproject.service.CardServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CardRestController.REST_URL)
public class CardRestController extends AbstractRestController<Card, CardDAO, CardDTO, CardService, CardDTOMapper> {
    public static final String REST_URL = "/api/cards";
}
