package com.texasparking.vagas.service

import com.texasparking.vagas.model.Vaga
import com.texasparking.vagas.repository.VagaRepository
import org.springframework.stereotype.Service

@Service
class VagaService(private val repository: VagaRepository) {

    fun listarVagas(): List<Vaga> = repository.findAll()

    fun buscarPorId(id: Long): Vaga = repository.findById(id).orElseThrow {
        NoSuchFieldException("Vaga não encontrada com o ID: $id")
    }

    fun criarVaga(vaga: Vaga): Vaga = repository.save(vaga)

    fun atualizarVaga(id: Long, vagaAtualizada: Vaga): Vaga {
        val vaga = buscarPorId(id)
        vaga.identificador = vagaAtualizada.identificador
        vaga.status = vagaAtualizada.status
        return repository.save(vaga)
    }

    fun deletarVaga(id: Long){
        if (repository.existsById(id)){
            repository.deleteById(id)
        } else {
            throw NoSuchElementException("Vaga não encontrada com o ID: $id")
        }
    }

}