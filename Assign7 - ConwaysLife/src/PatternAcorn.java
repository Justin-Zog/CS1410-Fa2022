public class PatternAcorn extends Pattern {

    final int sizeX = 6;
    final int sizeY = 2;

    @Override
    public int getSizeX() {
        return sizeX + 1;
    }

    @Override
    public int getSizeY() {
        return sizeY + 1;
    }

    @Override
    public boolean getCell(int x, int y) {

        if (y==0 && x==1) {
            return true;
        }
        else if (y==1 && x==3) {
            return true;
        }
        else if (y==2 && (x<2 || x>3)) {
            return true;
        }
        else {
            return false;
        }
    }
}
