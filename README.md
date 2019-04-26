# kson
A library to parse and modify Kotlin classes. :construction:

## Usage

**MyClass.kt**
```kotlin
package com.company.lyrix.ui.activities.player

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import com.theapache64.twinkill.utils.extensions.toast
import com.company.lyrix.R
import com.company.lyrix.data.remote.getsongs.GetSongsResponse
import com.company.lyrix.databinding.ActivityPlayerBinding
import javax.inject.Inject

class PlayerActivity : BaseAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    companion object {

        const val KEY_SONG = "song"

        fun getStartIntent(context: Context, song: GetSongsResponse.Song): Intent {
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra(KEY_SONG, song)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}


```

**Kson Demo**

```kotlin
val kotlinFile = File("path/to/MyClass.kt")
val kson = Kson(kotlinFile)

// Parsing
val name = kson.className // MyClass.kt
val packageName = kson.packageName // com.company.lyrix.ui.activities.player
val imports = kson.imports // String[] of import statements
val parentClass = kson.parentClass // BaseAppCompatActivity
val memberVars = kson.memberVars // MemVariable[] of class member variables
val memberMethod = kson.memberMeths // MemMethods[] of class member methods

// Modification

// Change package name
kson.packageName = "new.package.name"

// Adding imports
kson.addImport("my.new.library.class")

// Remove import
kson.removeImport("javax.inject.Inject")

// Update import
kson.updateImport("my.new.library.class", "com.company.library.class")

// Changing parent class
kson.parentClass = "AppCompatActivity"

// Adding member variable
kson.addMemberVar("val car = Car()")


// more coming soon...
```
