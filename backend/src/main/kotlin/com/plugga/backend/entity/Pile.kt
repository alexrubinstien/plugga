package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.plugga.backend.jackson.EntityIdResolver
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "pile")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator::class,
    property = "id",
    resolver = EntityIdResolver::class,
    scope = Pile::class
)
class Pile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pile_id")
    var id: Int = 0

    @ManyToOne
    @JoinColumn(name = "deck_id", referencedColumnName = "deck_id")
    @JsonIdentityReference(alwaysAsId = true)
    var deck: Deck? = null

    @Column(name = "`rank`")
    var rank: Byte = 0

    @Column(name = "freq")
    var freqInMinutes: Int = 0

    constructor() {}

    constructor(id: Int) {
        this.id = id
    }

    constructor(deck: Deck, rank: Byte, freq: Int) {
        this.deck = deck
        this.rank = rank
        this.freqInMinutes = freq
    }

    override fun toString(): String {
        return "Pile{" +
            "id=" + id +
            ", rank=" + rank +
            ", freqInMinutes=" + freqInMinutes +
            '}'.toString()
    }
}
