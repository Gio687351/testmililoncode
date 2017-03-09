package refactula.design.patterns.behavioral.memento;

public interface Originator<T> {

  Memento<T> createMemento();

  void setMemento(Memento<T> memento);

}
