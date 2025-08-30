package com.example.mycard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etCardNumber: TextInputEditText
    private lateinit var etCardName: TextInputEditText
    private lateinit var etExpiry: TextInputEditText
    private lateinit var etCvv: TextInputEditText
    private lateinit var btnAddCard: MaterialButton
    private lateinit var tilCardNumber: TextInputLayout
    private lateinit var tilCardName: TextInputLayout
    private lateinit var tilExpiry: TextInputLayout
    private lateinit var tilCvv: TextInputLayout

    // Views do cartão visual
    private lateinit var tvCardNumberDisplay: TextView
    private lateinit var tvCardNameDisplay: TextView
    private lateinit var tvCardExpiryDisplay: TextView
    private lateinit var tvCardBrand: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupTextWatchers()
        setupValidation()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews() {
        etCardNumber = findViewById(R.id.etCardNumber)
        etCardName = findViewById(R.id.etCardName)
        etExpiry = findViewById(R.id.etExpiry)
        etCvv = findViewById(R.id.etCvv)
        btnAddCard = findViewById(R.id.btnAddCard)

        tilCardNumber = findViewById(R.id.tilCardNumber)
        tilCardName = findViewById(R.id.tilCardName)
        tilExpiry = findViewById(R.id.tilExpiry)
        tilCvv = findViewById(R.id.tilCvv)

        tvCardNumberDisplay = findViewById(R.id.tvCardNumberDisplay)
        tvCardNameDisplay = findViewById(R.id.tvCardNameDisplay)
        tvCardExpiryDisplay = findViewById(R.id.tvCardExpiryDisplay)
        tvCardBrand = findViewById(R.id.tvCardBrand)
    }

    private fun setupTextWatchers() {
        // TextWatcher para número do cartão
        etCardNumber.addTextChangedListener(object : TextWatcher {
            private var isEditing = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isEditing) return
                isEditing = true

                val unformatted = s.toString().replace(" ", "")
                val formatted = formatCardNumber(unformatted)

                if (s.toString() != formatted) {
                    etCardNumber.setText(formatted)
                    etCardNumber.setSelection(formatted.length)
                }

                // Atualizar display do cartão
                if (unformatted.isNotEmpty()) {
                    val displayNumber = unformatted.padEnd(16, '•')
                    tvCardNumberDisplay.text = formatCardNumber(displayNumber)

                    // Determinar bandeira do cartão
                    updateCardBrand(unformatted)
                } else {
                    tvCardNumberDisplay.text = "•••• •••• •••• ••••"
                    tvCardBrand.text = ""
                }

                isEditing = false
            }
        })

        // TextWatcher para data de validade
        etExpiry.addTextChangedListener(object : TextWatcher {
            private var isEditing = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isEditing) return
                isEditing = true

                val unformatted = s.toString().replace("/", "")
                val formatted = formatExpiry(unformatted)

                if (s.toString() != formatted) {
                    etExpiry.setText(formatted)
                    etExpiry.setSelection(formatted.length)
                }

                // Atualizar display do cartão
                if (formatted.isNotEmpty()) {
                    tvCardExpiryDisplay.text = formatted
                } else {
                    tvCardExpiryDisplay.text = "MM/AA"
                }

                isEditing = false
            }
        })

        // TextWatcher para nome do titular
        etCardName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val name = s.toString().uppercase().trim()
                if (name.isNotEmpty()) {
                    tvCardNameDisplay.text = name
                } else {
                    tvCardNameDisplay.text = "NOME DO TITULAR"
                }
            }
        })
    }

    private fun setupValidation() {
        btnAddCard.setOnClickListener {
            if (validateAllFields()) {
                Toast.makeText(this, "Cartão adicionado com sucesso!", Toast.LENGTH_SHORT).show()
                clearFields()
            }
        }
    }

    private fun formatCardNumber(number: String): String {
        val digits = number.take(16)
        return digits.chunked(4).joinToString(" ")
    }

    private fun formatExpiry(expiry: String): String {
        return when (expiry.length) {
            0 -> ""
            1 -> expiry
            2 -> expiry
            else -> "${expiry.substring(0, 2)}/${expiry.substring(2, minOf(4, expiry.length))}"
        }
    }

    private fun updateCardBrand(cardNumber: String) {
        when {
            cardNumber.startsWith("4") -> tvCardBrand.text = "VISA"
            cardNumber.startsWith("5") || cardNumber.startsWith("2") -> tvCardBrand.text = "MASTERCARD"
            cardNumber.startsWith("3") -> tvCardBrand.text = "AMEX"
            else -> tvCardBrand.text = ""
        }
    }

    private fun validateAllFields(): Boolean {
        var isValid = true

        // Validar número do cartão
        val cardNumber = etCardNumber.text.toString().replace(" ", "")
        if (cardNumber.length != 16 || !cardNumber.all { it.isDigit() }) {
            tilCardNumber.error = "Número do cartão deve ter 16 dígitos"
            isValid = false
        } else {
            tilCardNumber.error = null
        }

        // Validar nome do titular
        val cardName = etCardName.text.toString().trim()
        if (cardName.length < 3) {
            tilCardName.error = "Nome deve ter pelo menos 3 caracteres"
            isValid = false
        } else {
            tilCardName.error = null
        }

        // Validar data de validade
        val expiry = etExpiry.text.toString()
        if (!isValidExpiryDate(expiry)) {
            tilExpiry.error = "Data inválida ou cartão vencido"
            isValid = false
        } else {
            tilExpiry.error = null
        }

        // Validar CVV
        val cvv = etCvv.text.toString()
        if (cvv.length < 3 || cvv.length > 4 || !cvv.all { it.isDigit() }) {
            tilCvv.error = "CVV deve ter 3 ou 4 dígitos"
            isValid = false
        } else {
            tilCvv.error = null
        }

        return isValid
    }

    private fun isValidExpiryDate(expiry: String): Boolean {
        if (expiry.length != 5 || !expiry.contains("/")) {
            return false
        }

        try {
            val parts = expiry.split("/")
            val month = parts[0].toInt()
            val year = parts[1].toInt()

            // Validar mês (1-12)
            if (month < 1 || month > 12) {
                return false
            }

            // Validar ano (não pode ser menor que o atual)
            val currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100
            val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1

            return when {
                year > currentYear -> true
                year == currentYear -> month >= currentMonth
                else -> false
            }

        } catch (e: NumberFormatException) {
            return false
        }
    }

    private fun clearFields() {
        etCardNumber.text?.clear()
        etCardName.text?.clear()
        etExpiry.text?.clear()
        etCvv.text?.clear()

        // Resetar displays do cartão
        tvCardNumberDisplay.text = "•••• •••• •••• ••••"
        tvCardNameDisplay.text = "NOME DO TITULAR"
        tvCardExpiryDisplay.text = "MM/AA"
        tvCardBrand.text = ""
    }
}