package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.billing.ExternalPartnerException_Exception;

import java.util.List;

//public class GetNextDelivery {
public class CheckStatus extends Command<DDPublicAPI> {


    @Override
    public String identifier() {
        return "status";
    }

    @Override
    public void load(List<String> args) {

    }

    @Override
    public void execute() throws ExternalPartnerException_Exception {
        try {
            List<Integer> l = shell.system.bws.checkStatut();
            for (Integer i : l
            ) {
                System.out.println(" i " + i);
            }
        } catch (ExternalPartnerException_Exception e) {
            System.out.println("<-------------------/" + "\\------------------------->");
        }
    }

    @Override
    public String describe() {
        return "-----> Afficher les factures de la journée";
    }

}
