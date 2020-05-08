package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.billing.Bill;
import stubs.billing.ExternalPartnerException_Exception;

import java.util.List;

public class GetPaidBills extends Command<DDPublicAPI> {


    @Override
    public String identifier() {
        return "getPaidBills";
    }

    @Override
    public void load(List<String> args) {
    }

    @Override
    public void execute() {
        try {
            List<Bill> lB = shell.system.bws.getAllPaidBills();
            if (lB.size() == 0) {
                System.out.println("<-------------------/" + "\\------------------------->");
                System.out.println("AUCUNE FACTURE PAYEE !");
                System.out.println("<-------------------/" + "\\------------------------->");
            } else {
                for (Bill p : lB
                ) {
                    System.out.println("<-------------------/" + "\\------------------------->");
                    System.out.println("Num :: " + p.getIdBill());
                    System.out.println("Prix :: " + p.getBillAmount());
                    System.out.println("Transporteur :: " + p.getProvider().getName());
                    System.out.println("Statut :: " + p.getBillStatus());
                    System.out.println("<-------------------/" + "\\------------------------->");
                }
            }
        } catch (ExternalPartnerException_Exception e) {
            System.out.println("Erreur dûe au Service externe");
        }

    }

    @Override
    public String describe() {
        return "-----> Lister toutes les factures payées";
    }

}
