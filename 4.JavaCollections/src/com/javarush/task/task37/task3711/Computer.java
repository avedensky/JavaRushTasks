package com.javarush.task.task37.task3711;

/**
 * Created by Alexey Vedensky on 17.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Computer {
    CPU cpu;
    Memory memory;
    HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void run() {


        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
