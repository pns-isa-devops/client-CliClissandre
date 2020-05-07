package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.billing.ExternalPartnerException_Exception;

import java.util.List;

//public class GetNextDelivery {
public class CheckStatus extends Command<DDPublicAPI> {

    private int id;

    @Override
    public String identifier() {
        return "status";
    }

    @Override
    public void load(List<String> args) {
        try {
            id = Integer.parseInt(args.get(0));
        } catch (NumberFormatException e) {
            System.out.println("Id incorrect");
        }
    }

    @Override
    public void execute() throws ExternalPartnerException_Exception {
        System.out.println("STATUT -----> " + shell.system.bws.checkStatut(id));
//            List<Integer> l = shell.system.bws.checkStatut();
//            for (Integer i : l
//            ) {
//                System.out.println(" i " + i);
//            }
    }

    @Override
    public String describe() {
        return "-----> Afficher les factures de la journée";
    }

}
