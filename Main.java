import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File("D:/sell.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        while (true) {
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Item item = new Item();
            System.out.print("Enter the name of the item: ");
            item.setName(sc1.nextLine());
            System.out.print("Enter the unit price: ");
            item.setPrice(sc1.nextDouble());
            System.out.print("Enter the quantity: ");
            item.setQuantity(sc1.nextInt());

            items.add(item);
            bw.write(item.getName() + ", " + item.getPrice() + ", " + item.getQuantity() + "\n");

            System.out.print("Continue shopping (y/n)? ");
            String check = sc2.nextLine();
            if (check.charAt(0) == 'n') {
                break;
            } else if (check.charAt(0) == 'y') {
                continue;
            } else {
                System.exit(0);
            }

        }

        bw.close();

        System.out.println();
        System.out.println("Final Shopping Cart totals");
        double total = 0;
        for (Item i : items) {
            System.out.println(i);
            total += i.getPrice() * i.getQuantity();
        }
        System.out.println("Total $ Amount in Cart $" + total);
    }
}
