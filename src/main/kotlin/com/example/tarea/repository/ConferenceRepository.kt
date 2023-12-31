package com.example.tarea.repository

import com.example.tarea.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConferenceRepository : JpaRepository<Conference, Long>{
    fun findById (id: Long?): Conference?
}