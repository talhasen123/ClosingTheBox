package Input;

import Objects.Box;
import Objects.BoxHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input extends MouseAdapter {
    BoxHandler handler;

    public Input(BoxHandler handler)
    {
        this.handler = handler;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        for ( Box box : handler.getBoxes() )
        {
            if ( box.contains( x, y) )
            {
                box.setSelected( true);
            }
            else
            {
                box.setSelected( false);
            }
        }
    }
}
