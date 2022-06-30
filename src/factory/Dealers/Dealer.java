package factory.Dealers;

import factory.Details.Auto;
import factory.Main.ConfigParser;
import factory.Storages.AutoStorage;

import java.util.logging.Logger;

public class Dealer implements Runnable {
    private static final Logger logger = Logger.getLogger(Dealer.class.getName());
    private int delay;
    private AutoStorage autoStorage;
    private boolean needLogs;

    public Dealer(AutoStorage autoStorage, int delay, boolean needLogs) {
        this.delay = delay;
        this.autoStorage = autoStorage;
        this.needLogs = needLogs;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Auto auto = autoStorage.getAuto();

                if (needLogs) {
                    logger.info(
                            "Dealer " + Thread.currentThread().getName() + ":"
                                    + "Auto " + auto.getId() + "("
                                    + "Body " + auto.getBodyDetail().getId() + ","
                                    + "Motor " + auto.getMotorDetail().getId() + ","
                                    + "Accessory " + auto.getAccessoryDetail().getId() + ")");
                }
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void setDelay(int delay) {
        this.delay = delay;
    }
}
