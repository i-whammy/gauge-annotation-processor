# gauge-annotation-processor
Annotation processor for collecting [gauge](https://gauge.org/) steps.

## Prerequisites
- Java 21
- Kotlin 1.9
- Apache Maven 3.9.6
- gauge 1.5.6

## How to use
- Add following in your pom.xml
```xml
    <profiles>
        <profile>
            <id>annotation-processing</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.jetbrains.kotlin</groupId>
                        <artifactId>kotlin-maven-plugin</artifactId>
                        <extensions>true</extensions>
                        <configuration>
                            <annotationProcessorPaths>
                                <annotationProcessorPath>
                                    <groupId>dev.i-whammy</groupId>
                                    <artifactId>gauge-annotation-processor</artifactId>
                                    <version>0.1.0</version>
                                </annotationProcessorPath>
                            </annotationProcessorPaths>
                            <annotationProcessors>
                                <annotationProcessor>dev.iwhammy.GaugeAnnotationProcessor</annotationProcessor>
                            </annotationProcessors>
                        </configuration>
                        <executions>
                            <execution>
                                <id>run-annotation-processor</id>
                                <phase>generate-sources</phase>
                                <goals>
                                    <goal>compile</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>
```
- Run following under your project directory.
```shell
$ mvn clean compile -Pannotation-processing
```

## Features
- Listing up values of `@Step` annotations in one project.
- Output into stdout.