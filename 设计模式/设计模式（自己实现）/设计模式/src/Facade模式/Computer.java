package Facade模式;

public class Computer {
    private Cpu cpu;
    private Memory memory;

    public Computer() {
        cpu=new Cpu();
        memory=new Memory();
    }

    public void run(){
        memory.load();
        cpu.compute();
    }
}
