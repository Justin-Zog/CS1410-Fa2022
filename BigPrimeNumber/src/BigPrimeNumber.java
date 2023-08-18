
import java.time.ZonedDateTime;
import java.math.BigInteger;
import java.util.*;


public class BigPrimeNumber {
    public static void main(String[]args){

        long startTime = ZonedDateTime.now().toInstant().toEpochMilli();

        Boolean isPrime = false;
        int amountOfCombos = 0;
        Hashtable<String, BigInteger> combosDict = new Hashtable<String, BigInteger>();

        String[] years = new String[] {
                "1985",
                "1986",
                "1987",
                "1988",
                "1989",
                "1990",
                "1991",
                "1992",
                "1993",
                "1994",
                "1995"
        };


        while (!isPrime) {

            if (amountOfCombos == 39_916_800) {
                System.out.println("The dictionary has all possible combos...");
                System.out.println("Hooray! I'mma exit the program now!");
                System.out.println("Looks like there are no possible primes...");
                System.exit(1);
            }

            String bigNumber = "";

            List<String> lYears = Arrays.asList(years);
            Collections.shuffle(lYears);
            years = lYears.toArray(new String[lYears.size()]);

            for (int i = 0; i < years.length; i++) {
                bigNumber += years[i];
            }

            BigInteger randomNumber = new BigInteger(bigNumber);

            // Check to see if the number is already made and skip it if it has been.

            if (!combosDict.containsValue(randomNumber)) {

                combosDict.put(String.valueOf(amountOfCombos), randomNumber);
                amountOfCombos++;
                System.out.println("Amount of combos: " + amountOfCombos + " " + randomNumber + "\nFound in: " + (((ZonedDateTime.now().toInstant().toEpochMilli()) - startTime) / 1000) + " seconds.");

                if (randomNumber.isProbablePrime(1)) {
                    System.out.println(randomNumber + " is probably a prime dude!!!");
                    isPrime = true;
                }

            }


            /*
            if (randomNumber.remainder(new BigInteger("5")).equals(new BigInteger("0"))) {
                System.out.println("Time since start in milli: " + ((ZonedDateTime.now().toInstant().toEpochMilli()) - startTime));
            }
            */



        }

    }

}

