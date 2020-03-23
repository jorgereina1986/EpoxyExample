package com.jorgereina.epoxyexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var entries = mutableListOf<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_activity_ok_btn.setOnClickListener {
            val input = main_activity_input_names.text.toString()

            if (!input.isBlank()) {
                entries.add(Entry(input))

                main_activity_raffle_rv.withModels {
                    entries.forEach {
                        entry {
                            id(hashCode())
                            name(it.name)
                        }
                    }
                }
                main_activity_input_names.text.clear()
            }
        }
    }
}
