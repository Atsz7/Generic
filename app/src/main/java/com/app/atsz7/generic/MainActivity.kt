package com.app.atsz7.generic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.app.atsz7.generic.extensions.setVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    /**
     * This method is used to set the listeners of all views.
     */
    private fun setListeners() {

        eTxtInput.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                validate()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        btnToast.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.main_toast_message, eTxtInput.text),
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    /**
     * This method is used to validate the text of [eTxtInput]
     * and show or hide the views.
     */
    private fun validate() {

        val text = eTxtInput.text.toString()
        if (text.isNotBlank()) {

            val number = text.toInt()

            txtError.setVisibility { number <= 25 }
            btnToast.setVisibility(onFalse = View.INVISIBLE) { isValid(number) }
        }
    }

    /**
     * This method is used to validate if [number]
     * is greater than 25.
     * @return [Boolean].
     */
    private fun isValid(number: Int) = number > 25
}
