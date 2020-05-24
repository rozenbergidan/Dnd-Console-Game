package ObserverPattern;

import ObserverPattern.Observer;

public interface Observable {

    void addObserver (Observer O);
    void callObservers();
}
