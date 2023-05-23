package me.samuelanozie.nubangenerator.repository;

import me.samuelanozie.nubangenerator.model.NubanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NubanRepository extends JpaRepository<NubanModel, Long> {
}
