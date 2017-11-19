package com.tallrocket.trial.main

import java.io.Serializable

/**
 * Created by user on 11/15/17.
 */

class Employee:Serializable {
    var id: Int = 0
    var imageId: Int = 0

    var name: String?=null
    var designation: String?=null
}
