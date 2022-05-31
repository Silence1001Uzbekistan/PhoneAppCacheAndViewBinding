package com.example.phoneappb.Class

import java.io.Serializable

class PhoneClass:Serializable {

    var id: Int? = null
    var phoneName: String? = null
    var features: String? = null

    constructor()

    constructor(id: Int?, phoneName: String?, features: String?) {
        this.id = id
        this.phoneName = phoneName
        this.features = features
    }
}