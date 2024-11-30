//open for extension but closed for modification (Software entities: classes, modules, functions, etc.)
//PRECISOU DE NOVA FUNCIONALIDADE? Crie uma nova entidade.
// Não modificar com IF e ELSE; Utilizar POLIMORFISMO: crie novas classes-FILHA

// Before OCP = VÁRIOS IF/ELSE; 
//grande risco de quebrar o código na atualização ou implementação de nova regra +
//tamanho da entidade fica muito grande.
// A INTERFACE p/ calcular a Área deve servir para qualquer polígono.
class Shape {
    public String type;
}

class AreaCalculator {
    public double calculate(Shape shape) {
        if (shape.type.equals("circle")) {
            // calculate area of circle
        } else if (shape.type.equals("square")) {
            // calculate area of square
        }
        return 0;
    }
}

// After OCP = 01 INTERFACE p/ implementar classes de polígonos
// Ao longo do tempo
// Sem afetar os poligonos antecessores.
interface Shape { //INTERFACE
    double calculateArea();
}

class Circle implements Shape { //POLÍGONO 01 = CÍRCULO
    @Override // SOBRESCREVE A INTERFACE
    public double calculateArea() {
        // calculate area of circle
        return 0;
    }
}

class Square implements Shape {//POLÍGONO 02 = QUADRADO (Sem nenhum impacto no Círculo: Aberto para extensão, fechado para modificação).
    @Override // SOBRESCREVE A INTERFACE
    public double calculateArea() {
        // calculate area of square
        return 0;
    }
}

class AreaCalculator {
    public double calculate(Shape shape) { // MÉTODO recebe o Shape escolhido como parâmetro.
        return shape.calculateArea(); //retorna o valor da Área.
    }
} //Calling calculateArea:
//When the calculate method is called,
//it invokes the calculateArea method of the specific shape passed to it.
//The actual calculation is handled by the shape itself,
//ensuring that the AreaCalculator class does not need to know the details of how the area is calculated for each shape.

// E.G. CIRCLE implementing SHAPE Interface.
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class AreaCalculator {
    public double calculate(Shape shape) {
        return shape.calculateArea();
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        AreaCalculator calculator = new AreaCalculator();
        double area = calculator.calculate(circle);
        System.out.println("Area: " + area);
    }
}
