package compulsoryPackage.repositoryPack;

import org.springframework.data.jpa.repository.JpaRepository;
import compulsoryPackage.entityPack.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
