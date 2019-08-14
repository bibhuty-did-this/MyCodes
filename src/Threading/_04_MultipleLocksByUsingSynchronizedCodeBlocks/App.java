package Threading._04_MultipleLocksByUsingSynchronizedCodeBlocks;

public class App {
    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }
}
