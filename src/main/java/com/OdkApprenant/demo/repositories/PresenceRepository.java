package com.OdkApprenant.demo.repositories;

import com.OdkApprenant.demo.model.Presence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@Repository
public interface PresenceRepository extends JpaRepository<Presence, Long> {
    List<Presence> getPresenceByDate(LocalDate localdate);
    List<Presence>  getPresenceByDateGreaterThanEqualAndDateLessThanEqual(LocalDate min, LocalDate max);
    //@Query(value = "from presence where date_of_day between : startDate AND: endDate")
    //public List<Presence> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
