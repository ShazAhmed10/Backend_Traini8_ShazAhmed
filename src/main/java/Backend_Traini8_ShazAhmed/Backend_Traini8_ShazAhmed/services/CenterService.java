package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.services;

import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos.AddressRequestDto;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos.CenterRequestDto;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos.CenterResponseDto;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Address;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Center;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Course;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.repositories.AddressRepository;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.repositories.CenterRepository;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CenterService {
    private final CenterRepository centerRepository;
    private final AddressRepository addressRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CenterService(CenterRepository centerRepository,
                         AddressRepository addressRepository,
                         CourseRepository courseRepository){
        this.centerRepository = centerRepository;
        this.addressRepository = addressRepository;
        this.courseRepository = courseRepository;
    }

    //method to convert from Center object to responseDto object
    public CenterResponseDto convertCenterToCenterResponseDto(Center center){
        CenterResponseDto responseDto = new CenterResponseDto();

        responseDto.setCenterName(center.getCenterName());
        responseDto.setCenterCode(center.getCenterCode());
        responseDto.setAddress(center.getAddress());
        responseDto.setStudentCapacity(center.getStudentCapacity());
        responseDto.setCoursesOffered(center.getCoursesOffered());
        responseDto.setCreatedOn(center.getCreatedOn());
        responseDto.setContactEmail(center.getContactEmail());
        responseDto.setContactPhone(center.getContactPhone());

        return responseDto;
    }

    //method to create and add new Center
    public CenterResponseDto createCenter(CenterRequestDto requestDto){
        //persisting new Address in address table in DB
        Address address = new Address();

        AddressRequestDto addressRequestDto = requestDto.getAddress();
        address.setDetailedAddress(addressRequestDto.getDetailedAddress());
        address.setCity(addressRequestDto.getCity());
        address.setState(addressRequestDto.getState());
        address.setPinCode(addressRequestDto.getPinCode());

        Address savedAddress = addressRepository.save(address);

        //checking if the Courses already exist
        //and if not then persisting new Courses in course table in DB
        List<Course> savedCoursesList = new ArrayList<>();

        for(String courseName : requestDto.getCoursesOffered()){
            Optional<Course> optionalCourse = courseRepository.findByName(courseName);
            if(optionalCourse.isEmpty()){
                Course course = new Course();
                course.setName(courseName);
                courseRepository.save(course);
                savedCoursesList.add(course);
            }
            else{
                savedCoursesList.add(optionalCourse.get());
            }
        }

        //checking if the Center already exists
        //and if not then persisting new Center in center table in DB
        Optional<Center> optionalCenter = centerRepository.findByCenterName(requestDto.getCenterName());
        Center center;

        if(optionalCenter.isEmpty()){
            center = new Center();

            center.setCenterName(requestDto.getCenterName());
            center.setCenterCode(requestDto.getCenterCode());
            center.setAddress(savedAddress);
            center.setStudentCapacity(requestDto.getStudentCapacity());
            center.setCoursesOffered(savedCoursesList);
            center.setCreatedOn(requestDto.getCreatedOn());
            center.setContactEmail(requestDto.getContactEmail());
            center.setContactPhone(requestDto.getContactPhone());

            return convertCenterToCenterResponseDto(centerRepository.save(center));
        }

        return convertCenterToCenterResponseDto(optionalCenter.get());
    }

    //method to get all Centers which are currently existing in the database.
    //Also, with the functionality of filtering the result set on the basis of few parameters.
    public List<CenterResponseDto> findAllCenters(String centerName,
                                                  Long studentCapacity,
                                                  List<String> courses,
                                                  String state){
        List<CenterResponseDto> centerResponseDtoList = new ArrayList<>();
        List<Center> centerList;

        if(centerName == null && studentCapacity == null && courses == null && state == null){
            centerList = centerRepository.findAll();
        }
        else{
            centerList = new ArrayList<>();
            String coursesString = null;
            if(courses != null){
                coursesString = String.join(",", courses);
            }
            Optional<List<Center>> optionalCenterList = centerRepository
                    .findByFilters(centerName, studentCapacity, coursesString, state);
            if(optionalCenterList.isPresent()){
                centerList = optionalCenterList.get();
            }
        }

        for(Center center : centerList){
            centerResponseDtoList.add(convertCenterToCenterResponseDto(center));
        }

        return centerResponseDtoList;
    }
}
