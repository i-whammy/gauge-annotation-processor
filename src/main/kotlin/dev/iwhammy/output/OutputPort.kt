package dev.iwhammy.output

interface OutputPort {
    fun output(annotations: List<Array<String>>): Unit
}