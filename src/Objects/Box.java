package Objects;

import java.awt.*;
import java.util.Random;

public class Box extends Rectangle {
    // Properties
    Color color;
    Random random;
    boolean selected;

    // Constructor
    public Box( int width, int height, int x, int y)
    {
        super( x, y, width, height);
        random = new Random();
        int result = random.nextInt( 7);
        switch ( result)
        {
            case 1: color = Color.BLUE;
                break;
            case 2: color = Color.YELLOW;
                break;
            case 3: color = Color.GREEN;
                break;
            case 4: color = Color.RED;
                break;
            case 5: color = Color.BLACK;
                break;
            case 6: color = Color.PINK;
                break;
            case 7: color = Color.CYAN;
                break;
        }
        selected = false;
    }

    // Methods
    public void draw( Graphics g)
    {
        if ( selected )
        {
            g.setColor( color);
            g.fillRect( x, y, width, height);
        }
        else {
            g.setColor( Color.black);
            g.drawRect(x, y, width, height);
        }
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
