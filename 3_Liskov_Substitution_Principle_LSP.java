//Liskov Substitution Principle (LSP)
//Objects of a superclass should be replaceable with objects of a subclass without affecting the functionality of the program.

//Violating LSP
//a Bird superclass and two subclasses: 
//FlyingBird and NonFlyingBird. 
//However, this design violates LSP because not all birds can fly.
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() { // necessário tratamento de erros.
        throw new UnsupportedOperationException("Ostrich can't fly");
    } //CLASSES DERIVADAS DEVEM SER COMPLETAMENTE SUBSTITUÍVEIS PELAS SUAS CLASSES BASE.
}

//(Adhering to LSP)
//a more appropriate hierarchy. 
//using a FlyingBird superclass and a NonFlyingBird superclass 
//to properly distinguish between birds that can fly and those that cannot.
abstract class Bird {
    public abstract void eat(); //all birds eat
}

abstract class FlyingBird extends Bird { // some fly
    public abstract void fly();
}

abstract class NonFlyingBird extends Bird { //some don't
}

class Sparrow extends FlyingBird {// Pardal
    @Override
    public void eat() { // Pardal eats
        System.out.println("Sparrow is eating");
    }

    @Override
    public void fly() { // Pardal flies
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends NonFlyingBird { // Avestruz
    @Override
    public void eat() { // Avestruz only eats
        System.out.println("Ostrich is eating");
    } //CLASSES DERIVADAS DEVEM SER COMPLETAMENTE SUBSTITUÍVEIS PELAS SUAS CLASSES BASE.
} //uma classe base para cada subtipo (classe derivada) in casu "NonFlyingBird".

