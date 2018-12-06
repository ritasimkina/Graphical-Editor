package Observer;

import Debug.Debug;
import Screen.DrawArray.Draw;

public class ToolbarObserver implements Observer {
    Draw draw=null;

    public ToolbarObserver(Draw draw)    {
        this.draw=draw;
    }

    public Draw getSubject() {
        return draw;
    }


    public void update()    {
        Debug.out(Thread.currentThread());
    }
}
