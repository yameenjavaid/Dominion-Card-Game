package Game.Card.Effect.Type.Instant;

import Game.Card.Effect.Effect;
import Game.Card.Effect.Type.InstantEffect;
import Game.Game;

public class GainActionEffect extends InstantEffect {

    public GainActionEffect(Effect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game) {
        return false;
    }

}