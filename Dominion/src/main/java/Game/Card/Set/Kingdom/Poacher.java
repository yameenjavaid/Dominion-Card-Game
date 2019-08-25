package Game.Card.Set.Kingdom;

import Game.Card.Card;

import static Constant.CardSettings.DominionCards.KINGDOM_CARD_COSTS;

public class Poacher extends Card {

    public Poacher() {
        super("Poacher", KINGDOM_CARD_COSTS.get("Poacher"));
    }

    @Override
    public void activate() {

    }

    @Override
    public Card makeCopy() {
        return null;
    }
}