package pl.ug.kuznia.todoappapi.internal.card;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card addCard(CardDTO cardDTO) {
        //ToDo validate cardDTO
        Card cardToAdd = cardDTO.createCard();
        return cardRepository.save(cardToAdd);
    }

    public List<Card> findAllCards() {
        return cardRepository.findAll();
    }
}
