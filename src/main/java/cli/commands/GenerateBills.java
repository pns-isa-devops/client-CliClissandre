package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.billing.ExternalPartnerException_Exception;

import java.util.List;

//public class GetNextDelivery {
public class GenerateBills extends Command<DDPublicAPI> {


    @Override
    public String identifier() {
        return "generate";
    }

    @Override
    public void load(List<String> args) {
    }

    @Override
    public void execute()  {
        System.out.println("GENERATION  -----> " + shell.system.bws.generateBill());
    }

    @Override
    public String describe() {
        return "-----> générer les factures de la journée";
    }

}
