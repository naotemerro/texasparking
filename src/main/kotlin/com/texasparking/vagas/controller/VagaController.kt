package com.texasparking.vagas.controller

import com.texasparking.vagas.service.VagaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/vagas")
class VagaController(private val service: VagaService) {

    @GetMapping
    fun listarVagas(): List<Vaga> = service.listarVagas()

    @GetMapping("/{id}")
    fun buscarVaga(@PathVariable id: Long): Vaga = service.buscarPorId(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarVaga(@RequestBody vaga: Vaga): Vaga = service.criarVaga(vaga)

    @PutMapping("/{id}")
    fun atualizarVaga(@PathVariable id: Long, @RequestBody vaga : vaga): vaga = service.atualizarVaga(id, vaga)

    @DeleteMapping("/{id}")
    fun deletarVaga(@PathVariable id: Long) = service.deletarVaga(id)
}