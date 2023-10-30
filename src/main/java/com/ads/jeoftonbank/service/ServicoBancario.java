package com.ads.jeoftonbank.service;

import com.ads.jeoftonbank.models.Compra;
import com.ads.jeoftonbank.models.Usuario;
import com.ads.jeoftonbank.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoBancario {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario verificarSaldo(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    public String aprovarCompra(Compra compra) {
        Usuario usuario = verificarSaldo(compra.getUsuarioId());
        if (usuario != null && usuario.getSaldo() >= compra.getValor()) {
            usuario.setSaldo(usuario.getSaldo() - compra.getValor());
            usuarioRepository.save(usuario);
            return "Compra aprovada";
        } else {
            return "Compra negada, saldo insuficiente";
        }
    }

    public String depositar(Long usuarioId, double valor) {
        Usuario usuario = verificarSaldo(usuarioId);
        if (usuario != null) {
            usuario.setSaldo(usuario.getSaldo() + valor);
            usuarioRepository.save(usuario);
            return "Depósito realizado com sucesso";
        } else {
            return "Usuário não encontrado";
        }
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setAtivo(true);
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .filter(Usuario::isAtivo)
                .collect(Collectors.toList());
    }

    public Usuario inativarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null){
            usuario.setAtivo(false);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }

    public Usuario alterarStatusUsuario(Long id, Boolean novoStatus) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setAtivo(novoStatus);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }

}
