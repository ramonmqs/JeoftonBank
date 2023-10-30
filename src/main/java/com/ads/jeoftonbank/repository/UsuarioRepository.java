package com.ads.jeoftonbank.repository;

import com.ads.jeoftonbank.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
