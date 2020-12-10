package cz.cvut.fit.miadp.mvcgame.abstract_factory;

import cz.cvut.fit.miadp.mvcgame.model.object.cannon.AbstractCannon;

public interface AbstractGameObjectFactory {
    AbstractCannon createCannon();
}
