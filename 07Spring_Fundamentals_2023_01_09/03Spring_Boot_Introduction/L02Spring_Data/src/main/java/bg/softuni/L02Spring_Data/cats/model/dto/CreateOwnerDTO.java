package bg.softuni.L02Spring_Data.cats.model.dto;

import java.util.List;

public class CreateOwnerDTO {

    private String ownerName;

    private List<String> catNames;

    public CreateOwnerDTO() {
    }

    public String getOwnerName() {
        return ownerName;
    }

    public CreateOwnerDTO setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public List<String> getCatNames() {
        return catNames;
    }

    public CreateOwnerDTO setCatNames(List<String> catNames) {
        this.catNames = catNames;
        return this;
    }

}