package leaderscodes.tn.volunteering.entity;

import java.io.Serializable;

public class Action implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private String address;
    private String dateStart;
    private String dateEnd;
    private Integer nbreVol;

    public Action() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getNbreVol() {
        return nbreVol;
    }

    public void setNbreVol(Integer nbreVol) {
        this.nbreVol = nbreVol;
    }
}
