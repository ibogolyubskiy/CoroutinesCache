package io.coroutines.cache.dao

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.Date
import java.util.Calendar

open class Cache constructor(): RealmObject(){

    @PrimaryKey
    var id:String = ""
    var data:String = ""
    var date: Date = Calendar.getInstance().time

    constructor(id:String, data:String, date: Date) :this(){
        this.id = id
        this.data = data
        this.date = date
    }
}