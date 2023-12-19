package dev.iwhammy

import com.thoughtworks.gauge.Step
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.type.ExecutableType
import javax.lang.model.type.TypeMirror

@SupportedAnnotationTypes("com.thoughtworks.gauge.Step")
//@SupportedSourceVersion(SourceVersion.RELEASE_21)
class GaugeAnnotationProcessor: AbstractProcessor() {
    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val collections = annotations
            .flatMap(roundEnv::getElementsAnnotatedWith)
            .map { element -> element.toGaugeSteps() }
        collections.forEach { gaugeStep ->
            println(gaugeStep)
        }
        return true
    }
}

data class GaugeStep(val stepText: String, val types: List<TypeMirror>)

fun Element.toGaugeSteps(): GaugeStep {
    val stepText = this.getAnnotation(Step::class.java).value
    val types = (this.asType() as ExecutableType).parameterTypes
    return GaugeStep(stepText.first(), types)
}