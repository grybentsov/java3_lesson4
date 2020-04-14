package ru.geekbrains.java3_lesson4;

public class Symbols implements Runnable {

    private final Character character;
    private final MainClass mc;
    private final int counter;

    Symbols(Character character, MainClass object, int counter) {
        this.character = character;
        this.mc = object;
        this.counter = counter;
    }

    @Override
    public void run() {
        while(mc.condition < 13) {
            synchronized (mc) {

                while(!((mc.condition % 3) == 0) && counter == 1){
                    try {
                        mc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((mc.condition % 3) == 1) && counter == 2){
                    try {
                        mc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while(!((mc.condition % 3) == 2) && counter == 3){
                    try {
                        mc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(character);
                mc.condition++;
                mc.notifyAll();
            }
        }
    }
}
