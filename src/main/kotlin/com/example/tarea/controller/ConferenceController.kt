package com.example.tarea.controller

import com.example.tarea.service.ConferenceService
import com.example.tarea.model.Conference
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
@RestController
@RequestMapping("/conference")
class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService
    @GetMapping
    fun list ():List <Conference>{
        return conferenceService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Conference> {
        return conferenceService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody modelo: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.save(modelo), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody modelo: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(modelo), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody modelo: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(modelo), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return conferenceService.delete(id)
    }
}