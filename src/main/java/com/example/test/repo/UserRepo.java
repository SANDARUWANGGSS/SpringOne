package com.example.test.repo;

import com.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer>
{
    @Query(value = "SELECT * FROM USER WHERE id=?1",nativeQuery = true)
    User getUserByID(String id);

    @Query(value = "SELECT * FROM USER WHERE id=?1 AND address=?2",nativeQuery = true)
    User getUserByIDAndAddress(String id,String address);
}
