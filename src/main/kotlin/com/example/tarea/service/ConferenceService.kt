package com.example.tarea.service

import com.example.tarea.repository.ConferenceRepository
import com.example.tarea.model.Conference
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list (): List<Conference> {
        return conferenceRepository.findAll()
    }

    fun listOne (id: Long): Optional<Conference> {
        return conferenceRepository.findById(id)
    }

    // PETICIONES POST
    fun save(modelo: Conference): Conference {
        try {
            // Realiza validaciones y lógica adicional si es necesario

            return conferenceRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    // Petición PUT
    fun update(modelo: Conference): Conference {
        try {
            val existingConference = conferenceRepository.findById(modelo.id)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID no existe")

            // Realiza validaciones y lógica de actualización

            return conferenceRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.message)
        }
    }

    // Delete by ID
    fun delete(id: Long): Boolean {
        try {
            val existingConference = conferenceRepository.findById(id)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID no existe")

            conferenceRepository.deleteById(id)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.message)
        }
    }
}
