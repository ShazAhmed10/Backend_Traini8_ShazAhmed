package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models;

import jakarta.persistence.Entity;

@Entity
public class Course extends BaseModel{
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
