package dev.iwhammy

import com.thoughtworks.gauge.Step
import dev.iwhammy.output.OutputPort
import dev.iwhammy.output.StandardOutDriver
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedAnnotationTypes("com.thoughtworks.gauge.Step")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
class GaugeAnnotationProcessor(private val outputPort: OutputPort = StandardOutDriver()): AbstractProcessor() {
    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val annotationList = annotations
            .flatMap(roundEnv::getElementsAnnotatedWith)
            .map { element -> element.getAnnotation(Step::class.java).value }
        outputPort.output(annotationList)
        return true
    }
}