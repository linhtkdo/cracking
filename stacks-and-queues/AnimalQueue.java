abstract class Animal {
  private int order;
  protected String name;
  
  public Animal(String n) { name = n; }
  
  public void setOrder(int o) { order = o; }
  public int getOrder() { return order; }
  
  public boolean isOlderThan(Animal a) {
    return this.order < a.getOrder();
  }
}

class Dog extends Animal {
  public Dog(String n) { super(n); }
}

class Cat extends Animal {
  public Cat(String n) { super(n); }
}

class AnimalQueue {
  LinkedList<Dog> dogs = new LinkedList<Dog>();
  LinkedList<Cat> cats = new LinkedList<Cat>();
  private int order = 0; // acts as timestamp
  
  public void enqueue(Animal a) {
    a.setOrder(order);
    order++;
    
    if (a instanceof Dog) dogs.addLast((Dog) a);
    else if (a instanceof Cat) cats.addLast((Cat) a);
  }
  
  public Animal dequeueAny() {
    if (dogs.size() == 0) return dequeueCats();
    if (cats.size() == 0) return dequeueDogs();
    Dog d = dogs.peek()
  }
}
