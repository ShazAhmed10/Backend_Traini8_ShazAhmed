package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos;

import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Address;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Course;

import java.util.List;


public class CenterResponseDto {
    private String centerName;
    private String centerCode;
    private Address address;
    private long studentCapacity;
    private List<Course> coursesOffered;
    private long createdOn;
    private String contactEmail;
    private String contactPhone;


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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(long studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<Course> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<Course> coursesOffered) {
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
