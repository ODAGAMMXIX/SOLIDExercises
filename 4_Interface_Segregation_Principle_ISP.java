// I - Interface Segregation Principle (ISP)
//Clients should not be forced to depend on interfaces they do not use.
// Clients = API, person, Stakeholder, customers.


//Violating ISP
//Here, both Worker and Robot implement a single interface that includes methods they don't all need:
interface Worker {
    void work();
    void eat();
}

class HumanWorker implements Worker {
    @Override
    public void work() { // HUMANO TRABALHA
        System.out.println("Human working");
    }

    @Override
    public void eat() { // HUMANO ALIMENTA-SE
        System.out.println("Human eating");
    }
}

class Robot implements Worker {
    @Override
    public void work() { // ROBÔ TRABALHA
        System.out.println("Robot working");
    }

    @Override
    public void eat() { // ROBÔ NÃO SE ALIMENTA; LOGO, EXIGE TRATAMENTO DE ERRO.
        throw new UnsupportedOperationException("Robot does not eat");
    }
}

//Adhering to ISP
//In this improved example, we split the interfaces into smaller ones so that each class only implements what it needs:

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable { // HUMANO IMPLEMENTA AMBAS INTERFACES
    @Override
    public void work() {
        System.out.println("Human working"); // HUMANO TRABALHA
    }

    @Override
    public void eat() {                  
        System.out.println("Human eating"); // HUMANO ALIMENTA-SE
    }
}

class Robot implements Workable { // ROBÔ APENAS IMPLEMENTA A INTERFACE DE TRABALHO
    @Override
    public void work() {
        System.out.println("Robot working"); // ASSIM, NÃO PRECISA DA TRATAR ERRO DA INTERFACE eat(); pois NÃO SE ALIMENTA.
    }
}


