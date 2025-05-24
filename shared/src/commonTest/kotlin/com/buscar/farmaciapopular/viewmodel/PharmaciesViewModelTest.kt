package com.buscar.farmaciapopular.viewmodel

import com.buscar.farmaciapopular.data.model.Pharmacy
import com.buscar.farmaciapopular.data.repository.PharmacyRepository
import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class PharmaciesViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: PharmaciesViewModel
    private lateinit var repository: PharmacyRepository

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mock<PharmacyRepository>()
        viewModel = PharmaciesViewModel(repository)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
        viewModel.clear()
    }

    @Test
    fun `should load pharmacy`() =
        runTest {
            val mockPharmacies = listOf(buildPharmacy("Pharmacy A"), buildPharmacy("Pharmacy B"))
            everySuspend { repository.getPharmacies() } returns mockPharmacies

            viewModel.loadPharmacies()
            advanceUntilIdle()

            assertEquals(
                PharmaciesUiState.Success(mockPharmacies),
                viewModel.uiState.value
            )
        }

    @Test
    fun `should return empty pharmacy list`() =
        runTest {
            everySuspend { repository.getPharmacies() } returns emptyList()

            viewModel.loadPharmacies()
            advanceUntilIdle()

            assertEquals(PharmaciesUiState.Empty, viewModel.uiState.value)
        }

    @Test
    fun `should set error state`() =
        runTest {
            everySuspend { repository.getPharmacies() } throws RuntimeException("Something went wrong")

            viewModel.loadPharmacies()
            advanceUntilIdle()

            assertTrue(viewModel.uiState.value is PharmaciesUiState.Error)
        }
}

private fun buildPharmacy(name: String): Pharmacy {
    return Pharmacy(
        uf = "RJ",
        cep = "3304550",
        municipio = "Rio de Janeiro",
        cnpj = "98.765.432/0001-09",
        farmacia = name,
        endereco = "Av. Exemplo, 456",
        bairro = "Zona Sul",
        dataCredenciamento = "2022-01-15"
    )
}