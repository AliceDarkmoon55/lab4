package factory.Main;

import factory.Collector.Collector;
import factory.Collector.CollectorController;
import factory.Dealers.AutoSale;
import factory.Details.AccessoryDetail;
import factory.Details.BodyDetail;
import factory.Details.MotorDetail;
import factory.Storages.AutoStorage;
import factory.Storages.Storage;
import factory.UI.UserInterface;

import java.io.IOException;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) throws IOException {
        ConfigParser parser = new ConfigParser();
        boolean isLogging = parser.isNeedLogs();
        if (isLogging) {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        }

        Storage<BodyDetail> bodyStorage = new Storage<>(parser.getBodyStorageSize(),
                parser.getBodySupplierMinDelay(),
                BodyDetail.class);
        bodyStorage.addSupplier();


        Storage<MotorDetail> motorStorage = new Storage<>(parser.getMotorStorageSize(),
                parser.getMotorSupplierMinDelay(),
                MotorDetail.class);
        motorStorage.addSupplier();

        Storage<AccessoryDetail> accessoryStorage = new Storage<>(parser.getAccessoryStorageSize(),
                parser.getAccessorySupplierMinDelay(),
                AccessoryDetail.class);
        for (int i = 0; i < parser.getAccessorySuppliers(); i++) {
            accessoryStorage.addSupplier();
        }

        AutoStorage autoStorage = new AutoStorage(parser.getAutoStorageSize());
        Collector collector = new Collector(bodyStorage, motorStorage, accessoryStorage, autoStorage);
        AutoSale autoSale = new AutoSale(autoStorage, parser.getDealers(), parser.getDealerMinDelay(), isLogging);

        new Thread(new UserInterface(collector,autoSale, parser)).start();
        new Thread(new CollectorController(collector)).start();
        new Thread(autoSale).start();
    }
}
