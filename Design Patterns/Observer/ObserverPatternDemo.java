public class ObserverPatternDemo{
  public static void main(String[] args){
    Subject subject = new Subject();

    new ConcreteObserver(subject);

    System.out.println("Setting state");
    subject.setState(true);
    System.out.println("Subject state is: " + subject.getState());
    System.out.println("Setting state");
    subject.setState(false);
    System.out.println("Subject state is: " + subject.getState());
  }
}
