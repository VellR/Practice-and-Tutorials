import java.util.ArrayList;
import java.util.List;

public class Subject{
  //Knows its observers. Any number of Observer objects may observe a subject.
  //Provides an interface for attaching and detaching Observer objects.
  private List<Observer> observers = new ArrayList<Observer>();
  private boolean state;

  public boolean getState(){
    return state;
  }

  public void setState(boolean state){
    this.state = state;
    notifyObservers();
  }

  public void attach(Observer observer){
    observers.add(observer);
  }

  public void detach(Observer observer){
    observers.remove(observer);
  }

  public void notifyObservers(){
    for(Observer o: observers){
      o.update();
    }
  }
}
