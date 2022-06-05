package factory.Collector;

import factory.Details.AccessoryDetail;
import factory.Details.BodyDetail;
import factory.Details.MotorDetail;
import threadpool.Task;

public class CollectorTask implements Task{
    Collector collector;

    public CollectorTask(Collector collector) {
        this.collector = collector;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void performWork() throws InterruptedException {
        BodyDetail bodyDetail = collector.getBodyStorage().poll();
        MotorDetail motorDetail = collector.getMotorStorage().poll();
        AccessoryDetail accessoryDetail = collector.getAccessoryStorage().poll();

        collector.getAutoStorage().addAuto(bodyDetail, motorDetail, accessoryDetail);
    }
}
