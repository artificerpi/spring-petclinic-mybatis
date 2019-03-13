package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Owner;

@Mapper
public interface OwnerMapper {

  Collection<Owner> findByLastName(String lastName) throws DataAccessException;
  
  @Select("SELECT * FROM owners WHERE id = #{id}")
  @Results({
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
  })
  Owner findById(int id) throws DataAccessException;
  
  void save(Owner owner) throws DataAccessException;
  
  @Select("SELECT * FROM owners")
  @Results({
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
  })
  Collection<Owner> findAll() throws DataAccessException;
  
  @Delete("DELETE FROM owners WHERE id = #{id}")
  void delete(Owner owner) throws DataAccessException;
  
}