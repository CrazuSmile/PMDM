package com.juanjosesanz.signinjuanjosesanz.ui.screens

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(modifier: Modifier) {
    var nameFieldValue by rememberSaveable { mutableStateOf("") }
    var emailFieldValue by rememberSaveable { mutableStateOf("") }
    var firstLastNameFieldValue by rememberSaveable { mutableStateOf("") }
    var secondLastNameFieldValue by rememberSaveable { mutableStateOf("") }
    var phoneFieldValue by rememberSaveable { mutableStateOf("") }
    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = Calendar.getInstance().timeInMillis)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nameFieldValue,
            onValueChange = { nameFieldValue = it },
            label = { Text("Nombre") }
        )

        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = firstLastNameFieldValue,
            onValueChange = { firstLastNameFieldValue = it },
            label = { Text("Primer apellido") }
        )

        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = secondLastNameFieldValue,
            onValueChange = { secondLastNameFieldValue = it },
            label = { Text("Segundo apellido") }
        )

        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = emailFieldValue,
            onValueChange = { emailFieldValue = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
        )

        Spacer(modifier = Modifier.size(8.dp))

        Spacer(modifier = Modifier.size(8.dp))

        DatePicker(
            state = datePickerState,
            modifier = Modifier
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = phoneFieldValue,
            onValueChange = { phoneFieldValue = it },
            label = { Text("Telefono") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )

    }
}