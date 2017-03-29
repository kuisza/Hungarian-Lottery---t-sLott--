import java.util.*;

/**
 * Created by bedaa on 08/03/2017.
 */

public class Week {
    public void weekly() {
        Random rand = new Random();
        Scanner sk = new Scanner(System.in);
        System.out.println("Please type in your lotto numbers that you wanna play with. ");
        System.out.println("This program has the same rules as the lottery in Hungary (Ötös Lottó).");
        System.out.println("You have to choose five numbers between 1 - 90");
        System.out.println("Separate the numbers with ';'  on one ticket and separate the different tickets with '-'");
        String numbers = sk.nextLine();
        String[] tickets = numbers.split("-");
        //the program turns our lottery tickets into sets of strings and put them into a list
        List<Set<String>> lottery = new ArrayList<>();
        for (String tick : tickets ) {
            Set<String> lottset = new TreeSet<String>(Arrays.asList(tick.split(";")));
            if (lottset.size() == 5) {
        lottery.add(lottset); }
           else {
                throw new NullPointerException("you have to give five numbers for each field");
            }

        }
        Lottery ourlotteryticket = new Lottery(lottery);

        System.out.println("You have " + lottery.size() + " tickets");
        System.out.println("Please type in for how many round you would like to buy the tickets.");
        int w = sk.nextInt();
        System.out.println("You have bought it for " + w + " rounds. Its gonna be "
                + (lottery.size() * w * 250 ) + " HUF");
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        for (int v = 1; v <= w ; v++) {
            Generator gen = new Generator();
            Set<String> thenumbers = gen.thewinners();
            System.out.println("----------");
            System.out.println(v + ". week:");



            for (Set<String> set : ourlotteryticket.lotterytickets) {
                System.out.println("----------");
                System.out.println("Our numbers:");
                System.out.println(set);
                System.out.println("The numbers");
                System.out.println(thenumbers);
                Set<String> common = new TreeSet<>(set);
                common.retainAll(thenumbers);
                int retain = common.size();
                System.out.print("the following numbers are the same:");
                System.out.println(common);
                System.out.println("which makes " + retain + " numbers ");
                System.out.println("----------");
                if (retain == 2 ) {
                        two++;
                }
                else if (retain == 3 ) {
                    three++;
                }
                else if (retain == 4 ) {
                    four++;
                }
                else if (retain == 5 ) {
                    five++;
                }


                System.out.println("----------");
            }
        }

        //the results after the last week
        System.out.println("Two: " + two);
        System.out.println("Three: " + three);
        System.out.println("Four: " + four);
        System.out.println("Five: " + five);
    }
}
