package dev.iwhammy.output

class StandardOutDriver: OutputPort {
    override fun output(annotations: List<Array<String>>) {
        annotations.forEach { gaugeSteps ->
            gaugeSteps.forEach { println(it) }
        }
    }
}