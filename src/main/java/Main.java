import cli.commands.*;
import cli.framework.Shell;
import api.DDPublicAPI;
// test

/**
 * An Interactive shell that interacts with a Cookie on Demand instance
 * Use -Dexec.args="IP_ADDRESS PORT_NUMBER" to change host/port parameters
 */
public class Main extends Shell<DDPublicAPI> {
    // yes jjdj

    public Main(String host, String port) {

        this.system = new DDPublicAPI(host, port);
        this.invite = "DDelivery";

        // Registering the command available for the user
        register(
                // Getting out of here
                Bye.class,

                FindCustomer.class,

                FindProvider.class,

                RegisterProvider.class,

                RegisterCustomer.class,

                FindPackage.class,

                ValidSlot.class,

                CheckStatus.class,

                ReprogrammingDelivery.class,

                RegisterDrone.class,

                RegisterDelivery.class,

                RegisterPackage.class,

                GenerateBills.class,

                NextDelivery.class,

                GetAllDeliveriesOfDate.class,

                FindDeliveryByDateAndHour.class,

                GetBills.class,

                GetPaidBills.class,

                DeleteAllCustomer.class,

                DeleteAllBill.class,

                DeleteAllDelivery.class,

                DeleteAllPackage.class,

                DeleteAllProvider.class,

                DeleteAllDrone.class
        );
    }

    public static void main(String[] args) {
        String host = (args.length == 0 ? "localhost" : args[0]);
        String port = (args.length < 2 ? "8000" : args[1]);
        System.out.println("\n\nStarting Drone Delivery By Livrair");
        System.out.println("  - Remote server: " + host);
        System.out.println("  - Port number:   " + port);
        Main main = new Main(host, port);
        main.run();
        System.out.println("Exiting Drone Delivery By Livrair\n\n");
    }

}
