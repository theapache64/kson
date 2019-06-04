package com.theapache64.kson

import java.io.File
import java.lang.IllegalArgumentException
import java.util.regex.Pattern

class Kson(
    private val kotlinFile: File
) {

    companion object {
        val CLASS_NAME_REGEX = Pattern.compile("class (\\w+)")
        val PACKAGE_NAME_REGEX = Pattern.compile("package (.+)")
        val IMPORT_REGEX = Pattern.compile("import (.+)")
        val PARENT_CLASS_NAME_REGEX = Pattern.compile("class .+:\\s*(\\w+)")
    }

    init {
        require(kotlinFile.extension == "kt") { "${kotlinFile.name} is not a kotlin file" }
    }


    /**
     * To get class name
     */
    var className: String?
        get() {
            return parseSingle(CLASS_NAME_REGEX)
        }
        set(value) {
            setClassNameFrom(value)
        }

    private fun setClassNameFrom(className: String?) {

    }


    /**
     * To get package name
     */
    val packageName: String?
        get() {
            return parseSingle(PACKAGE_NAME_REGEX)
        }


    /**
     * To get imported packages
     */
    val imports: List<String>
        get() {
            return parseMultiple(IMPORT_REGEX)
        }

    /**
     * To get parent class name
     */
    val parentClassName: String?
        get() {
            return parseSingle(PARENT_CLASS_NAME_REGEX)
        }

    /**
     * To get memeber variables
     */
    val memVars: List<Variable>
        get() {
            TODO("Not implemented. Dot it using reflection and also try to tranfer other params to reflection also.")
            return mutableListOf()
        }

    private fun parseMultiple(pattern: Pattern): ArrayList<String> {
        val fileContents = kotlinFile.readText()
        val matcher = pattern.matcher(fileContents)
        val arr = arrayListOf<String>()
        while (matcher.find()) {
            arr.add(matcher.group(1))
        }
        return arr
    }


    /**
     * To parse with given pattern from kotlinFile
     */
    private fun parseSingle(pattern: Pattern): String? {
        val fileContents = kotlinFile.readText()
        val matcher = pattern.matcher(fileContents)
        if (matcher.find()) {
            return matcher.group(1)
        }
        return null
    }

}