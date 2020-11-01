package pl.ug.kuznia.todoappapi.internal.card;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class CardDTO {

    @NotNull
    String title;
    @NotNull
    String description;

    public Card createCard() {
        return Card.builder()
                .title(title)
                .description(description)
                .build();
    }
}
