public interface Observable {

    void addObserver (Observer O);
    void callObservers();
}
