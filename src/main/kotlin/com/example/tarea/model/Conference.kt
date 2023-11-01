package com.example.tarea.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "conference")
class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "city")
    var city: String? = null

    @Column(name = "total_assistants")
    var totalAssistants: Int? = null
}
