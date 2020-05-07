package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.billing.Bill;
import stubs.delivery.Delivery;
import stubs.delivery.Exception_Exception;
import stubs.delivery.ParseException_Exception;

import java.text.ParseException;
import java.util.List;

public class GetBills extends Command<DDPublicAPI> {


    @Override
    public String identifier() {
        return "getBills";
    }

    @Override
    public void load(List<String> args) {
    }

    @Override
    public void execute() {
        List<Bill> lB = shell.system.bws.getBills();
        if(lB.size() == 0){
            System.out.println("<-------------------/" + "\\------------------------->");
            System.out.println("AUCUNE FACTURE DISPONIBLE !");
            System.out.println("<-------------------/" + "\\------------------------->");
        }else {
            for (Bill p : lB
            ) {
                System.out.println("<-------------------/" + "\\------------------------->");
                System.out.println("Num :: " + p.getId());
                System.out.println("Prix :: " + p.getBillAmount());
                System.out.println("Transporteur :: " + p.getProvider());
                System.out.println("Statut :: " + p.getBillStatus());
                System.out.println("<-------------------/" + "\\------------------------->");
            }
        }
    }

    @Override
    public String describe() {
        return "-----> Rechercher une livraison par date et heure";
    }

}
