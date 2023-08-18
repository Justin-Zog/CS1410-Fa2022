public class PatternGosperGlider extends Pattern {
    final int sizeX = 35;
    final int sizeY = 8;

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

        if (x==24 && y==0) {
            return true;
        }
        else if ((x==24 || x==22) && y==1) {
            return true;
        }
        else if ((x==20 || x==21 || x==34 || x==35 || x==13 || x==12) && y==2) {
            return true;
        }
        else if ((x==11 || x==15 || x==20 || x==21 || x==34 || x==35) && y==3) {
            return true;
        }
        else if ((x==0 || x==1 || x==10 || x==16 || x==20 || x==21) && y==4) {
            return true;
        }
        else if ((x==0 || x==1 || x==10 || x==14 || x==16 || x==17 || x==22 || x==24) && y==5) {
            return true;
        }
        else if ((x==10 || x==16 || x==24) && y==6) {
            return true;
        }
        else if ((x==11 || x==15) && y==7) {
            return true;
        }
        else if ((x==12 || x==13) && y==8) {
            return true;
        }
        else {
            return false;
        }
    }
}
