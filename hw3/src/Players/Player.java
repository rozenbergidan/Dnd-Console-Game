package Players;

import Board.*;
import ObserverPattern.Observer;
import Tiles.*;

public abstract class Player extends Unit implements Observer{
    int level;
    int exp;
}
