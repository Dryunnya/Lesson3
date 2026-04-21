plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ru.mirea.obmolovav.mireaproject"
    compileSdk = 36

    // ✅ ОБНОВЛЕНО: compileSdk 36 (требуется зависимостями)

    defaultConfig {
        applicationId = "ru.mirea.obmolovav.mireaproject"
        minSdk = 26
        // ✅ targetSdk можно оставить 34 или обновить до 36
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // ✅ View Binding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}