package Framework;

import javax.swing.*;
import java.awt.*;

public class Window {
    // Properties
    Application application;

    // Constructor
    public Window( int width, int height, String title, Application application)
    {
        application = new Application();
        application.setPreferredSize( new Dimension( width, height) );
        application.setMinimumSize( new Dimension( width, height) );
        application.setMaximumSize( new Dimension( width, height) );

        JFrame frame = new JFrame( title);
        frame.add( application);
        frame.pack();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setResizable( false);
        frame.setLocationRelativeTo( null);
        frame.setVisible( true);

        application.start();
    }

    // Methods
    public static void main(String[] args) {
        Window window = new Window( 500, 500, "App", new Application());
    }
}
