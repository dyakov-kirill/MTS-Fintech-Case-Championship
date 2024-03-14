package ru.mts.delivery.courier;

public class Bike extends AbstractCourier {
    private final int time = 2;
    @Override
    public void deliver() {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
