public abstract class Unit  extends Tile implements Observer, Visitor{

    // FILDES
    String name;
    Health health;
    int attackPoint;
    int deffencePoint;


    abstract void onTickAct(Board board);
}
