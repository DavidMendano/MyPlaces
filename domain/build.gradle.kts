import com.dmendanyo.myplaces.Libs

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(Libs.Kotlin.Coroutines.core)
    implementation(Libs.JavaX.javax)
}
