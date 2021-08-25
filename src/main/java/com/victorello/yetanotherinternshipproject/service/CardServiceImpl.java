package com.victorello.yetanotherinternshipproject.service;

import com.victorello.yetanotherinternshipproject.dao.CardDAO;
import com.victorello.yetanotherinternshipproject.domain.Card;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends AbstractServiceImpl<Card, CardDAO> implements CardService {
}
