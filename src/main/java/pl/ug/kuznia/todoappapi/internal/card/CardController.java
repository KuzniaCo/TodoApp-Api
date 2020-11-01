package pl.ug.kuznia.todoappapi.internal.card;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> findAllCards() {
        return cardService.findAllCards();
    }

    @PostMapping("/add")
    public Card addNewCard(@RequestBody CardDTO cardDTO) {
        return cardService.addCard(cardDTO);
    }

}
