package blasi.nicolo.pcto.bean;

public class Help {

    private int id;
    private String help ;
  
    public Help(int id, String help) {
        this.id = id;
        this.help = help;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }


    @Override
    public String toString() {
        return id + ", " + help;
    }


  
}
