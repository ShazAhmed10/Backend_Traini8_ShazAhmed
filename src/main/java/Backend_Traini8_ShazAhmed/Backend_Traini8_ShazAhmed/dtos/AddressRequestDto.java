package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos;

import jakarta.validation.constraints.NotBlank;

public class AddressRequestDto {
    @NotBlank(message = "detailedAddress is required and cannot be blank")
    private String detailedAddress;

    @NotBlank(message = "city is required and cannot be blank")
    private String city;

    @NotBlank(message = "state is required and cannot be blank")
    private String state;

    @NotBlank(message = "pinCode is required and cannot be blank")
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
