package com.conectamayores.seniorconnectapi.repository;

import com.conectamayores.seniorconnectapi.model.Chat;
import com.conectamayores.seniorconnectapi.model.Familiar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {


}
