package Framework;

import Input.Input;
import Objects.BoxHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Application extends Canvas implements Runnable{
    // Properties
    public static int width;
    public static int height;
    private Thread thread;
    private boolean running;
    private BoxHandler boxHandler;

    // Methods
    private void init()
    {
        width = getWidth();
        height = getHeight();
        boxHandler = new BoxHandler();
        boxHandler.fillApplication( this);
        addMouseListener( new Input(boxHandler));
        addMouseMotionListener( new Input(boxHandler));
    }
    public synchronized void start()
    {
        if ( running)
        {
            return;
        }

        running = true;
        thread = new Thread( this);
        thread.start();
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while( running )
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while( delta >= 1 )
            {
                updates++;
                delta--;
            }
            render();
            frames++;

            if( System.currentTimeMillis() - timer > 1000 )
            {
                timer += 1000;
                System.out.println( "FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void render()
    {
        BufferStrategy bufferStrategy;
        bufferStrategy = this.getBufferStrategy();

        if ( bufferStrategy == null )
        {
            this.createBufferStrategy( 3);
            return;
        }

        Graphics g;
        g = bufferStrategy.getDrawGraphics();
        // DRAWING HERE
        //***********************************
        paint( g);
        boxHandler.render( g);
        //***********************************
        g.dispose();
        bufferStrategy.show();
    }
}
