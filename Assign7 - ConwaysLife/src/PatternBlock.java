public class PatternBlock extends Pattern {
    final int sizeX = 1;
    final int sizeY = 1;

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
        // This should always return true since every cell is filled in the 'Block' pattern.
        return true;
    }
}
