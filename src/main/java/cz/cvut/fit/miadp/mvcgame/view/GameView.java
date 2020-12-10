package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.GameModelInterface;
import cz.cvut.fit.miadp.mvcgame.observer.GUIObserver;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectRenderer;
import javafx.scene.canvas.GraphicsContext;

public class GameView implements GUIObserver {

    private GameController controller;
    private GameModelInterface model;

    private GraphicsContext gr;
    private GameObjectRenderer renderer;

    public GameView(GameModelInterface model) {
        this.model = model;
        controller = new GameController(model);
        gr = null;
        this.model.registerObserver(this);
        renderer = new GameObjectRenderer();
    }

    public GameController getController() {
        return controller;
    }

    @Override
    public void updateGUI() {
        render();
    }

    public void setGraphicsContext(GraphicsContext gr) {
        if(this.gr == null) {
            this.gr = gr;
            renderer.setGraphicsContext(gr);
            render();
        }
    }

    private void render() {
        if(gr == null) return;
        gr.clearRect(0, 0, MvcGame.getWindowWidth(), MvcGame.getWindowHeight());
        model.getGameObjects().forEach(gameObject -> gameObject.acceptVisitor(renderer));
    }

}
