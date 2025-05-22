package com.buscar.farmaciapopular.data.local.repository

import com.buscar.farmaciapopular.data.local.LocalDataSource
import com.buscar.farmaciapopular.data.model.Pharmacy
import com.buscar.farmaciapopular.data.repository.PharmacyRepositoryImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PharmacyRepositoryTest {
    @Test
    fun fetchPharmacies() =
        runTest {
            val mockPharmacies =
                listOf(
                    Pharmacy(
                        uf = "SP",
                        cep = "3550308",
                        municipio = "São Paulo",
                        cnpj = "12.345.678/0001-90",
                        farmacia = "Farmácia Popular A",
                        endereco = "Rua Exemplo, 123",
                        bairro = "Centro",
                        dataCredenciamento = "2021-05-01"
                    ),
                    Pharmacy(
                        uf = "RJ",
                        cep = "3304550",
                        municipio = "Rio de Janeiro",
                        cnpj = "98.765.432/0001-09",
                        farmacia = "Farmácia Popular B",
                        endereco = "Av. Exemplo, 456",
                        bairro = "Zona Sul",
                        dataCredenciamento = "2022-01-15"
                    )
                )
            val fakeDataSource = FakeLocalDataSource(mockPharmacies)
            val repository = PharmacyRepositoryImpl(fakeDataSource)

            val result = repository.getPharmacies()

            assertEquals(mockPharmacies, result)
        }
}

private class FakeLocalDataSource(
    private val pharmacies: List<Pharmacy>
) : LocalDataSource {
    override suspend fun getAllPharmacies(): List<Pharmacy> {
        return pharmacies
    }
}