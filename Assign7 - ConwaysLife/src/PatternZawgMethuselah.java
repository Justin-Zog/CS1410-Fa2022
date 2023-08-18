public class PatternZawgMethuselah extends Pattern {
    final int sizeX = 2;
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
        if (x==0 || x==2) {
            return true;
        }
        else if (x==1 && y==2) {
            return true;
        }
        else {
            return false;
        }
    }
}
