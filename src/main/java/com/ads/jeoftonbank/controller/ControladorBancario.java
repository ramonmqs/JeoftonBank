package com.ads.jeoftonbank.controller;

import com.ads.jeoftonbank.models.Compra;
import com.ads.jeoftonbank.models.Usuario;
import com.ads.jeoftonbank.service.ServicoBancario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControladorBancario {
    @Autowired
    private ServicoBancario servicoBancario;

    @PostMapping("/compra")
    public String realizarCompra(@RequestBody Compra compra) {
        return servicoBancario.aprovarCompra(compra);
    }

    @PostMapping("/depositar")
    public String depositar(@RequestParam Long usuarioId, @RequestParam double valor) {
        return servicoBancario.depositar(usuarioId, valor);
    }

    @GetMapping("/saldo")
    public Usuario verificarSaldo(@RequestParam Long usuarioId) {
        return servicoBancario.verificarSaldo(usuarioId);
    }
}
