package pl.ug.kuznia.todoappapi.internal.card;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> findAllCards() {
        return cardService.findAllCards();
    }

    @PostMapping
    public Card addNewCard(@RequestBody CardDTO cardDTO) {
        return cardService.addCard(cardDTO);
    }

    @DeleteMapping
    public void deleteCard(@RequestParam(value = "id") Long id) {
        cardService.deleteCard(id);
    }

    @PutMapping
    public Card updateCard(@RequestBody CardDTO cardDTO) {
        return cardService.updateCard(cardDTO);

    }
}
