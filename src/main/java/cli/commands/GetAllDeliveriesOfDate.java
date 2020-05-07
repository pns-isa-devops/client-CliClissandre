package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.delivery.Delivery;
import stubs.delivery.Exception_Exception;
import stubs.delivery.ParseException_Exception;

import java.text.ParseException;
import java.util.List;

public class GetAllDeliveriesOfDate extends Command<DDPublicAPI> {

    private String date;

    @Override
    public String identifier() {
        return "findDeliveryByD";
    }

    @Override
    public void load(List<String> args) {
        date = args.get(0);
    }

    @Override
    public void execute() {
            List<Delivery> lD = shell.system.dews.getAllDeliveriesOfTheDate(date);
             for (Delivery p : lD
            ) {
                 System.out.println("<-------------------/" + "\\------------------------->");
                 System.out.println("Num :: " + p.getPackageDelivered().getSecretNumber());
                 System.out.println("Poids :: " + p.getPackageDelivered().getWeight());
                 System.out.println("Transporteur :: " + p.getPackageDelivered().getProvider().getName());
                 System.out.println("Date d'enregistrement :: " + p.getPackageDelivered().getRegisterDate());
                 System.out.println("Date de Livraison :: " + p.getDeliveryDate());
                 if (p.getDrone()!=null){
                     System.out.println("Drone chargé de la livraison :: " + p.getDrone().getDroneId());
                 }
//                 System.out.println("Drone chargé de la livraison :: " + p.getDrone().getDroneId());
                 System.out.println("<-------------------/" + "\\------------------------->");
            }
    }

    @Override
    public String describe() {
        return "-----> Rechercher une livraison par date et heure";
    }

}
