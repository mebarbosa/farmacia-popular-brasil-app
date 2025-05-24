package com.buscar.farmaciapopular.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buscar.farmaciapopular.data.model.Pharmacy
import com.buscar.farmaciapopular.viewmodel.PharmaciesAndroidViewModel
import com.buscar.farmaciapopular.viewmodel.PharmaciesUiState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PharmaciesScreen(viewModel: PharmaciesAndroidViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPharmacies()
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (uiState is PharmaciesUiState.Loading) {
            CircularProgressIndicator()
            Text("Loading pharmacies...")
        } else if (uiState is PharmaciesUiState.Success) {
            val pharmacies = (uiState as PharmaciesUiState.Success).pharmacies
            if (pharmacies.isEmpty()) {
                Text("No pharmacies found.")
            } else {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(pharmacies, key = { it.cnpj }) { pharmacy ->
                        PharmacyListItem(pharmacy)
                    }
                }
            }
        } else if (uiState is PharmaciesUiState.Error) {
            Text(
                "Error: ${(uiState as PharmaciesUiState.Error).message}",
                color = MaterialTheme.colorScheme.error
            )
        } else if (uiState is PharmaciesUiState.Empty) {
            Text("No pharmacies found for your search criteria.")
        }
    }
}

@Composable
fun PharmacyListItem(pharmacy: Pharmacy) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(pharmacy.farmacia, style = MaterialTheme.typography.titleMedium)
        Text(pharmacy.endereco, style = MaterialTheme.typography.bodySmall)
        Text("${pharmacy.bairro}, ${pharmacy.municipio} - ${pharmacy.uf}", style = MaterialTheme.typography.bodySmall)
    }
}