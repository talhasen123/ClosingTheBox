package Objects;

import Framework.Application;

import java.awt.*;
import java.util.ArrayList;

public class BoxHandler {
    // Properties
    private ArrayList<Box> boxes;

    // Constructor
    public BoxHandler()
    {
        boxes = new ArrayList<>();
    }

    // Methods
    public void render( Graphics g)
    {
        for ( Box b : boxes)
        {
            b.draw( g);
        }
    }

    public void fillApplication( Application app)
    {
        for ( int y = 0; y < app.height; y += app.height / 10)
        {
            for ( int x = 0; x < app.width; x += app.width / 10)
            {
                boxes.add( new Box( 50, 50, x, y) );
            }
        }
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }
}
