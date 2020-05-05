package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.customer.UnknownCustomerException_Exception;
import stubs.packageR.UnknownPackageException_Exception;
import stubs.planning.*;

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
        } catch (UnvailableSlotTimeException_Exception e) {
            System.out.println("*** Plage horaire indisponible ***");
        }catch (PackageAlreadyTookException_Exception e) {
            System.out.println("*** La livraison de ce colis a été déja programmé ***");
        } catch (ParseException_Exception e) {
            System.out.println("*** Date Error ***");
        } catch (UnknownCustomerException e) {
            System.out.println("*** Ce client n'a pas été enrégistré ***");
        } catch (UnknownPackageException e) {
            System.out.println("*** Colis Inexistant ***");
        }
    }

    @Override
    public String describe() {
        return "-----> Enregistrer une livraison";
    }

}
