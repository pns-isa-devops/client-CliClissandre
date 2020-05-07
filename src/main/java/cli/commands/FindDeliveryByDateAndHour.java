package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.delivery.Delivery;
import stubs.delivery.Exception_Exception;

import java.util.List;

public class FindDeliveryByDateAndHour extends Command<DDPublicAPI> {

    private String date;
    private String hour;

    @Override
    public String identifier() {
        return "findDeliveryByDH";
    }

    @Override
    public void load(List<String> args) {
        date = args.get(0);
        hour = args.get(1);
    }

    @Override
    public void execute() {
        try {
            Delivery p = shell.system.dews.findDeliveryByDateAndHour(date, hour);
            System.out.println("<-------------------/" + "\\------------------------->");
            System.out.println("Num :: " + p.getPackageDelivered().getSecretNumber());
            System.out.println("Poids :: " + p.getPackageDelivered().getWeight());
            System.out.println("Transporteur :: " + p.getPackageDelivered().getProvider().getName());
            System.out.println("Date d'enregistrement :: " + p.getPackageDelivered().getRegisterDate());
            System.out.println("Date de Livraison :: " + p.getDeliveryDate());
//            System.out.println("Drone chargé de la livraison :: " + p.getDrone().getDroneId());
            System.out.println("<-------------------/" + "\\------------------------->");
        } catch (Exception_Exception e) {
            System.out.println("Cette livraison n'a pas  été enregistré !");
        }
    }

    @Override
    public String describe() {
        return "-----> Rechercher une livraison par date et heure";
    }

}
