public class PatternBlinker extends Pattern {
    final int sizeX = 0;
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
        // Always returns true since the whole shape is filled.
        return true;
    }
}
