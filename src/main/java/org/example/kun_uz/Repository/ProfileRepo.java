package org.example.kun_uz.Repository;

import org.example.kun_uz.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {
    Integer id(Integer id);
}
