package Observer;

import Debug.Debug;
import Screen.DrawArray.Draw;

public class ToolbarObserver implements Observer {
    Draw draw=null;

    public void update()    {
        Debug.out(Thread.currentThread());
        Debug.signal(Thread.currentThread());

    }
}
