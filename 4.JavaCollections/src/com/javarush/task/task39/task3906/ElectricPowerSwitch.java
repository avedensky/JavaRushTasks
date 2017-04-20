package com.javarush.task.task39.task3906;

public class ElectricPowerSwitch {
    private Switchable securitySystem;

    public ElectricPowerSwitch(Switchable electricalСircuit) {
        this.securitySystem = electricalСircuit;
    }

    public void press() {
        System.out.println("Pressed the power switch.");
        if (securitySystem.isOn()) {
            securitySystem.turnOff();
        } else {
            securitySystem.turnOn();
        }
    }
}
