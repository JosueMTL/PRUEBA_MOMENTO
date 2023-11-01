package com.example.tarea.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "assistant")
class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "full_name")
    var fullName: String? = null

    @Column(name = "rols")
    var rols: String? = null

    @Column(name = "age")
    var age: Int? = null

    @ManyToOne
    @JoinColumn(name = "conference_id")
    var conference: Conference? = null

}
