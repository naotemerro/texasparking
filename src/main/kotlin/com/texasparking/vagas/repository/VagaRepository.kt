package com.texasparking.vagas.repository

import com.texasparking.vagas.model.Vaga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface vagaRepository : JpaRepository<Vaga, Long>