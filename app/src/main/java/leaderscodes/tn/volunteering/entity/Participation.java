package leaderscodes.tn.volunteering.entity;


public class Participation {
    private Integer id_vol;
    private Integer id_action;

    public Participation(Integer id_vol, Integer id_action) {
        this.id_vol = id_vol;
        this.id_action = id_action;
    }

    public Integer getId_vol() {
        return id_vol;
    }

    public void setId_vol(Integer id_vol) {
        this.id_vol = id_vol;
    }

    public Integer getId_action() {
        return id_action;
    }

    public void setId_action(Integer id_action) {
        this.id_action = id_action;
    }
}
