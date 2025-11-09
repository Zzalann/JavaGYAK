// repo/MessageRepo.java
package com.example.f1.repo;
import com.example.f1.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findAllByOrderByCreatedAtDesc();
}
