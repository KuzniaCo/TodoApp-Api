package pl.ug.kuznia.todoappapi.internal.card;

import org.springframework.stereotype.Service;
import pl.ug.kuznia.todoappapi.exceptions.APIRequestException;

import javax.validation.constraints.NotNull;
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

    public void deleteCard(Long id) {
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
        } else {
            throw new APIRequestException("Couldn't find card id to delete");
        }
    }
    public Card updateCard(CardDTO cardDTO) {
        if (cardRepository.existsById(cardDTO.getId())) {
            Card cardToUpdate = cardDTO.updateCard();
            return cardRepository.save(cardToUpdate);
        } else {
            throw new APIRequestException("Couldn't find card id to update");
        }

    }

    public List<Card> findAllCards() {
        return cardRepository.findAll();
    }
}
