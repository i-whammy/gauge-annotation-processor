package dev.iwhammy

import com.thoughtworks.gauge.Step
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedAnnotationTypes("com.thoughtworks.gauge.Step")
class GaugeAnnotationProcessor: AbstractProcessor() {
    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        processingEnv.messager.printMessage(Diagnostic.Kind.NOTE, "now processing begins")
        val collections = annotations
            .flatMap(roundEnv::getElementsAnnotatedWith)
            .map { element -> element.getAnnotation(Step::class.java).value }
        collections.forEach { collection ->
            collection.forEach { message ->
                println(message)
            }
        }
        return true
    }
}