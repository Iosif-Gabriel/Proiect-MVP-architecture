package Model;

public class Pyramid implements Polyhedron{
    @Override
    public double getheight() {
        return 0;
    }

    @Override
    public double getlateralArea(int size) {
        return 0;
    }

    @Override
    public double getbaseArea(int size) {
        return size*size;
    }

    @Override
    public double gettotalArea() {
        return 0;
    }

    @Override
    public double getvolume(int size) {
        return 0;
    }
}
