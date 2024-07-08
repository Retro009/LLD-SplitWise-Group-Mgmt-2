package com.example.splitwise.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.splitwise.models.GroupAdmin;

import java.util.Optional;
import java.util.List;

@Repository
public interface GroupAdminRepository extends JpaRepository<GroupAdmin, Long> {
    List<GroupAdmin> findAllByGroupId(Long groupId);
    Optional<GroupAdmin> findByGroupIdAndAdminId(Long groupId, Long admin);

}
