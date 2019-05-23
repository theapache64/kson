package com.theapache64.kson

import java.io.File

fun main() {

    // delete lab folder
    val dirLab = File("lab")
    dirLab.deleteRecursively()

    // create lab folder
    dirLab.mkdir()

    // copy file from assets to lab
    val sampleFile = File("assets/PlayerActivity.kt")
    val kotlinFile = File("lab/PlayerActivity.kt")
    sampleFile.copyTo(kotlinFile, true)


    // Samples
    val kson = Kson(kotlinFile)

    // Parsing
    val className = kson.className // MyClass.kt
    println("Class name is $className")

    val packageName = kson.packageName // com.company.lyrix.ui.activities.player
    println("Package name is $packageName")

    val imports = kson.imports // String[] of import statements
    println("Imports are : $imports")
    
    // val parentClass = kson.parentClass // BaseAppCompatActivity
    // val memberVars = kson.memberVars // MemVariable[] of class member variables
    //val memberMethod = kson.memberMeths // MemMethods[] of class member methods

    // Modification

    // Change package name
    // kson.packageName = "new.package.name"

    // Adding imports
    //kson.addImport("my.new.library.class")

    // Remove import
    //kson.removeImport("javax.inject.Inject")

    // Update import
    //kson.updateImport("my.new.library.class", "com.company.library.class")

    // Changing parent class
    //kson.parentClass = "AppCompatActivity"

    // Adding member variable
    //kson.addMemberVar("val car = Car()")
}