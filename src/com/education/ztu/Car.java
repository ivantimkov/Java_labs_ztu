package com.education.ztu;

public class Car {
    private String model;
    private String numberPlate;
    private Engine engine;

    public Car(String model, String numberPlate) {
        this.model = model;
        this.numberPlate = numberPlate;
        this.engine = new Engine();
    }

    public void startCar() {
        engine.startEngine();
    }

    public void stopCar() {
        engine.stopEngine();
    }

    public boolean isRunning() {
        return engine.isEngineWorks();
    }

    // Внутрішній клас
    public class Engine {
        private boolean isRunning = false;

        public void startEngine() {
            isRunning = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            isRunning = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return isRunning;
        }
    }

    @Override
    public String toString() {
        return model + " (" + numberPlate + ")";
    }
}
