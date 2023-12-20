package dev.iwhammy

import com.thoughtworks.gauge.Step
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedAnnotationTypes("com.thoughtworks.gauge.Step")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
class GaugeAnnotationProcessor: AbstractProcessor() {
    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val collections = annotations
            .flatMap(roundEnv::getElementsAnnotatedWith)
            .map { element -> element.getAnnotation(Step::class.java).value }
        collections.forEach { gaugeSteps ->
            gaugeSteps.forEach { println(it) }
        }
        return true
    }
}