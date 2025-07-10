import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotest)
    alias(libs.plugins.ksp)

}

kotlin {
    jvm()
    macosArm64()
    macosX64()
    tvosArm64()
    tvosX64()
    tvosSimulatorArm64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    watchosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    tvosSimulatorArm64()
    tvosX64()
    tvosArm64()
    androidNativeX64()
    androidNativeX86()
    androidNativeArm32()
    androidNativeArm64()

    listOf(
        js(IR).apply { browser { testTask { enabled = false } } },
        @OptIn(ExperimentalWasmDsl::class)
        wasmJs().apply { browser { testTask { enabled = false } } }
    ).forEach {
        it.nodejs()
    }

    linuxX64()
    linuxArm64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotest.framework.engine)
        }

        jvmTest.dependencies {
            implementation(libs.kotest.runner.junit)
        }
    }
    
    dependencies {
            tasks.withType<AbstractTestTask> {
                runCatching {
                add("ksp${name.replaceFirstChar { it.uppercase() }}", libs.kotest.framework.symbol.processor)
                }.getOrElse { logger.warn(it.message, it) }
            }
        }

}