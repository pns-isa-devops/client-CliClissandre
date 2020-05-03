package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.customer.AlreadyExistingCustomerException_Exception;
import stubs.planning.Exception_Exception;

import java.util.List;

public class RegisterDelivery extends Command<DDPublicAPI> {

    private String a;
    private String b;
    private String c;
    private String d;


    @Override
    public String identifier() {
        return "registerDelivery";
    }

    @Override
    public void load(List<String> args) {
        a = args.get(0) + " " + args.get(1);
        b = args.get(2);
        c = args.get(3);
        d = args.get(4);
    }

    @Override
    public void execute() {
        try {
            String rep = shell.system.plws.registerDelivery(a, b, c, d);
            System.out.println("*** Enrégistré ***");
        } catch (Exception_Exception e) {
            System.out.println("*** Echec de l'enrégistrement ***");
        }
    }

    @Override
    public String describe() {
        return "-----> Enregistrer une livraison";
    }

}
