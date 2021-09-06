package com.victorello.yetanotherinternshipproject.mapper;

import com.victorello.yetanotherinternshipproject.domain.Card;
import com.victorello.yetanotherinternshipproject.domain.Task;
import com.victorello.yetanotherinternshipproject.dto.CardDTO;
import com.victorello.yetanotherinternshipproject.mapper.exceptions.InvalidReferenceIdException;
import com.victorello.yetanotherinternshipproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardDTOMapperImpl extends AbstractDTOMapperImpl<Card, CardDTO> implements CardDTOMapper {

    @Autowired
    private TaskService taskService;

    @Override
    public Card fromDTO(CardDTO dto) {
        Optional<Task> optionalTask = taskService.findById(dto.getTaskId());
        if (optionalTask.isEmpty()) throw new InvalidReferenceIdException();
        Task task = optionalTask.get();

        Card card = new Card();
        card.setId(dto.getId());
        card.setName(dto.getName());
        card.setTask(task);

        return null;
    }

    @Override
    public CardDTO toDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setName(card.getName());
        cardDTO.setTaskId(card.getTask().getId());

        return cardDTO;
    }
}
