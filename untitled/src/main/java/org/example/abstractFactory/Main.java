package org.example.abstractFactory;

abstract class Lot {
    abstract void display();
}

class ConcreteLot extends Lot {
    @Override
    void display() {
        System.out.println("Це конкретний лот");
    }
}

abstract class User {
    abstract void display();
}

class ConcreteUser extends User {
    @Override
    void display() {
        System.out.println("Це конкретний користувач");
    }
}

abstract class LotFactory {
    abstract Lot createLot();
}

abstract class UserFactory {
    abstract User createUser();
}

class ConcreteLotFactory extends LotFactory {
    @Override
    Lot createLot() {
        return new ConcreteLot();
    }
}

class ConcreteUserFactory extends UserFactory {
    @Override
    User createUser() {
        return new ConcreteUser();
    }
}

class AuctionApplication {
    private LotFactory lotFactory;
    private UserFactory userFactory;

    public AuctionApplication(AbstractFactory factory) {
        this.lotFactory = factory.createLotFactory();
        this.userFactory = factory.createUserFactory();
    }

    public void createAndDisplayLot() {
        Lot lot = lotFactory.createLot();
        lot.display();
    }

    public void createAndDisplayUser() {
        User user = userFactory.createUser();
        user.display();
    }
}

abstract class AbstractFactory {
    abstract LotFactory createLotFactory();
    abstract UserFactory createUserFactory();
}

class ConcreteFactory extends AbstractFactory {
    @Override
    LotFactory createLotFactory() {
        return new ConcreteLotFactory();
    }

    @Override
    UserFactory createUserFactory() {
        return new ConcreteUserFactory();
    }
}

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        AuctionApplication app = new AuctionApplication(factory);

        app.createAndDisplayLot();
        app.createAndDisplayUser();
    }
}
