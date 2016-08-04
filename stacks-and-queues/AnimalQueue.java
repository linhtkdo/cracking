/*
1. Use get/set for other classes to indirectly access this class fields.
2. Input/output exactly what the question asks; create relevant classes (Dog or Cat).
3. Dog and Cat should inherit from Animal since dequeueAny() needs to support both. 
4. poll(): returns null (instead of remove(): throws exception) if list is empty.
5. Compiler will generate empty no arg constructor if there's none. 
6. protected = seen by subclass but not others
*/

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
    if (a instanceof Cat) cats.addLast((Cat) a);
  }
  
  public Animal dequeueAny() {
    if (dogs.size() == 0) return dequeueCats();
    if (cats.size() == 0) return dequeueDogs();
    
    Dog d = dogs.peek();
    Cat c = cats.peek();
    
    if (d.isOlderThan(c)) return dequeueDogs();
    return dequeueCats();
  }
  
  public Dog dequeueDogs() {
    return dogs.poll();
  }
  
  public Cat dequeueCats() {
    return cats.poll();
  }
}
