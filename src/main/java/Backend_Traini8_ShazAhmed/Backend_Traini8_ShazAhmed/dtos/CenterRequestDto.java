package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos;

import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

public class CenterRequestDto {
    @NotBlank(message = "centerName is required and cannot be blank")
    @Size(max = 40, message = "should be less than 40 characters")
    private String centerName;

    @NotBlank(message = "centerCode is required and cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "should be exactly 12 character alphanumeric")
    private String centerCode;

    @NotNull(message = "Address is required")
    @Valid
    private AddressRequestDto address;

    private long studentCapacity;

    private List<String> coursesOffered;

    private long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "contactPhone is required and cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "phone number must be 10 digits")
    private String contactPhone;


    public CenterRequestDto(){
        this.createdOn = Instant.now().getEpochSecond();
    }


    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public AddressRequestDto getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDto address) {
        this.address = address;
    }

    public long getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(long studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
