public class Recursion {
    public static void main(String[] args) {

        int[] sumMe = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        System.out.printf("Array Sum: %d\n", arraySum(sumMe, 0));

        int[] minMe = { 0, 1, 1, 2, 3, 5, 8, -42, 13, 21, 34, 55, 89 };
        System.out.printf("Array Min: %d\n", arrayMin(minMe, 0));

        String[] amISymmetric =  {
                "You can cage a swallow can't you but you can't swallow a cage can you",
                "I still say cS 1410 is my favorite class"
        };
        for (String test : amISymmetric) {
            String[] words = test.toLowerCase().split(" ");
            System.out.println();
            System.out.println(test);
            System.out.printf("Is word symmetric: %b\n", isWordSymmetric(words, 0, words.length - 1));
        }

        double[][] weights = {
                { 51.18 },
                { 55.90, 131.25 },
                { 69.05, 133.66, 132.82 },
                { 53.43, 139.61, 134.06, 121.63 }
        };
        System.out.println();
        System.out.println("--- Weight Pyramid ---");
        for (int row = 0; row < weights.length; row++) {
            for (int column = 0; column < weights[row].length; column++) {
                double weight = computePyramidWeights(weights, row, column);
                System.out.printf("%.2f ", weight);
            }
            System.out.println();
        }

        char[][] image = {
                {'*','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ','*','*',' ',' '},
                {' ','*',' ',' ','*','*','*',' ',' ',' '},
                {' ','*','*',' ','*',' ','*',' ','*',' '},
                {' ','*','*',' ','*','*','*','*','*','*'},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ','*','*','*',' ',' ','*',' '},
                {' ',' ',' ',' ',' ','*',' ',' ','*',' '}
        };
        int howMany = howManyOrganisms(image);
        System.out.println();
        System.out.println("--- Labeled Organism Image ---");
        for (char[] line : image) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.printf("There are %d organisms in the image.\n", howMany);

    }

    public static boolean isWordSymmetric(String[] words, int start, int end) {
        if (words.length == 0) {
            return true;
        }

        for (int i = start; i < end; i++) {
            if (!(words[i].equalsIgnoreCase(words[end - i]))) {
                return false;
            }
        }
        return true;
    }

    public static long arraySum(int[] data, int position) {
        long total = 0;

        for (int i = position; i < data.length; i++) {
            total += data[i];
        }

        return total;
    }

    public static int arrayMin(int[] data, int position) {
        int min = Integer.MAX_VALUE;

        for (int i = position; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }

        return min;
    }

    public static double computePyramidWeights(double[][] weights, int row, int column) {
        if (row > weights.length - 1 || row < 0) {
            return 0.0;
        }
        else if (column > weights[row].length - 1 || column < 0) {
            return 0.0;
        }
        else {
            double weight = weights[row][column];

            if (column != 0 || column != weights[row].length - 1) {
                weight += (computePyramidWeights(weights, row-1, column)) / 2;
                weight += (computePyramidWeights(weights, row-1, column-1)) / 2;
            }
            else if (column == weights[row].length - 1 && row != 0) {
                weight += (computePyramidWeights(weights, row-1, column-1)) / 2;
            }
            else if (row != 0) {
                weight += (computePyramidWeights(weights, row-1, column)) / 2;
            }
            return weight;
        }
    }

    public static int howManyOrganisms(char[][] image) {

        if (image == null) {
            return 0;
        }

        int organisms = 0;
        char letter = 'a';
        int r = 0;

        for (char[] row : image) {
            int c = 0;
            for (char cell : row) {
                if (cell == '*') {
                    checkSurroundings(image, r, c, letter);
                    organisms ++;
                    letter ++;
                }
                c ++;
            }
            r ++;
        }

        return organisms;
    }

    public static void checkSurroundings(char[][] image, int row, int column, char letter) {

        image[row][column] = letter;

        if (row != 0 && image[row-1].length - 1 >= column) {
            if (image[row-1][column] == '*') {
                checkSurroundings(image, row-1, column, letter);
            }
        }

        if (row != image.length - 1 && image[row+1].length - 1 >= column) {
            if (image[row+1][column] == '*') {
                checkSurroundings(image, row+1, column, letter);
            }
        }

        if (column != 0) {
            if (image[row][column-1] == '*') {
                checkSurroundings(image, row, column-1, letter);
            }
        }

        if (column != image[row].length - 1) {
            if (image[row][column+1] == '*') {
                checkSurroundings(image, row, column+1, letter);
            }
        }

    }

}
