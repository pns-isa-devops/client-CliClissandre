package cli.commands;
import api.DDPublicAPI;
import cli.framework.Command;


import java.util.List;

public class DeleteAllProvider extends Command<DDPublicAPI> {


    @Override
    public String identifier() {
        return "deleteP";
    }

    @Override
    public void load(List<String> args) {
    }

    @Override
    public void execute(){
        Boolean rep = shell.system.pws.deleteAll();
        System.out.println("Delete ===> "+rep);
    }

    @Override
    public String describe() {
        return "-----> Supprimer tous les transporteurs";
    }

}
