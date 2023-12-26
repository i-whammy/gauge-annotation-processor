package dev.iwhammy.output

/**
 * Interface for output of annotation values.
 *
 * @since 0.1.0
 */
interface OutputPort {
    /**
     * @param annotations List of annotation values
     * @return Unit
     */
    fun output(annotations: List<Array<String>>): Unit
}