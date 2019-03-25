
package LabProject;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Transactional
@EnableJpaRepositories
public interface PlaneRepository extends JpaRepository<PlaneEntity, String> 
{
    List<PlaneEntity> findByIcao24(String icao24);
}
