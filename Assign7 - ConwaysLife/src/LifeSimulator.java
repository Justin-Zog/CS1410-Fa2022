public class LifeSimulator {

    final private int sizeX;
    final private int sizeY;

    boolean[][] original_grid;


    // Size x and y are the size of the world.
    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.original_grid = new boolean[sizeX][sizeY];
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    // Returns true if the world cell is alive, false otherwise.
    public boolean getCell(int x, int y) {
        return original_grid[x][y];
    }

    // Adds the pattern to the world. Upper left of pattern beginning at startX and startY.
    // This method is only called once when the world is created.
    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int i=0; i < pattern.getSizeX(); i++) {
            for (int j=0; j < pattern.getSizeY(); j++) {
                original_grid[startX+i][startY+j] = pattern.getCell(i, j);
            }
        }
    }

    public int checkNeighbors(int x, int y, int edge) {
        int neighbors = 0;

        // Not by any edges
        if (edge == 0) {
            if (original_grid[x-1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x-1][y]) {
                neighbors ++;
            }
            if (original_grid[x-1][y+1]) {
                neighbors ++;
            }
            if (original_grid[x][y-1]) {
                neighbors ++;
            }
            if (original_grid[x][y+1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y]) {
                neighbors ++;
            }
            if (original_grid[x+1][y+1]) {
                neighbors ++;
            }
        }
        // By top edge but not a corner
        else if (edge == 1) {
            if (original_grid[x][y-1]) {
                neighbors ++;
            }
            if (original_grid[x][y+1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y]) {
                neighbors ++;
            }
            if (original_grid[x+1][y+1]) {
                neighbors ++;
            }
        }
        // By left edge but not a corner
        else if (edge == 2) {
            if (original_grid[x-1][y]) {
                neighbors ++;
            }
            if (original_grid[x-1][y+1]) {
                neighbors ++;
            }
            if (original_grid[x][y+1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y]) {
                neighbors ++;
            }
            if (original_grid[x+1][y+1]) {
                neighbors ++;
            }
        }
        // By right edge but not a corner
        else if (edge == 3) {
            if (original_grid[x-1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x-1][y]) {
                neighbors ++;
            }
            if (original_grid[x][y-1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y]) {
                neighbors ++;
            }
        }
        // By the bottom edge but no a corner
        else if (edge == 4) {
            if (original_grid[x-1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x-1][y]) {
                neighbors ++;
            }
            if (original_grid[x-1][y+1]) {
                neighbors ++;
            }
            if (original_grid[x][y-1]) {
                neighbors ++;
            }
            if (original_grid[x][y+1]) {
                neighbors ++;
            }
        }
        // Top Left Corner
        else if (edge == 5) {
            if (original_grid[x][y+1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y]) {
                neighbors ++;
            }
            if (original_grid[x+1][y+1]) {
                neighbors ++;
            }
        }
        // Top Right Corner
        else if (edge == 6) {
            if (original_grid[x][y-1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x+1][y]) {
                neighbors ++;
            }
        }
        // Bottom Left Corner
        else if (edge == 7) {
            if (original_grid[x-1][y]) {
                neighbors ++;
            }
            if (original_grid[x-1][y+1]) {
                neighbors ++;
            }
            if (original_grid[x][y+1]) {
                neighbors ++;
            }
        }
        // Bottom Right Corner
        else if (edge == 8) {
            if (original_grid[x-1][y-1]) {
                neighbors ++;
            }
            if (original_grid[x-1][y]) {
                neighbors ++;
            }
            if (original_grid[x][y-1]) {
                neighbors ++;
            }
        }

        return neighbors;
    }

    public void update() {
        boolean[][] updated_grid = new boolean[this.sizeX][this.sizeY];

        try {
            // Check the neighbors row by row
            for (int row=0; row<original_grid.length; row++) {
                for (int column=0; column<original_grid[row].length; column++) {
                    int neighbors = 0;
                    // The current cell is not on any of the edges. So we check all 8 neighbors.
                    if (row != 0 && row != original_grid.length-1 && column != 0 && column != original_grid[row].length-1) {
                        neighbors = checkNeighbors(row, column, 0);
                    }
                    // It's on the top edge but not a corner.
                    else if (row == 0 && column != 0 && column != original_grid[row].length-1) {
                        neighbors = checkNeighbors(row, column, 1);
                    }
                    // It's on the left edge but not a corner.
                    else if (row != 0 && row != original_grid.length-1 && column == 0) {
                        neighbors = checkNeighbors(row, column, 2);
                    }
                    // It's on the right edge but not a corner.
                    else if (row != 0 && row != original_grid.length-1 && column == original_grid[row].length-1) {
                        neighbors = checkNeighbors(row, column, 3);
                    }
                    // It's on the bottom edge but not a corner.
                    else if (row == original_grid.length-1 && column != 0 && column != original_grid[row].length-1) {
                        neighbors = checkNeighbors(row, column, 4);
                    }
                    // It's the top left corner.
                    else if (row == 0 && column == 0) {
                        neighbors = checkNeighbors(row, column, 5);
                    }
                    // It's the top right corner.
                    else if (row == 0 && column == original_grid[row].length-1) {
                        neighbors = checkNeighbors(row, column, 6);
                    }
                    // It's the bottom left corner.
                    else if (row == original_grid.length-1 && column == 0) {
                        neighbors = checkNeighbors(row, column, 7);
                    }
                    // It's the bottom right corner.
                    else if (row == original_grid.length-1 && column == original_grid[row].length-1) {
                        neighbors = checkNeighbors(row, column, 8);
                    }

                    // Create the updated_grid based on the neighbors.
                    // This is a live cell
                    if (original_grid[row][column]) {
                        if (neighbors == 2 || neighbors == 3) {
                            updated_grid[row][column] = true;
                        }
                    }
                    else {
                        if (neighbors == 3) {
                            updated_grid[row][column] = true;
                        }
                    }

                }
        }

        } catch (Exception ex) {
            System.out.println("Something gross has happened: " + ex.getMessage());
        }

        // Set the original grid to the updated one.
        original_grid = updated_grid;

    }

}
