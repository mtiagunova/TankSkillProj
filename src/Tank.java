public class Tank {

    public static void main(String[] args) {

        // At (0;0) fuel=100
        Tank justTank = new Tank();

        // At (10;10) fuel=100
        Tank anywareTank = new Tank(10, 10);

        // At (20;30) fuel=200
        Tank customTank = new Tank(20, 30, 200);

        justTank.goForward(200);
        justTank.printPosition();

        anywareTank.goBackward(-200);
        anywareTank.printPosition();

        customTank.goForward(201);
        customTank.printPosition();



/*
This fragment of code has to output

The Tank is at 100, 0 now.
The Tank is at 110, 10 now.
The Tank is at 220, 30 now.

*/
    }

    private int x, y;
    private int dir;
    private int fuel;
    private final String MODEL = "T34";
    private int n;

    static int tankCount;

    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int x, int y) {
        this(x, y, 100);
    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.dir = 0;
        this.fuel = fuel;
        n = ++tankCount;
    }

    public void goForward(int i) {
        if (this.fuel >= i) {
            if (dir == 0) x += i;
            else if (dir == 1) y += i;
            else if (dir == 2) x -= i;
            else y -= i;
            this.fuel -= i;
        } else {
            if (dir == 0) x += this.fuel;
            else if (dir == 1) y += this.fuel;
            else if (dir == 2) x -= this.fuel;
            else y -= this.fuel;
            this.fuel = 0;
        }
    }

    public void printPosition() {
        System.out.println("The Tank " + MODEL + "-" + n + " is at " + x +", " + y + " now.");
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
    }

    public void goBackward(int i) {
        goForward(-i);
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
