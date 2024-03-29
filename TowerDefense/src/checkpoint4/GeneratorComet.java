package checkpoint4;

import java.awt.*;

public class GeneratorComet extends GameObject
{
    private Control control;
    private GameState state;
    private double countdownToNextAsteroid;  // in seconds
    private int asteroidsCreated;  // count
    private double countdownMultiplier;

    public GeneratorComet(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        countdownToNextAsteroid = 2.0;
        asteroidsCreated = 0;
        countdownMultiplier = 2.0;
    }

    @Override
    public void update(double timeElapsed)
    {
        countdownToNextAsteroid -= timeElapsed;

        if (countdownToNextAsteroid <= 0)
        {
            countdownToNextAsteroid = ((asteroidsCreated % 2 != 0) ? 2 : 4) * countdownMultiplier;
            state.addGameObject(new Comet(control, state));
            asteroidsCreated++;
            countdownMultiplier *= 0.99;
        }
    }

    @Override
    public void draw(Graphics g)
    {
    }
}
