import Panel.HallPanel;

import java.util.List;

abstract public class Floor {

    private List<Display> display;
    private List<HallPanel> panel;

    abstract public boolean isBottomMost();
    abstract public boolean isTopMost();


}
