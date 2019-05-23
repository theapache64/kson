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
