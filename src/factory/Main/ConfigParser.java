package factory.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ConfigParser {
    private static final Properties p;
    private final static Logger log = Logger.getLogger(ConfigParser.class.getName());

    private int bodyStorageSize;
    private int motorStorageSize;
    private int accessoryStorageSize;
    private int autoStorageSize;

    private int bodySupplierMinDelay;
    private int motorSupplierMinDelay;
    private int accessorySupplierMinDelay;
    private int dealerMinDelay;

    private int accessorySuppliers;
    private int workers;
    private int dealers;

    private boolean needLogs = false;

    static {
        try {
            InputStream resourceAsStream = ConfigParser.class.getClassLoader().getResourceAsStream("config.properties");
            p = new Properties();
            p.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private boolean ifLogging (String value) {
        return value == null && needLogs;
    }

    public ConfigParser() {
        String value = null;

        value = p.getProperty("NeedLogs");
        if (value != null) {
            needLogs = Boolean.valueOf(value);
        }

        value = p.getProperty("BodyStorageSize");
        if (ifLogging(value)) {
            log.severe("Couldn't read BodyStorageSize from properties file");
        } else {
            bodyStorageSize = Integer.valueOf(value);
        }

        value = p.getProperty("MotorStorageSize");
        if (ifLogging(value)) {
            log.severe("Couldn't read MotorStorageSize from properties file");
        } else {
            motorStorageSize = Integer.valueOf(value);
        }

        value = p.getProperty("AccessoryStorageSize");
        if (ifLogging(value)) {
            log.severe("Couldn't read AccessoryStorageSize from properties file");
        } else {
            accessoryStorageSize = Integer.valueOf(value);
        }

        value = p.getProperty("AutoStorageSize");
        if (ifLogging(value)) {
            log.severe("Couldn't read AutoStorageSize from properties file");
        } else {
            autoStorageSize = Integer.valueOf(value);
        }

        value = p.getProperty("BodySupplierMinDelay");
        if (ifLogging(value)) {
            log.severe("Couldn't read BodySupplierMinDelay from properties file");
        } else {
            bodySupplierMinDelay = Integer.valueOf(value);
        }

        value = p.getProperty("MotorSupplierMinDelay");
        if (ifLogging(value)) {
            log.severe("Couldn't read MotorSupplierMinDelay from properties file");
        } else {
            motorSupplierMinDelay = Integer.valueOf(value);
        }

        value = p.getProperty("AccessorySupplierMinDelay");
        if (ifLogging(value)) {
            log.severe("Couldn't read AccessorySupplierMinDelay from properties file");
        } else {
            accessorySupplierMinDelay = Integer.valueOf(value);
        }

        value = p.getProperty("DealerMinDelay");
        if (ifLogging(value)) {
            log.severe("Couldn't read DealerMinDelay from properties file");
        } else {
            dealerMinDelay = Integer.valueOf(value);
        }

        value = p.getProperty("AccessorySuppliers");
        if (ifLogging(value)) {
            log.severe("Couldn't read AccessorySuppliers from properties file");
        } else {
            accessorySuppliers = Integer.parseInt(value);
        }

        value = p.getProperty("Workers");
        if (ifLogging(value)) {
            log.severe("Couldn't read Workers from properties file");
        } else {
            workers = Integer.valueOf(value);
        }

        value = p.getProperty("Dealers");
        if (ifLogging(value)) {
            log.severe("Couldn't read Dealers from properties file");
        } else {
            dealers = Integer.valueOf(value);
        }
    }

    public int getBodyStorageSize() {
        return bodyStorageSize;
    }

    public int getMotorStorageSize() {
        return motorStorageSize;
    }

    public int getAccessoryStorageSize() {
        return accessoryStorageSize;
    }

    public int getAutoStorageSize() {
        return autoStorageSize;
    }

    public int getBodySupplierMinDelay() {
        return bodySupplierMinDelay;
    }

    public int getMotorSupplierMinDelay() {
        return motorSupplierMinDelay;
    }

    public int getAccessorySupplierMinDelay() {
        return accessorySupplierMinDelay;
    }

    public int getDealerMinDelay() {
        return dealerMinDelay;
    }

    public int getAccessorySuppliers() {
        return accessorySuppliers;
    }

    public int getWorkers() {
        return workers;
    }

    public int getDealers() {
        return dealers;
    }

    public boolean isNeedLogs() {
        return needLogs;
    }
}
