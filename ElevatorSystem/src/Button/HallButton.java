package Button;
import Enums.Direction;

public class HallButton extends Button{
    private Direction buttonSign;
    private int sourceFloorNumber;
    @Override
    public boolean isPressed() {
        return false;
    }


}
