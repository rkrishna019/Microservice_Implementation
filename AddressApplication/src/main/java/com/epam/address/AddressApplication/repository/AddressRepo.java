package com.epam.address.AddressApplication.repository;

import com.epam.address.AddressApplication.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address,Integer> {

  //  @Query(nativeQuery = true, value = "SELECT ea.id, ea.lane1,ea.lane2,ea.state,ea.zip FROM radha.address ea join radha.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId;")
  @Query(nativeQuery = true, value = "SELECT ea.id, ea.lane1,ea.lane2,ea.state,ea.zip FROM radha.address ea JOIN radha.employee e ON e.id = ea.employee_id WHERE ea.employee_id=:employeeId;")
    Address findAddressByEmplyeeId(@Param("employeeId") int employeeId);
}
