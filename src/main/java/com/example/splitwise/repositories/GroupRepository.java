package com.example.splitwise.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.splitwise.models.Group;

import java.util.Optional;
import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
}
