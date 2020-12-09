package cz.cvut.fit.miadp.mvcgame.model.object.basic;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Position;
import cz.cvut.fit.miadp.mvcgame.model.coordinations.Vector;
import cz.cvut.fit.miadp.mvcgame.model.object.base.AbstractMissile;

public class BasicMissile extends AbstractMissile {

    public BasicMissile(Position initialPosition) {
        super(initialPosition);
    }

    @Override
    public void move(Long time) {
        //todo create gravity
        move(new Vector(MvcGameConfig.MISSILE_MOVE_STEP, 0));
    }
}
