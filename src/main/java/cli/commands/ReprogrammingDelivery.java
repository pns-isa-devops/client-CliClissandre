package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.customer.UnknownCustomerException_Exception;
import stubs.packageR.UnknownPackageException_Exception;
import stubs.planning.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReprogrammingDelivery extends Command<DDPublicAPI> {

    private String a;
    private String b;
    private String c;
    private String d;


    @Override
    public String identifier() {
        return "reprogrammingDelivery";
    }

    @Override
    public void load(List<String> args) {
        a = args.get(0);
        b = args.get(1);
        c = args.get(2);
        d = args.get(3);
        if (c.equals("TODAY")){
            c = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        if (a.equals("TODAY")){
            a = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }

    @Override
    public void execute() {
        try {
            String rep = shell.system.plws.repogrammingDelivery(a, b, c, d);
            System.out.println("*** Enrégistré ***");
        } catch (UnvailableSlotTimeException_Exception e) {
            System.out.println("*** Plage horaire indisponible ***");
        } catch (ParseException_Exception e) {
            System.out.println("*** Date Error ***");
        }
    }

    @Override
    public String describe() {
        return "-----> Reprogrammer une livraison déja enrégistrée";
    }

}
