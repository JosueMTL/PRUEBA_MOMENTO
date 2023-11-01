package com.example.tarea.service

import com.example.tarea.model.Assistant
import com.example.tarea.repository.AssistantRepository
import com.example.tarea.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*
@Service
class AssistantService {
    @Autowired
    lateinit var assistantRepository: AssistantRepository

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list(): List<Assistant> {
        return assistantRepository.findAll()
    }

    fun listOne(id: Long): Optional<Assistant> {
        return assistantRepository.findById(id)
    }

    // PETICIONES POST
    fun save(modelo: Assistant): Assistant {
        try {
            conferenceRepository.findById(modelo.conference?.id) // Usar "modelo.authorId" en lugar de "modelo.clientId"
                ?: throw Exception("Id del autor no encontrado")
            return assistantRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message)
        }
    }

    // clase service -Petición put
    fun update(modelo: Assistant): Assistant {
        try {
            assistantRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return assistantRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    // clase service - Delete by id
    fun delete(id: Long?): Boolean? {
        try {
            val response = assistantRepository.findById(id)
                ?: throw Exception("ID no existe")
            assistantRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}