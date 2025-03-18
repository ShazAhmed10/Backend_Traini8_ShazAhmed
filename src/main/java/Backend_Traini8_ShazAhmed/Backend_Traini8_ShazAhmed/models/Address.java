package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models;

import jakarta.persistence.Entity;

@Entity
public class Address extends BaseModel{
    private String detailedAddress;

    private String city;

    private String state;

    private String pinCode;


    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}

