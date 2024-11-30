//D - Dependency Inversion Principle (DIP)

// PARA CRIAR SW FLEXÍVEL, DEVEMOS DEPENDER DE ABSTRAÇÕES, NÃO DE IMPLEMENTAÇÕES CONCRETAS.

//High-level modules should not depend on low-level modules. 
//Both should depend on abstractions (e.g., interfaces).

//EX: NÃO ACESSAR O BD DIRETA// POIS, CASO TROCADO (POSTGREES x ORACLE), QUEBRA CÓDIGO
// USAR ABSTRAÇÕES Ex: INTERFACES.


//Let's create an example with an Engine interface,
//different types of engines,
//and a Car class that implements the Engine interface and a method accelerate.
            +-------------+
            |   Engine    |  <----- Interface (Abstraction)
            +-------------+
                   ^
                   |
   +---------------+-----------------+
   |               |                 |
+-------------+ +-------------+ +-------------+
|PetrolEngine | |DieselEngine | |ElectricEngine|
|   (implements)  | (implements)  | (implements)  |
+-------------+ +-------------+ +-------------+
                   ^
                   |
             +-------------+
             |    Car      |  <----- High-level class (depends on Engine interface)
             +-------------+

                
interface Engine { //Define the Engine Interface
    void start();
}
//Create Different Engine Types
class PetrolEngine implements Engine {                 //Petrol
    @Override
    public void start() {
        System.out.println("Petrol engine started.");
    }
}

class DieselEngine implements Engine {                 //Diesel
    @Override
    public void start() {
        System.out.println("Diesel engine started.");
    }
}

class ElectricEngine implements Engine {                //Eletric
    @Override
    public void start() {
        System.out.println("Electric engine started.");
    }
}
//Create the Car class that Depends on Engine Interface
class Car {
    private Engine engine;

    // Constructor injection
    public Car(Engine engine) { // 1) could B any type of car; 2)  
        this.engine = engine;
    }

    public void accelerate() {
        engine.start();
        System.out.println("Car is accelerating.");
    }
}
// CALLING METHODS - making the code more flexible and easier to maintain
public class Main {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();
        Engine dieselEngine = new DieselEngine();
        Engine electricEngine = new ElectricEngine();

        Car petrolCar = new Car(petrolEngine);
        Car dieselCar = new Car(dieselEngine);
        Car electricCar = new Car(electricEngine);

        petrolCar.accelerate();  // Output: Petrol engine started. Car is accelerating.
        dieselCar.accelerate();  // Output: Diesel engine started. Car is accelerating.
        electricCar.accelerate();  // Output: Electric engine started. Car is accelerating.
    }
}

// VIOLATION E.G.

    +--------------+    +--------------+    +---------------+
    |PetrolEngine  |    |DieselEngine  |    |ElectricEngine |
    +--------------+    +--------------+    +---------------+
           ^                   ^                     ^
           |                   |                     |
           +-------------------+---------------------+
                               |
                         +-------------+
                         |     Car     |  <---- High-level class (directly depends on concrete engine implementations)
                         +-------------+
// PetrolEngine class
class PetrolEngine {
    public void start() {
        System.out.println("Petrol engine started.");
    }
}

// DieselEngine class
class DieselEngine {
    public void start() {
        System.out.println("Diesel engine started.");
    }
}

// ElectricEngine class
class ElectricEngine {
    public void start() {
        System.out.println("Electric engine started.");
    }
}

// Car class directly depending on concrete engine types
class Car {
    private PetrolEngine petrolEngine;
    private DieselEngine dieselEngine;
    private ElectricEngine electricEngine;

    public Car(PetrolEngine petrolEngine, DieselEngine dieselEngine, ElectricEngine electricEngine) {
        this.petrolEngine = petrolEngine;
        this.dieselEngine = dieselEngine;
        this.electricEngine = electricEngine;
    }

    public void accelerateWithPetrolEngine() {
        petrolEngine.start();
        System.out.println("Car is accelerating with petrol engine.");
    }

    public void accelerateWithDieselEngine() {
        dieselEngine.start();
        System.out.println("Car is accelerating with diesel engine.");
    }

    public void accelerateWithElectricEngine() {
        electricEngine.start();
        System.out.println("Car is accelerating with electric engine.");
    }
}
public class Main {
    public static void main(String[] args) {
        PetrolEngine petrolEngine = new PetrolEngine();
        DieselEngine dieselEngine = new DieselEngine();
        ElectricEngine electricEngine = new ElectricEngine();

        Car car = new Car(petrolEngine, dieselEngine, electricEngine);

        car.accelerateWithPetrolEngine();  // Output: Petrol engine started. Car is accelerating with petrol engine.
        car.accelerateWithDieselEngine();  // Output: Diesel engine started. Car is accelerating with diesel engine.
        car.accelerateWithElectricEngine();  // Output: Electric engine started. Car is accelerating with electric engine.
    }
}
