package com.texasparking.vagas.model

import jakarta.persistence.*

@Entity
data class Vaga (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var identificador: String,
    var status: String // Ex.: Disponível para aluguel, Disponível para empréstimo, Alugada

)