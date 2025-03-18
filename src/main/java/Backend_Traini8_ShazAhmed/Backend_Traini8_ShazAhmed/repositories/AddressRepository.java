package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.repositories;

import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
